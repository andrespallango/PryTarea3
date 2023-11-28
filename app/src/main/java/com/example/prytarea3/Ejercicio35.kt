package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Ejercicio35 : AppCompatActivity() {

    private lateinit var etPalabraP: EditText
    private lateinit var etNumC: EditText
    private lateinit var etNumR: EditText
    private lateinit var btEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio35)

        // Mapeo de objetos
        etPalabraP = findViewById(R.id.et_palabrap)
        etNumC = findViewById(R.id.et_numc)
        etNumR = findViewById(R.id.et_numr)
        btEnviar = findViewById(R.id.bt_enviar)

        btEnviar.setOnClickListener {
            calcularResultados()
        }
    }

    private fun calcularResultados() {
        val palabra = etPalabraP.text.toString()
        val numCopicoStr = etNumC.text.toString()
        val numRadianesStr = etNumR.text.toString()

        val numCopico = if (numCopicoStr.isNotEmpty()) numCopicoStr.toInt() else null
        val numRadianes = if (numRadianesStr.isNotEmpty()) numRadianesStr.toDouble() else null

        val intent = Intent(this, MostrarEjer35::class.java)
        intent.putExtra("palabra", palabra)
        intent.putExtra("numC", numCopico)
        intent.putExtra("numR", numRadianes)
        startActivity(intent)
    }

}
