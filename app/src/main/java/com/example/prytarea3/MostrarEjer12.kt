package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MostrarEjer12 : AppCompatActivity() {

    private lateinit var tvNumPrimo: TextView
    private lateinit var tvNumFactorial: TextView
    private lateinit var bt_regresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ejer12)

        // Mapeo de objetos
        tvNumPrimo = findViewById(R.id.tv_numprimo)
        tvNumFactorial = findViewById(R.id.tv_numf)
        bt_regresar = findViewById(R.id.bt_regresa)

        val numPrimo = intent.getIntExtra("numeroPrimo", 0)
        val numFactorial = intent.getIntExtra("numeroFactorial", 0)

        // Realizar cálculos
        val esPrimo = esPrimo(numPrimo)
        val factorial = calcularFactorial(numFactorial)

        // Mostrar resultados en los TextView
        mostrarResultadoPrimo(esPrimo, numPrimo)
        mostrarResultadoFactorial(factorial, numFactorial)

        // Configurar el OnClickListener para el botón de regresar
        bt_regresar.setOnClickListener {
            // Iniciar una nueva actividad para ir a Menu.kt
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun esPrimo(numero: Int): Boolean {
        if (numero < 2) return false
        for (i in 2 until numero) {
            if (numero % i == 0) {
                return false
            }
        }
        return true
    }

    private fun calcularFactorial(numero: Int): Int {
        if (numero == 0 || numero == 1) {
            return 1
        }
        return numero * calcularFactorial(numero - 1)
    }

    private fun mostrarResultadoPrimo(esPrimo: Boolean, numero: Int) {
        val mensaje = if (esPrimo) {
            "El número $numero es primo"
        } else {
            "El número $numero no es primo"
        }
        tvNumPrimo.text = mensaje
    }

    private fun mostrarResultadoFactorial(factorial: Int, numero: Int) {
        val mensaje = "El número $numero tiene como factorial: $factorial"
        tvNumFactorial.text = mensaje
    }
}

