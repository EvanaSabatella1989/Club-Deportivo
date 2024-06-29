package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class BilleterasVirtuales : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_billeteras_virtuales)


        var itemMp: LinearLayout = findViewById(R.id.itemMp)
        val idCuota= intent.getIntExtra("idCuota",0)
        itemMp.setOnClickListener {

            val intent = Intent(this,DetalleBilleteraActivity::class.java).apply {
                putExtra("idCuota", idCuota)
            }
            startActivity(intent)
        }
    }
}