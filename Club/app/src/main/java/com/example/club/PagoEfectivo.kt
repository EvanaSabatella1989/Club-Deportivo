package com.example.club

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class PagoEfectivo : AppCompatActivity() {
    private lateinit var helper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_efectivo)

        helper= DatabaseHelper(this)

        val spinner: Spinner = findViewById(R.id.spinner_cuotas)
        val cuotasArray = resources.getStringArray(R.array.cuotas_array)

        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,
            cuotasArray
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        val buttonAceptar: Button = findViewById(R.id.btnVerCarnet)
        val idCuota= intent.getIntExtra("idCuota",0)
        buttonAceptar.setOnClickListener {
            if(idCuota!=0) {
                helper.pagarCuota(idCuota, "Efectivo")

                val intent: Intent = Intent(this, ListaDeCuotasActivity::class.java)
                startActivity(intent)
            }else{
                val intent: Intent = Intent(this, DetalleUsuarioNoSocioActivity::class.java)
                startActivity(intent)
            }
        }
    }
}