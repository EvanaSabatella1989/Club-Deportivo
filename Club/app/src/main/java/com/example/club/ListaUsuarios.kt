package com.example.club

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
//import android.widget.ArrayAdapter
//import android.widget.ListView
//import android.widget.SearchView

class ListaUsuarios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuarios)}}
        /*val searchView: SearchView = findViewById(R.id.searchView)
        val listaUsuario: ListView = findViewById(R.id.lista_usuarios)
        val usuarios = listOf(
            "Javier Rodríguez", "Mariano Cortez (Deudor)", "Miguel Angel",
            "Pablo Murias", "Ana Libedinsky", "Juan Carlos Lopez", "Andrea Gomez (Deudor)"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, usuarios)
        listaUsuario.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }
}*/