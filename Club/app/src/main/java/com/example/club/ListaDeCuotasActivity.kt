package com.example.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ListaDeCuotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_de_cuotas)

        val btnPagar: Button = findViewById(R.id.btnPagar)

        btnPagar.setOnClickListener {
            val intent: Intent = Intent(this, SeleccionFomaPagoActivity::class.java)
            startActivity(intent)
        }
    }
}