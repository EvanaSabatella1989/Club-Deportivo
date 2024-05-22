package com.example.club

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PagoTarjeta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_tarjeta)

        val spinnerCuotas : Spinner = findViewById(R.id.spinnerPagoTarjeta)
        val listaCuotas = arrayOf("Cantidad de Cuota", "3 cuotas", "6 cuotas")
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaCuotas)
        spinnerCuotas.adapter = adaptador
    }
}