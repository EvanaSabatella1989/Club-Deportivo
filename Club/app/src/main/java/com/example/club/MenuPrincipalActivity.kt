package com.example.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuPrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val btnUsuarios: Button = findViewById(R.id.btnUsuarios)
        val btnActividades: Button = findViewById(R.id.btnActividades)
        val btnCuotas: Button = findViewById(R.id.btnCuotas)
        val btnSalir: Button = findViewById(R.id.btnSalir)

        btnUsuarios.setOnClickListener {
            val intent: Intent = Intent(this, ListaUsuarios::class.java)
            startActivity(intent)
        }

        btnActividades.setOnClickListener {
            val intent: Intent = Intent(this, ABMActividadesActivity::class.java)
            startActivity(intent)
        }

        btnCuotas.setOnClickListener {
            val intent: Intent = Intent(this, ListaDeCuotasActivity::class.java)
            startActivity(intent)
        }

        btnSalir.setOnClickListener {
            val intent: Intent = Intent(this, InicioSesionActivity::class.java)
            startActivity(intent)
        }
    }
}