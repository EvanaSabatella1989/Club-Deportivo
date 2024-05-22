package com.example.club

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class PagoTarjetaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_tarjeta)

        val spinnerCuotas : Spinner = findViewById(R.id.spinnerPagoTarjeta)
        val listaCuotas = arrayOf("Cantidad de Cuota", "3 cuotas", "6 cuotas")
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaCuotas)
        spinnerCuotas.adapter = adaptador
    }
}