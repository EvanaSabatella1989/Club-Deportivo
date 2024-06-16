package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetalleUsuarioSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_usuario_socio)

        val btnVerCarnet: Button = findViewById(R.id.btnVerCarnet)
        btnVerCarnet.setOnClickListener {
            val intent: Intent = Intent(this, CarnetActivity::class.java)
            startActivity(intent)
        }

        val btnVerCuotas: Button = findViewById(R.id.btnNuevaActividad)
        btnVerCuotas.setOnClickListener {
            val intent: Intent = Intent(this, ListaCuotaSocios::class.java)
            startActivity(intent)
        }

        val btnModificarUsuario: Button = findViewById(R.id.btnModificar)
        btnModificarUsuario.setOnClickListener {
            val intent: Intent = Intent(this, ModificarUsuarioSocioActivity::class.java)
            startActivity(intent)
        }
    }
}