package com.example.club

import android.content.Intent
import android.content.Context
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeleccionFomaPagoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seleccion_foma_pago)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var itemTarjeta: LinearLayout = findViewById(R.id.itemTarjeta)
        var itemBilletera: LinearLayout = findViewById(R.id.itemBilletera)
        var itemEfectivo: LinearLayout = findViewById(R.id.itemEfectivo)

        val monto= intent.getStringExtra("monto")?:""
        val idCuota= intent.getIntExtra("idCuota",0)
        val textViewMonto= findViewById<TextView>(R.id.importeFinal)

        textViewMonto.text="S $monto"

        itemTarjeta.setOnClickListener {
            val intent = Intent(this,PagoTarjetaActivity::class.java).apply {
                putExtra("idCuota", idCuota)
            }
            startActivity(intent)
        }

        itemBilletera.setOnClickListener {
            val intent = Intent(this,BilleterasVirtuales::class.java).apply {
                putExtra("idCuota", idCuota)
            }
            startActivity(intent)
        }


        itemEfectivo.setOnClickListener {
            val intent = Intent(this, PagoEfectivo::class.java).apply {
                putExtra("idCuota", idCuota)
            }
            startActivity(intent)
        }
    }
}