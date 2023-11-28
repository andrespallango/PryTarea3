package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class Ejercicio12 : AppCompatActivity() {

    private lateinit var etNump: EditText
    private lateinit var etNumf: EditText
    private lateinit var btCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12)

        // Mapeo de objetos
        etNump = findViewById(R.id.et_nump)
        etNumf = findViewById(R.id.et_numf)
        btCalcular = findViewById(R.id.bt_calcularfp)

        btCalcular.setOnClickListener {
            calcularResultados()
        }
    }

    private fun calcularResultados() {
        val numPrimoStr = etNump.text.toString()
        val numFactorialStr = etNumf.text.toString()

        if (numPrimoStr.isNotEmpty() && numFactorialStr.isNotEmpty()) {
            val numPrimo = numPrimoStr.toInt()
            val numFactorial = numFactorialStr.toInt()

            val intent = Intent(this, MostrarEjer12::class.java)
            intent.putExtra("numeroPrimo", numPrimo)
            intent.putExtra("numeroFactorial", numFactorial)
            startActivity(intent)
        }
    }
}


