package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleUsuarioNoSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_usuario_no_socio)

        // Recupera los datos pasados con el Intent
        val nombre = intent.getStringExtra("nombre") ?: "N/A"
        val apellido = intent.getStringExtra("apellido") ?: "N/A"
        val fechaNac = intent.getStringExtra("fechaNac") ?: "N/A"
        val domicilio = intent.getStringExtra("domicilio") ?: "N/A"
        val telefono = intent.getStringExtra("telefono") ?: "N/A"
        val aptoFisico = intent.getStringExtra("aptoFisico") ?: "N/A"

        findViewById<TextView>(R.id.textViewNombre).text = nombre + " " + apellido
        findViewById<TextView>(R.id.textViewFechaNac).text = fechaNac
        findViewById<TextView>(R.id.textViewDomicilio).text = domicilio
        findViewById<TextView>(R.id.textViewTelefono).text = "+54 " +  telefono

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