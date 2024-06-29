package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class PagoTarjetaActivity : AppCompatActivity() {
    private lateinit var helper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_tarjeta)

        helper= DatabaseHelper(this)

        val spinnerCuotas : Spinner = findViewById(R.id.spinnerPagoTarjeta)
        val listaCuotas = arrayOf("Cantidad de Cuotas", "3 cuotas", "6 cuotas")
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listaCuotas)
        spinnerCuotas.adapter = adaptador

        val buttonAceptar: Button = findViewById(R.id.buttonAceptar)
        val idCuota= intent.getIntExtra("idCuota",0)
        buttonAceptar.setOnClickListener {
        if(idCuota!=0) {
           helper.pagarCuota(idCuota, "Tarjeta")

            val intent: Intent = Intent(this, ListaDeCuotasActivity::class.java)
            startActivity(intent)
        }else{
            val intent: Intent = Intent(this, DetalleUsuarioNoSocioActivity::class.java)
            startActivity(intent)
        }
            }
    }
}