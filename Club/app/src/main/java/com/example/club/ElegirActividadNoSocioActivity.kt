package com.example.club

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.club.DatabaseHelper
import com.example.club.models.Actividad
import com.example.club.models.ActividadAdapter

class ElegirActividadNoSocioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir_actividad_no_socio)

        // Obtén el RecyclerView del layout
        val recyclerViewActividades: RecyclerView = findViewById(R.id.recyclerViewActividades)

        // Configura el LayoutManager para el RecyclerView
        recyclerViewActividades.layoutManager = LinearLayoutManager(this)

        // Obtén los datos de la base de datos
        val dbHelper = DatabaseHelper(this)
        val listaActividades: MutableList<Actividad> = dbHelper.traerDatosActividades()

        // Configura el adaptador con la lista de actividades
        val adapter = ActividadAdapter(listaActividades)
        recyclerViewActividades.adapter = adapter
    }

}