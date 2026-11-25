package com.example.appdao

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val txtIMC = findViewById<TextView>(R.id.txtIMC)
        val txtClassificacao = findViewById<TextView>(R.id.txtClassificacao)

        val imc = intent.getDoubleExtra("IMC", 0.0)

        val classificacao = when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 25.0 -> "Peso ideal"
            imc < 30.0 -> "Sobrepeso"
            else -> "Obesidade"
        }

        txtIMC.text = "Seu IMC: %.2f".format(imc)
        txtClassificacao.text = classificacao
    }
}