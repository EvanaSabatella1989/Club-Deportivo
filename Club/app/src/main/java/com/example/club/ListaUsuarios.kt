package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
//import android.widget.ArrayAdapter
//import android.widget.ListView
//import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.database.sqlite.SQLiteDatabase
import com.example.club.models.persona
import com.example.club.models.personaAdapter

class ListaUsuarios : AppCompatActivity() {

    //private lateinit var db: SQLiteDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: personaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)

        // Configura la base de datos
        //val dbHelper = DatabaseHelper(this)
        //db = dbHelper.readableDatabase

        // Recupera los datos de las personas
        //val personas = obtenerPersonas(db)

        // Configura el RecyclerView
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
       // adapter = personaAdapter(personas)
       // recyclerView.adapter = adapter
        val dbHelper = DatabaseHelper(this)
        val listaPersonas: MutableList<persona> = dbHelper.obtenerPersonas()

        // Configura el adaptador con la lista de actividades
        //val adapter = personaAdapter(listaPersonas)
       // recyclerView.adapter = adapter

        adapter = personaAdapter(listaPersonas) { persona ->
            // Aquí manejas el clic y navegas a la actividad correspondiente
            if (persona.isSocio) {
                // Navegar a SocioActivity
                val intent = Intent(this, DetalleUsuarioSocioActivity::class.java).apply {
                    putExtra("id", persona.idPersona)
                    putExtra("nombre", persona.nombre)
                    putExtra("apellido", persona.apellido)
                    putExtra("fechaNac", persona.fechaNac)
                    putExtra("dni", persona.dni)
                    putExtra("domicilio", persona.domicilio)
                    putExtra("telefono", persona.telefono)
                    putExtra("aptoFisico", if(persona.aptoFisico) 1 else 0)
                }
                startActivity(intent)
            } else {
                // Navegar a NoSocioActivity
                val intent = Intent(this, DetalleUsuarioNoSocioActivity::class.java).apply {
                    putExtra("id", persona.idPersona)
                    putExtra("nombre", persona.nombre)
                    putExtra("apellido", persona.apellido)
                    putExtra("fechaNac", persona.fechaNac)
                    putExtra("dni", persona.dni)
                    putExtra("domicilio", persona.domicilio)
                    putExtra("telefono", persona.telefono)
                    putExtra("aptoFisico", if(persona.aptoFisico) 1 else 0)
                }
                startActivity(intent)
            }
        }
        recyclerView.adapter = adapter


        val btn: Button = findViewById(R.id.button_add)
        btn.setOnClickListener {
            val intent: Intent = Intent(this, CrearUsuario::class.java)
            startActivity(intent)
        }

      //  val itemUsuarioSocio: LinearLayout = findViewById(R.id.itemUsuarioSocio)
      //  itemUsuarioSocio.setOnClickListener {
      //      val intent: Intent = Intent(this, DetalleUsuarioSocioActivity::class.java)
      //      startActivity(intent)
      //  }

       // val itemUsuarioNoSocio: LinearLayout = findViewById(R.id.itemUsuarioNoSocio)
       // itemUsuarioNoSocio.setOnClickListener {
       //     val intent: Intent = Intent(this, DetalleUsuarioNoSocioActivity::class.java)
       //     startActivity(intent)
       // }


    }
}
