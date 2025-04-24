package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtUsuario = findViewById<EditText>(R.id.txtUsuario)
        val txtContrasena = findViewById<EditText>(R.id.txtContrasena)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
        val btnRetroceso = findViewById<ImageButton>(R.id.btnRetroceso) // Obtener referencia al botón de retroceso

        btnIngresar.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val contrasena = txtContrasena.text.toString()

            if (usuario.isNotEmpty() && contrasena.isNotEmpty()) {
                val prefs = getSharedPreferences("mi_app_prefs", Context.MODE_PRIVATE)
                prefs.edit().putString("usuario", usuario).apply()

                val intent = Intent(this, MainActivity::class.java) // temporal, luego cambiaremos
                startActivity(intent)
                finish()
            }
        }

        // Agregar OnClickListener al botón de retroceso
        btnRetroceso.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Opcional: cierra la LoginActivity para que no quede en la pila de actividades
        }
    }
}