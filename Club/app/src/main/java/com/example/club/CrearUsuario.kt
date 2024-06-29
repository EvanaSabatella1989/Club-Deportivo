package com.example.club

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.parseInt

class CrearUsuario : AppCompatActivity() {
    lateinit var dbHelper: DatabaseHelper
    private lateinit var EditTextNombre: EditText
    private lateinit var EditTextApellido: EditText
    private lateinit var EditTextDni: EditText
    private lateinit var CheckBoxIsSocio: CheckBox
    private lateinit var EditTextFechaNac: EditText
    private lateinit var EditTextDomicilio: EditText
    private lateinit var EditTextTelefono: EditText
    private lateinit var btnAgregar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_usuario)

        //val btn: Button = findViewById(R.id.btnAgregarUsuario)
        //if(usuario is socio is checked):
        //btn.setOnClickListener {
        //    val intent: Intent = Intent(this, CarnetActivity::class.java)
        //    startActivity(intent)
              // mostrando mensaje que el usuario fue agregado correctamente
       // }
        //else{
        //    mostrar mensaje que el usuario (no socio ) fue agregado correctamente y volver al menu principal
        //

        dbHelper = DatabaseHelper(this)
        EditTextNombre = findViewById(R.id.EditTextNombre)
        EditTextApellido = findViewById(R.id.EditTextApellido)
        EditTextDni = findViewById(R.id.EditTextDni)
        CheckBoxIsSocio = findViewById(R.id.CheckBoxIsSocio)
        EditTextFechaNac = findViewById(R.id.EditTextFechaNac)
        EditTextDomicilio = findViewById(R.id.EditTextDomicilio)
        EditTextTelefono = findViewById(R.id.EditTextTelefono)
        btnAgregar = findViewById(R.id.btnAgregarUsuario)

        EditTextFechaNac.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val input = s.toString()
                if (!input.matches(Regex("^\\d{0,4}-?\\d{0,2}-?\\d{0,2}$"))) {
                    EditTextFechaNac.error = "Formato incorrecto. Use aaaa-mm-dd"
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        btnAgregar.setOnClickListener{
            val nombre = EditTextNombre.text.toString()
            val apellido = EditTextApellido.text.toString()
            val dni = parseInt(EditTextDni.text.toString())
            val isSocio = CheckBoxIsSocio.isChecked
            val fechaNac = EditTextFechaNac.text.toString()
            val domicilio = EditTextDomicilio.text.toString()
            val telefono = EditTextTelefono.text.toString()

            if (!fechaNac.matches(Regex("^\\d{4}-\\d{2}-\\d{2}$"))) {
                Toast.makeText(this, "Formato de fecha de nacimiento incorrecto. Use aaaa-mm-dd", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //crear funcion para buscar persona por dni si esta en la bd no permitir la carga
            dbHelper.insertarPersona(nombre,apellido,fechaNac,dni,domicilio,telefono,isSocio,false)
            if(isSocio){
                    val intent: Intent = Intent(this, CarnetActivity::class.java)
                    startActivity(intent)
            }

            Toast.makeText(this, "La persona fue cargada exitosamente", Toast.LENGTH_SHORT).show()
        }
    }
}