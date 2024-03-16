package com.william.applista.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.william.applista.R
import com.william.applista.models.Contato



class ListaContatosAdapter(private val contatos: List<Contato>) :
        RecyclerView.Adapter<ListaContatosAdapter.ContatoViewHolder>(){

    class ContatoViewHolder(v: View) : RecyclerView.ViewHolder(v){
        //... TextViews para telefone, endereço...
        var nome: TextView
        var telefone: TextView
        var foto: ImageView

        init{
            nome = v.findViewById(R.id.txtNome)
            telefone = v.findViewById(R.id.txtTelefone)
            foto = v.findViewById(R.id.imgFoto)

            v.setOnLongClickListener {
                position = adapterPosition
                return@setOnLongClickListener false;
            }

            v.setOnCreateContextMenuListener { contextMenu, view, contextMenuInfo ->  {

            }}
        }

        fun setPosition(position:Int){
            this.position = position
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)
        return ContatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val nome:TextView = holder.itemView.findViewById(R.id.txtNome)
        val telefone:TextView = holder.itemView.findViewById(R.id.txtTelefone)
        val foto = holder.foto

        nome.setText(contatos.get(position).nome)
        telefone.setText(contatos.get(position).telefone)
    }

    override fun getItemCount(): Int {
        return contatos.count()
    }
}