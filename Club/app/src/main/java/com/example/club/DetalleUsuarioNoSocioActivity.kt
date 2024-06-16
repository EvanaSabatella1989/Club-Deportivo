package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetalleUsuarioNoSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_usuario_no_socio)

        val btnNuevaActividad: Button = findViewById(R.id.btnNuevaActividad)

        btnNuevaActividad.setOnClickListener {
            val intent: Intent = Intent(this, ElegirActividadNoSocioActivity::class.java)
            startActivity(intent)
        }

        val btnModificar: Button = findViewById(R.id.btnModificar)

        btnModificar.setOnClickListener {
            val intent: Intent = Intent(this, modificar_usuario_nosocio_Activity::class.java)
            startActivity(intent)
        }
    }
}