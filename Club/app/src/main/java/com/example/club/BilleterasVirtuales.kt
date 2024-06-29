package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class BilleterasVirtuales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billeteras_virtuales)


        var itemMp: LinearLayout = findViewById(R.id.itemMp)
        var btnVolverPagos: Button = findViewById(R.id.btnVolverPagos)

        itemMp.setOnClickListener {
            val intent: Intent = Intent(this, DetalleBilleteraActivity::class.java)
            startActivity(intent)
        }
        btnVolverPagos.setOnClickListener {
            val intent = Intent(this, SeleccionFomaPagoActivity::class.java)
            startActivity(intent)
        }
    }
}