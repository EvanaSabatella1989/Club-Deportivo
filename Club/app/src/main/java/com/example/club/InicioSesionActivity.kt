package com.example.club

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class InicioSesionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

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