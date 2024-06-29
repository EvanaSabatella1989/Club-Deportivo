package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PagoNoSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pago_no_socio)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val precio = intent.getDoubleExtra("precio", 0.0)

        val importeFinalTextView: TextView = findViewById(R.id.textViewImporteFinal)
        val precioFormateado = String.format("%.2f", precio)
        importeFinalTextView.text = getString(R.string.valor_importe_final_actividad, "$$precioFormateado")

        val itemTarjeta: LinearLayout = findViewById(R.id.itemTarjeta)
        val itemBilletera: LinearLayout = findViewById(R.id.itemBilletera)
        val itemEfectivo: LinearLayout = findViewById(R.id.itemEfectivo)

        itemTarjeta.setOnClickListener {
            val intent = Intent(this, PagoTarjetaActivity::class.java)
            startActivity(intent)
        }

        itemBilletera.setOnClickListener {
            val intent = Intent(this, BilleterasVirtuales::class.java)
            startActivity(intent)
        }

        itemEfectivo.setOnClickListener {
            val intent = Intent(this, PagoEfectivo::class.java)
            startActivity(intent)
        }
    }
}
