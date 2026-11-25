package com.example.appdao

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        btnCalcular.setOnClickListener {

            val peso = edtPeso.text.toString().toDoubleOrNull()
            val altura = edtAltura.text.toString().toDoubleOrNull()

            if (peso == null || altura == null || peso <= 0 || altura <= 0) {
                Toast.makeText(
                    this,
                    "Digite um peso e uma altura válidos.",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val imc = peso / (altura * altura)

            val intent = Intent(this, ResultadoActivity::class.java)
            intent.putExtra("IMC", imc)
            startActivity(intent)
        }
    }
}