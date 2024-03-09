package com.william.applista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.william.applista.adapters.ListaContatosAdapter
import com.william.applista.dao.DaoContatos

class MainActivity : AppCompatActivity() {

    lateinit var listContatos:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listContatos = findViewById(R.id.listContatos)
        val dao = DaoContatos()
        listContatos.adapter = ListaContatosAdapter(dao.listaContatos())
    }
}