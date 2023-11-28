package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MostrarEjer35 : AppCompatActivity() {

    private lateinit var tvPalabra: TextView
    private lateinit var tvNumC: TextView
    private lateinit var tvAngS: TextView
    private lateinit var tvAngC: TextView
    private lateinit var tvMsg: TextView
    private lateinit var bt_regresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_ejer35)

        // Mapeo de objetos
        tvPalabra = findViewById(R.id.tv_palap)
        tvNumC = findViewById(R.id.tv_numco)
        tvAngS = findViewById(R.id.tv_angs)
        tvAngC = findViewById(R.id.tv_angc)
        tvMsg=findViewById(R.id.tv_mensaje)
        bt_regresar = findViewById(R.id.bt_regresar)

        // Obtener valores de la intención
        val palabra = intent.getStringExtra("palabra") ?: ""
        val numC = intent.getIntExtra("numC", 0)
        val numR = intent.getDoubleExtra("numR", 0.0)


        // Mostrar resultados en los TextView
        //Ejercicio 3

        // Verificar si la palabra es palíndroma
        val esPalindroma = esPalindroma(palabra)

        // Mostrar el resultado en el TextView
        val mensajePalindroma = if (esPalindroma) {
            "La palabra es palíndroma."
        } else {
            "La palabra no es palíndroma."
        }
        tvPalabra.text = mensajePalindroma

        //Ejercicio4

        // Verificar si el número es capicúa
        val esCapicua = esCapicua(numC)

        // Mostrar el resultado en el TextView
        val mensajeCapicua = if (esCapicua) {
            "El número es capicúa."
        } else {
            "El número no es capicúa."
        }
        tvNumC.text = mensajeCapicua

        //Ejercicio5
        //Mensaje
        tvMsg.text="El Angulo en radianes $numR transformado a:"
        // Convertir ángulo de radianes a sexagesimal
        val anguloSexagesimal = convertirARadianesASexagesimal(numR)
        tvAngS.text = "Grado Sexagesimal: $anguloSexagesimal"

        // Convertir ángulo de radianes a centesimales
        val anguloCentesimal = convertirARadianesACentesimales(numR)
        tvAngC.text = "Grado Centesimal: $anguloCentesimal"

        // Configurar el OnClickListener para el botón de regresar
        bt_regresar.setOnClickListener {
            // Iniciar una nueva actividad para ir a Menu.kt
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }

    private fun convertirARadianesASexagesimal(anguloRadianes: Double): String {
        val anguloSexagesimal = anguloRadianes * (180 / Math.PI)
        return String.format("%.2f", anguloSexagesimal)
    }

    private fun convertirARadianesACentesimales(anguloRadianes: Double): String {
        val anguloCentesimal = anguloRadianes * (200 / Math.PI)
        return String.format("%.2f", anguloCentesimal)
    }
    fun esPalindroma(palabra: String): Boolean {
        val palabraLimpia = palabra.replace("\\s".toRegex(), "").toLowerCase()
        val longitud = palabraLimpia.length
        for (i in 0 until longitud / 2) {
            if (palabraLimpia[i] != palabraLimpia[longitud - i - 1]) {
                return false
            }
        }
        return true
    }
    fun esCapicua(numero: Int): Boolean {
        val numeroString = numero.toString()
        val longitud = numeroString.length
        for (i in 0 until longitud / 2) {
            if (numeroString[i] != numeroString[longitud - i - 1]) {
                return false
            }
        }
        return true
    }


}
