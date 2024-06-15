package com.example.club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Spinner

class PagoEfectivo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_efectivo)
        val spinner: Spinner = findViewById(R.id.spinner_cuotas)
        val cuotasArray = resources.getStringArray(R.array.cuotas_array)

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            cuotasArray
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }
}