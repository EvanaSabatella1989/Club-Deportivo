package com.example.club

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.club.databinding.ActivityListaDeCuotasBinding
import com.example.club.databinding.ActivityMainBinding
import com.example.club.models.cuota
import com.example.club.models.cuotaPersona


class ListaDeCuotasActivity : AppCompatActivity() {
    private var peliculas = emptyList<String>()
    lateinit var arrayAdapter: ArrayAdapter<*>
    private lateinit var binding: ActivityListaDeCuotasBinding
    var Cuotas: ArrayList<cuotaPersona> = ArrayList()
    private lateinit var helper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListaDeCuotasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        helper= DatabaseHelper(this)

        Cuotas=ArrayList(helper.obtenerCuotaPersona())
        //Cuotas=helper.obtenerCuotaPersona().toCollection(ArrayList<cuotaPersona>())
        /*Cuotas.add(cuotaPersona("ricardo","lopez",2569871,true,"20500.0","26-10-2024","mayo-24","25-04-24"))
        Cuotas.add(
            cuotaPersona("antonio","lorenzo",2569871,true,"20500.0","26-10-2024","mayo-24","25-04-24"
            ))*/



       /* val btnPagar: Button = findViewById(R.id.btnPagar)

        btnPagar.setOnClickListener {
            val intent: Intent = Intent(this, SeleccionFomaPagoActivity::class.java)
            startActivity(intent)*/
        //}
        var adapter= BaseAdapter(this,Cuotas)
        binding.listaCuotas.adapter  =adapter

    }
}