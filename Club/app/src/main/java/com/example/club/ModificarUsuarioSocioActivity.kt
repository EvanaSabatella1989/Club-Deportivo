package com.example.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ModificarUsuarioSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_usuario_socio)

        val btnActualizar: Button = findViewById(R.id.btnActualizar)
        btnActualizar.setOnClickListener {
            val intent: Intent = Intent(this, DetalleUsuarioSocioActivity::class.java)
            startActivity(intent)
        }
    }
}