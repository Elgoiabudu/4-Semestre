package lucas.mend0n.app_intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btNovatela : Button
    lateinit var btMapa : Button
    lateinit var btWeb : Button
    lateinit var btContato : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btNovatela = findViewById(R.id.btNovaTela)
        btMapa = findViewById(R.id.btMapa)
        btWeb = findViewById(R.id.btWeb)
        btContato = findViewById(R.id.btContato)

        btWeb.setOnClickListener { abrirSite() }
        btMapa.setOnClickListener { abrirMapa() }
        btContato.setOnClickListener { abrirContato() }
    }

    private fun abrirMapa(){
        var uri:Uri = Uri.parse("geo:-23.66341857070195, -46.45985658227145?z=17")

        var intent:Intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun abrirSite(){
        var uri:Uri = Uri.parse("https://www.google.com.br")

        var intent:Intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    private fun abrirContato(){
        var uri:Uri = Uri.parse("content://contacts/people")

        var intent:Intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}