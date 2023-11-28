/*package com.example.prytarea3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/
package com.example.prytarea3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContrasenia: EditText
    private lateinit var btnLogin: Button
    private val user = "Andres"
    private val password = "root"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mapeo de objetos
        txtUsuario = findViewById(R.id.et_usuario)
        txtContrasenia = findViewById(R.id.et_contrasenia)
        btnLogin = findViewById(R.id.bt_login)

        // Método onClick
        btnLogin.setOnClickListener(View.OnClickListener {
            // Declaración de variables
            var usuario: String
            var contrasenia: String

            // Recibir datos del texto
            usuario = txtUsuario.text.toString()
            contrasenia = txtContrasenia.text.toString()

            if (usuario.length != 0) {
                if (usuario == user) {
                    // Verificar contraseña
                    if (contrasenia.length != 0) {
                        if (contrasenia == password) {
                            // Conexión a otra actividad getApplicationContext
                            Toast.makeText(this@MainActivity, "Datos Correctos", Toast.LENGTH_SHORT).show()
                            // Llamar class Intent
                            val conec = Intent(this@MainActivity, Menu::class.java)
                            conec.putExtra("usuario", usuario)
                            startActivity(conec)
                        } else {
                            Toast.makeText(this@MainActivity, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "No dejar campos vacios", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Usuario incorrecto", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@MainActivity, "No dejar campos vacios", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
