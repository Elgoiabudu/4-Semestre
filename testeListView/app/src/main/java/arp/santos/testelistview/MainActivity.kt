package arp.santos.testelistview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import arp.santos.testelistview.adapters.ListaContatoAdapter
import arp.santos.testelistview.dao.DaoContato
import arp.santos.testelistview.models.Contato


class MainActivity : AppCompatActivity() {

    lateinit var listaContatos:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaContatos = findViewById(R.id.listContatos)
        val dao = DaoContato()
        listaContatos.adapter = ListaContatoAdapter(dao.listaContatos())

        
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val adapter: ListaContatoAdapter =  listaContatos.adapter as ListaContatoAdapter
        val posicao: Int = adapter.posicaoClicada
        val dao = DaoContato()
        val contato: Contato = dao.listaContatos().get(posicao)

        if(item.itemId==R.id.menu_mapa)
        {
            val uri: Uri = Uri.parse("geo:0,0?q="+ contato.endereco+"&z=18")
            val intent:Intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if (item.itemId==R.id.menu_ligacao)
        {
            val uri: Uri = Uri.parse("tel:"+ contato.telefone)
            val intent:Intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if (item.itemId==R.id.menu_email)
        {
            val uri: Uri = Uri.parse("mailto:"+ contato.email)
            val intent:Intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }
        else if(item.itemId==R.id.menu_detalhes)
        {
            val intent:Intent = Intent(this, DetalhesContatoActivity::class.java)
            intent.putExtra("contato", contato)
            startActivity(intent)
        }





        return super.onContextItemSelected(item)
    }
}