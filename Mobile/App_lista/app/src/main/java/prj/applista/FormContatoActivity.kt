package prj.applista

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import prj.applista.api.ApiClient
import prj.applista.interfaces.ContatoService
import prj.applista.models.Contato
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormContatoActivity : AppCompatActivity() {
    lateinit var txtFormNome: EditText
    lateinit var txtFormTelefone: EditText
    lateinit var txtFormEmail: EditText
    lateinit var txtFormEndereco: EditText
    lateinit var btFormSalvar: Button
    var contato:Contato? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_contato)

        txtFormNome = findViewById(R.id.txtFormNome)
        txtFormEmail = findViewById(R.id.txtFormEmail)
        txtFormEndereco = findViewById(R.id.txtFormEndereco)
        txtFormTelefone = findViewById(R.id.txtFormTelefone)
        btFormSalvar = findViewById(R.id.btFormSalvar)

        btFormSalvar.setOnClickListener { salvarContato() }

        if (intent.hasExtra("contato")){

            contato = intent.getSerializableExtra("contato") as Contato
            exibirDadosContato()

        }

    }

    private fun exibirDadosContato() {
        txtFormNome.setText(contato!!.nome)
        txtFormTelefone.setText(contato!!.telefone)
        txtFormEmail.setText(contato!!.email)
        txtFormEndereco.setText(contato!!.endereco)
    }




    private fun salvarContato() {
        if(contato== null){
            cadastrarContato()
        }else{
            atualizarContato()
        }
    }

    private fun atualizarContato(){
        var call = ApiClient.client.create(ContatoService::class.java)
        preencherDados()

        call.updateContato(contato!!._id, contato!!).enqueue(object : Callback<Contato>{
            override fun onResponse(call: Call<Contato>, response: Response<Contato>) {
                if (response.isSuccessful){
                    Toast.makeText(this@FormContatoActivity, "Contato atualizado", Toast.LENGTH_LONG).show()
                    this@FormContatoActivity.finish()
                }
            }

            override fun onFailure(call: Call<Contato>, t: Throwable) {
                Toast.makeText(this@FormContatoActivity, "Erro de atualização", Toast.LENGTH_LONG).show()
            }

        })

    }

    private fun preencherDados() {
        contato!!.nome = txtFormNome.text.toString()
        contato!!.endereco = txtFormEndereco.text.toString()
        contato!!.email = txtFormEmail.text.toString()
        contato!!.telefone = txtFormTelefone.text.toString()
    }

    private fun cadastrarContato() {
        var _contato: Contato = lerDadosContato()
        var call = ApiClient.client.create(ContatoService::class.java)
        call.createContato(_contato).enqueue(object : Callback<Contato> {
            override fun onResponse(call: Call<Contato>, response: Response<Contato>) {
                if (response.isSuccessful) {
                    Toast.makeText(
                        this@FormContatoActivity,
                        "Contato criado com sucesso",
                        Toast.LENGTH_LONG
                    ).show()
                    this@FormContatoActivity.finish()
                }
            }

            override fun onFailure(call: Call<Contato>, t: Throwable) {
                Log.e("Cadastro Contato", "onFailure: " + t.message)
            }

        })
    }

    private fun lerDadosContato(): Contato {
        var _contato = Contato(
            _id = "",
            nome = txtFormNome.text.toString(),
            email = txtFormEmail.text.toString(),
            telefone = txtFormTelefone.text.toString(),
            endereco = txtFormEndereco.text.toString(),
            foto = "#"
        )

        return _contato
    }
}