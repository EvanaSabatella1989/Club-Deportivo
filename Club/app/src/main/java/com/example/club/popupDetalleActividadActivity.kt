package com.example.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class popupDetalleActividadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_detalle_actividad)

        val btnAceptar: Button = findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener {
            val intent: Intent = Intent(this, ABMActividadesActivity::class.java)
            startActivity(intent)
        }
    }
}