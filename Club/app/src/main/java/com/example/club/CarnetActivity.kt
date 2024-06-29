package com.example.club

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CarnetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_carnet)

        // Recupera los datos pasados con el Intent
        val id = intent.getIntExtra("id", 0)
        val nombre = intent.getStringExtra("nombre") ?: "N/A"
        val apellido = intent.getStringExtra("apellido") ?: "N/A"
        val fechaNac = intent.getStringExtra("fechaNac") ?: "N/A"
        val dni = intent.getStringExtra("dni") ?: "N/A"
        val domicilio = intent.getStringExtra("domicilio") ?: "N/A"
        val telefono = intent.getStringExtra("telefono") ?: "N/A"
        val aptoFisico = intent.getStringExtra("aptoFisico") ?: "N/A"

        findViewById<TextView>(R.id.valor_nombre).text = nombre + " " + apellido
        findViewById<TextView>(R.id.valor_num_socio).text = id.toString()
        findViewById<TextView>(R.id.valor_dni).text = dni
        //findViewById<TextView>(R.id.valor_fecha_venc).text = fechaVenc

    }
}