package william.braz.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editPeso:EditText
    lateinit var editAltura:EditText
    lateinit var txtIMC:TextView
    lateinit var btnCalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        txtIMC = findViewById(R.id.txtIMC)
        btnCalcular = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            var peso:Double = editPeso.text.toString().toDouble()
            var altura:Double = editAltura.text.toString().toDouble()
            var imc:Double = peso/(altura*altura)

            txtIMC.text = imc.toString()

        }


    }
}