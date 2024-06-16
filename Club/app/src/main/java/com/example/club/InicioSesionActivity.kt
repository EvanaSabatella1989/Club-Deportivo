package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InicioSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        val btn: Button = findViewById(R.id.botonIngresar)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, MenuPrincipalActivity::class.java)
            startActivity(intent)
        }

        val editTextUsuario: EditText = findViewById(R.id.editTextUsuario)
        editTextUsuario.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editTextUsuario.setText("")
            }
        }
        val editTextContrasena: EditText = findViewById(R.id.editTextContrasena)
        editTextContrasena.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editTextContrasena.setText("")
            }
        }

    }
}