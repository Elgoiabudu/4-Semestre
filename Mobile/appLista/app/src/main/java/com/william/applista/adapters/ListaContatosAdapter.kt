package com.william.applista.adapters

import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.william.applista.R
import com.william.applista.models.Contato



class ListaContatosAdapter(private val contatos: List<Contato>) :
        RecyclerView.Adapter<ListaContatosAdapter.ContatoViewHolder>(){

    var posicao_clicada:Int = -1

    class ContatoViewHolder(v: View) : RecyclerView.ViewHolder(v){
        //... TextViews para telefone, endereço...
        var nome: TextView
        var telefone: TextView
        var foto: ImageView
        var email: TextView

        init{
            nome = v.findViewById(R.id.txtNome)
            telefone = v.findViewById(R.id.txtTelefone)
            foto = v.findViewById(R.id.imgFoto)
            email = v.findViewById(R.id.txtEmail)


            v.setOnCreateContextMenuListener { contextMenu, view, contextMenuInfo ->
                run {
                val menuInflater:MenuInflater = MenuInflater(view.context);
                menuInflater.inflate(R.menu.item_menu, contextMenu)
            }}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)
        return ContatoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val nome:TextView = holder.itemView.findViewById(R.id.txtNome)
        val telefone:TextView = holder.itemView.findViewById(R.id.txtTelefone)
        val email:TextView = holder.itemView.findViewById(R.id.txtEmail)
        val foto = holder.foto

        nome!!.setText(contatos.get(position).nome)
        telefone!!.setText(contatos.get(position).telefone)
        email!!.setText(contatos.get(position).email)

        holder.itemView.setOnLongClickListener { v ->
            posicao_clicada = holder.adapterPosition
            Log.i("Menu Position: ", "onBindViewHolder: "+ posicao_clicada)
            false
        }
    }

    override fun getItemCount(): Int {
        return contatos.count()
    }
}