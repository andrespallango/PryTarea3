package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {

    private lateinit var tvUsuario: TextView
    private lateinit var rdgMenu: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // Mapeo de objetos
        tvUsuario = findViewById(R.id.tv_usuario)
        rdgMenu = findViewById(R.id.rdg_menu)

        // Obtener el nombre de usuario pasado como extra
        val usuario = intent.getStringExtra("usuario")

        // Mostrar el nombre de usuario en el TextView
        tvUsuario.text = "Bienvenido $usuario"

        // Manejar eventos del RadioGroup
        rdgMenu.setOnCheckedChangeListener { group, checkedId ->
            val selectedRadioButton: RadioButton = findViewById(checkedId)

            // Determinar cuál RadioButton está seleccionado
            when (selectedRadioButton.id) {
                R.id.bt_ejer12 -> {
                    val intent = Intent(this@Menu, Ejercicio12::class.java)
                    startActivity(intent)
                }
                R.id.bt_ejer35 -> {
                    val intent = Intent(this@Menu, Ejercicio35::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
