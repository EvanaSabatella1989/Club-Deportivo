package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetalleBilleteraActivity : AppCompatActivity() {
    private lateinit var helper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_billetera)

        helper= DatabaseHelper(this)

        val buttonAceptar: Button = findViewById(R.id.botonAceptar)
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