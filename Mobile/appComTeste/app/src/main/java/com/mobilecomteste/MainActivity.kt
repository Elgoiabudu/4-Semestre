package com.mobilecomteste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var txtPeso:EditText
    lateinit var txtAltura:EditText
    lateinit var txtIMC:TextView
    lateinit var btCalcular:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtPeso = findViewById(R.id.txtPeso)
        txtAltura = findViewById(R.id.txtAltura)
        txtIMC = findViewById(R.id.txtIMC)
        btCalcular = findViewById(R.id.btCalcular)

        btCalcular.setOnClickListener{

            val peso:Double = txtPeso.text.toString().toDouble()
            val altura:Double = txtAltura.text.toString().toDouble()

            var imc:Double = peso / (altura * altura)

            txtIMC.text = imc.toString()
        }
    }
}