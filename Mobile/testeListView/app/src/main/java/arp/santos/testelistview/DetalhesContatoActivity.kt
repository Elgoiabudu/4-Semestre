package arp.santos.testelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import arp.santos.testelistview.models.Contato

class DetalhesContatoActivity : AppCompatActivity() {
    var contato:Contato?=null
    var txtNome:EditText?=null
    var txtEmail:EditText?=null
    var txtTelefone:EditText? = null
    var txtEndereco:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_contato)

        txtNome = findViewById(R.id.txtNome)
        txtEmail = findViewById(R.id.txtEmail)
        txtEndereco = findViewById(R.id.txtEndereco)
        txtTelefone = findViewById(R.id.txtTelefone)

        if(this.intent.hasExtra("contato"))
        {
            contato = this.intent.getSerializableExtra("contato") as Contato?
            preencherContato()
        }

    }

    private fun preencherContato() {
        txtNome?.setText( contato?.nome)
        txtTelefone?.setText(contato?.telefone)
        txtEmail?.setText(contato?.email)
        txtEndereco?.setText(contato?.endereco)
    }
}