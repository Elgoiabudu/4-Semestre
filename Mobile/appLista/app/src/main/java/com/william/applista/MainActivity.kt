package com.william.applista

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.RecyclerView
import com.william.applista.adapters.ListaContatosAdapter
import com.william.applista.dao.DaoContatos
import com.william.applista.models.Contato

class MainActivity : AppCompatActivity() {

    lateinit var listContatos:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listContatos = findViewById(R.id.listContatos)
        val dao = DaoContatos()
        listContatos.adapter = ListaContatosAdapter(dao.listaContatos())
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val adapter: ListaContatosAdapter = listContatos.adapter as ListaContatosAdapter
        val posicao: Int = adapter.posicao_clicada
        val dao = DaoContatos()
        val contato: Contato = dao.listaContatos().get(posicao)

        if (item.itemId == R.id.menu_mapa){
            val uri: Uri = Uri.parse("geo:0,0?q="+contato.endereco+"&z=18")
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }else if (item.itemId == R.id.menu_ligacao){
            val uri: Uri = Uri.parse("tel:" +contato.telefone)
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }else if (item.itemId == R.id.menu_email){
            val uri: Uri = Uri.parse("mailto:" +contato.email)
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }else if (item.itemId==R.id.menu_detalhes){
            val intent:Intent = Intent(this, DetalhesContato::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }
}