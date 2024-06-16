package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CrearUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_usuario)

        val btn: Button = findViewById(R.id.btnModificar)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, CarnetActivity::class.java)
            startActivity(intent)
        }
    }
}