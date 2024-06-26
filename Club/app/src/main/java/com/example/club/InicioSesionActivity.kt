package com.example.club

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InicioSesionActivity : AppCompatActivity() {
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_sesion)

        val btn: Button = findViewById(R.id.botonIngresar)
        //btn.setOnClickListener {
       //     val intent: Intent = Intent(this, MenuPrincipalActivity::class.java)
       //     startActivity(intent)
      //  }

        val editTextUsuario: EditText = findViewById(R.id.editTextUsuario)
      //  editTextUsuario.setOnFocusChangeListener { v, hasFocus ->
      //      if (hasFocus) {
      //          editTextUsuario.setText("")
      //      }
      //  }
        val editTextContrasena: EditText = findViewById(R.id.editTextContrasena)
      //  editTextContrasena.setOnFocusChangeListener { v, hasFocus ->
      //      if (hasFocus) {
      //          editTextContrasena.setText("")
      //      }

        databaseHelper = DatabaseHelper(this)

        btn.setOnClickListener {
            val username = editTextUsuario.text.toString()
            val password = editTextContrasena.text.toString()

            if(databaseHelper.validateUser(username, password)){
                val intent = Intent(this, MenuPrincipalActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

    }
}