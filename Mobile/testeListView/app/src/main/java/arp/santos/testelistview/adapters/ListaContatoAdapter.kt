package arp.santos.testelistview.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import arp.santos.testelistview.R
import arp.santos.testelistview.models.Contato

class ListaContatoAdapter(private val contatos: List<Contato>) :
        RecyclerView.Adapter<ListaContatoAdapter.ContatoViewHolder>() {
    var posicaoClicada:Int =-1


    class ContatoViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        var nome:TextView
        var telefone:TextView
        var email:TextView
        //var endereco:TextView? = null
        var foto: ImageView






        init {

            nome = v.findViewById(R.id.txt_Nome)
            telefone = v.findViewById(R.id.txt_Telefone)
            email = v.findViewById(R.id.txt_Email)
            foto = v.findViewById(R.id.img_Foto)



            v.setOnCreateContextMenuListener { contextMenu, view, contextMenuInfo ->
                run {
                    val menuInflater: MenuInflater = MenuInflater(view.context)
                    menuInflater.inflate(R.menu.item_menu,contextMenu)

                }
            }
        }






    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato,parent, false)
        return ContatoViewHolder(view)

    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val nome = holder.nome
        val telefone = holder.telefone
        val email = holder.email
        val foto = holder.foto

        nome.setText(contatos.get(position).nome)
        telefone.setText(contatos.get(position).telefone)
        email.setText(contatos.get(position).email)

        holder.itemView.setOnLongClickListener { v->
            posicaoClicada = holder.adapterPosition
            Log.i("Menu", "onBindViewHolder: " + posicaoClicada)
            false
        }


    }

    override fun getItemCount(): Int {
        return contatos.count()


    }






}


