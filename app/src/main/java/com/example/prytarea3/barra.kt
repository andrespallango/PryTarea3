package com.example.prytarea3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ProgressBar

class barra : AppCompatActivity() {

    private lateinit var barraP : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barra)

        barraP = findViewById(R.id.progressBar)

        // Supongamos que deseas iniciar MainActivity después de 5 segundos
        Handler().postDelayed({
            // Crear un Intent para iniciar MainActivity
            val intent = Intent(this@barra, MainActivity::class.java)

            // Puedes agregar datos adicionales al Intent si es necesario
            // intent.putExtra("clave", valor)

            // Iniciar la actividad MainActivity
            startActivity(intent)

            // Cerrar la actividad actual para que no vuelva atrás al presionar el botón "Atrás"
            finish()
        }, 1000) // 5000 milisegundos = 5 segundos


    }
}