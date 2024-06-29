package com.example.club
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.text.TextUtils
import com.example.club.models.Actividad
import com.example.club.models.cuota
import com.example.club.models.cuotaPersona
import com.example.club.models.persona


class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    companion object {
        private const val DATABASE_NAME = "ClubDatabase.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_USERS = "User"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"

        private const val CREATE_PERSONA_TABLE = "CREATE TABLE persona " + "(idPersona INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, fechaNac DATE, dni TEXT, domicilio TEXT, telefono TEXT, isSocio TINYINT, aptoFisico TINYINT)"
        //private const val CREATE_SOCIO_TABLE = "CREATE TABLE socio " + "(idSocio INTEGER PRIMARY KEY AUTOINCREMENT, idPersona INTEGER, FOREIGN KEY (idPersona) REFERENCES persona(idPersona))"
        //private const val CREATE_NOSOCIO_TABLE = "CREATE TABLE nosocio " + "(idNoSocio INTEGER PRIMARY KEY AUTOINCREMENT, idPersona INTEGER, FOREIGN KEY (idPersona) REFERENCES persona(idPersona))"
        private const val CREATE_CUOTA_TABLE = "CREATE TABLE cuota " + "(idCuota INTEGER PRIMARY KEY AUTOINCREMENT, idPersona INTEGER, monto FLOAT, fechaVencimiento DATE, periodo TEXT, medioPago TEXT, fechaEmision DATE, FOREIGN KEY (idPersona) REFERENCES persona(idPersona))"
        private const val CREATE_ACTIVIDAD_TABLE = "CREATE TABLE actividad " + "(idActividad INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, costo FLOAT)"
        private const val CREATE_PERSONAACTIVIDAD_TABLE = "CREATE TABLE personaactividad " + "(idPersona INTEGER, idActividad INTEGER, PRIMARY KEY (idPersona, idActividad), FOREIGN KEY (idPersona) REFERENCES persona(idPersona), FOREIGN KEY (idActividad) REFERENCES actividad(idActividad))"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUsersTable = "CREATE TABLE $TABLE_USERS ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_USERNAME TEXT, $COLUMN_PASSWORD TEXT)"
        db.execSQL(createUsersTable)
        db.execSQL(CREATE_PERSONA_TABLE)
        //db.execSQL(CREATE_SOCIO_TABLE)
        //db.execSQL(CREATE_NOSOCIO_TABLE)
        db.execSQL(CREATE_CUOTA_TABLE)
        db.execSQL(CREATE_ACTIVIDAD_TABLE)
        db.execSQL(CREATE_PERSONAACTIVIDAD_TABLE)
        //carga del usuario:
        val adminValues = ContentValues().apply {
            put(COLUMN_USERNAME, "clubdeportivo")
            put(COLUMN_PASSWORD, "admin12345")
        }
        db.insert(TABLE_USERS, null, adminValues)

        //carga de las actividades:
        val actividades = listOf(
            Pair("Basquet", 500.00),
            Pair("Natación", 400.00),
            Pair("Futbol", 600.00),
            Pair("Karate", 700.00),
            Pair("Danza", 400.00),
            Pair("Yoga", 500.00)
        )
        db.beginTransaction()
        try {
            for (actividad in actividades) {
                val activityValues = ContentValues().apply {
                    put("nombre", actividad.first)
                    put("costo", actividad.second)
                }
                db.insert("actividad", null, activityValues)
            }
            db.setTransactionSuccessful()  // Marca la transacción como exitosa
        } catch (e: Exception) {
            // Manejo de errores
            e.printStackTrace()
        } finally {
            db.endTransaction()  // Finaliza la transacción
        }

        //carga de las personas:
        val personas = listOf(
            persona(0,"Juan","Perez","1990-01-01", 123456789, "Calle Falsa 123", "123456789", true, true ),
            persona(0, "Maria", "Gomez", "1985-02-15", 87654321, "Av. Siempre Viva 456", "987654321", false, false),
            persona(0, "Romina", "Sanchez", "1987-03-19", 454564561, "Cadiz 496", "1156487846", true, true),
        )
        db.beginTransaction()
        try{
            for (persona in personas){
                val personaValues = ContentValues().apply {
                    put("nombre", persona.nombre)
                    put("apellido", persona.apellido)
                    put("fechaNac", persona.fechaNac)
                    put("dni", persona.dni)
                    put("domicilio", persona.domicilio)
                    put("telefono", persona.telefono)
                    put("isSocio", if(persona.isSocio) 1 else 0)
                    put("aptoFisico", if(persona.aptoFisico) 1 else 0)
                }
                db.insert("persona", null, personaValues)
            }
            db.setTransactionSuccessful()
        }catch (e: Exception){
            e.printStackTrace()
        }finally {
            db.endTransaction()
        }
        //carga de las cuotas:
        val cuotas = listOf(
            cuota(0, 1,20500.00,"26-10-2024","mayo-24","efectivo","25-04-24"),
            cuota(0, 2,26500.00,"26-12-2024","junio-24","tarjeta ","28-03-24"),
            cuota(0, 3,29500.00,"29-06-2024","abril-24",null,"15-02-24"),
            cuota(0, 2,20500.00,"29-10-2024","mayo-24",null,"25-04-24"),
            cuota(0, 2,26500.00,"26-12-2024","junio-24","billeteraV","28-03-24"),

        )
        db.beginTransaction()
        try {
            for (cuota in cuotas) {
                val cuotaValues = ContentValues().apply {
                    put("idPersona", cuota.idPersona)
                    put("monto", cuota.monto)
                    put("fechaVencimiento", cuota.fechaVencimiento)
                    put("periodo", cuota.periodo)
                    put("medioPago", cuota.medioPago)
                    put("fechaEmision", cuota.fechaEmision)
                }
                db.insert("cuota", null, cuotaValues)
            }
            db.setTransactionSuccessful()  // Marca la transacción como exitosa
        } catch (e: Exception) {
            // Manejo de errores
            e.printStackTrace()
        } finally {
            db.endTransaction()  // Finaliza la transacción
        }

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db.execSQL("DROP TABLE IF EXISTS persona")
        //db.execSQL("DROP TABLE IF EXISTS socio")
        //db.execSQL("DROP TABLE IF EXISTS nosocio")
        db.execSQL("DROP TABLE IF EXISTS cuota")
        db.execSQL("DROP TABLE IF EXISTS actividad")
        db.execSQL("DROP TABLE IF EXISTS personaactividad")
        onCreate(db)

    }


    fun validateUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_USERS WHERE $COLUMN_USERNAME = '$username' AND $COLUMN_PASSWORD = '$password'", null)
        val isValid = cursor.count > 0
        cursor.close()
        //db.close()
        return isValid
    }

    fun traerDatosActividades():MutableList<Actividad> {
        var listaActividades : MutableList<Actividad> = ArrayList()
        readableDatabase.use { db ->
            val sql = "SELECT * FROM actividad"
            db.rawQuery(sql, null).use { cursor ->
                if (cursor.moveToFirst()) {
                    do {
                        val idActividad = cursor.getInt(cursor.getColumnIndexOrThrow("idActividad"))
                        val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                        val costo = cursor.getDouble(cursor.getColumnIndexOrThrow("costo"))

                        val act = Actividad(idActividad, nombre, costo)
                        listaActividades.add(act)
                    } while (cursor.moveToNext())
                }
            }
        }

        return listaActividades
    }

    fun obtenerPersonas():MutableList<persona> {
        var listaPersonas : MutableList<persona> = ArrayList()
        readableDatabase.use { db ->
            val sql = "SELECT * FROM persona"
            db.rawQuery(sql, null).use { cursor ->
                if (cursor.moveToFirst()) {
                    do {
                        val idPersona = cursor.getInt(cursor.getColumnIndexOrThrow("idPersona"))
                        val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                        val apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"))
                        val fechaNac = cursor.getString(cursor.getColumnIndexOrThrow("fechaNac"))
                        val dni = cursor.getInt(cursor.getColumnIndexOrThrow("dni"))
                        val domicilio = cursor.getString(cursor.getColumnIndexOrThrow("domicilio"))
                        val telefono = cursor.getString(cursor.getColumnIndexOrThrow("telefono"))
                        val isSocio = cursor.getInt(cursor.getColumnIndexOrThrow("isSocio")) == 1
                        val aptoFisico =
                            cursor.getInt(cursor.getColumnIndexOrThrow("aptoFisico")) == 1

                        val persona = persona(
                            idPersona,
                            nombre,
                            apellido,
                            fechaNac,
                            dni,
                            domicilio,
                            telefono,
                            isSocio,
                            aptoFisico
                        )
                        listaPersonas.add(persona)
                    } while (cursor.moveToNext())
                }
            }
        }
        return listaPersonas
    }
    fun obtenerCuotaPersona():MutableList<cuotaPersona> {
        var listaCuotaP: MutableList<cuotaPersona> = ArrayList()
        readableDatabase.use { db ->
            val sql = "SELECT nombre, apellido, dni,isSocio,monto,fechaVencimiento,periodo,medioPago,fechaEmision  FROM persona as p join cuota as c where p.idPersona= c.idPersona"
            db.rawQuery(sql, null).use { cursor ->
                if (cursor.moveToFirst()) {
                    do {
                        val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                        val apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"))
                        val dni = cursor.getInt(cursor.getColumnIndexOrThrow("dni"))
                        val isSocio = cursor.getInt(cursor.getColumnIndexOrThrow("isSocio")) == 1
                        val monto = cursor.getString(cursor.getColumnIndexOrThrow("monto"))
                        val fechaVencimiento = cursor.getString(cursor.getColumnIndexOrThrow("fechaVencimiento"))
                        val periodo = cursor.getString(cursor.getColumnIndexOrThrow("periodo"))
                        val medioPago = cursor.getString(cursor.getColumnIndexOrThrow("medioPago"))
                        val fechaEmision = cursor.getString(cursor.getColumnIndexOrThrow("fechaEmision"))

                        val cuotaPersona = cuotaPersona(

                            nombre,
                            apellido,
                            dni,
                            isSocio,
                            monto,
                            fechaVencimiento,
                            periodo,
                            medioPago,
                            fechaEmision
                        )
                        listaCuotaP.add(cuotaPersona)
                    } while (cursor.moveToNext())
                }
            }
        }
        return listaCuotaP
    }
    
    fun insertarPersona( nombre: String, apellido: String, fechaNac: String, dni: String, domicilio: String, telefono: String, isSocio: Boolean, aptoFisico: Boolean):String{
        val db = this.writableDatabase
        val personaValues = ContentValues().apply {
            put("nombre", nombre)
            put("apellido", apellido)
            put("fechaNac", fechaNac)
            put("dni", dni)
            put("domicilio", domicilio)
            put("telefono", telefono)
            put("isSocio", if(isSocio) 1 else 0)
            put("aptoFisico", if(aptoFisico) 1 else 0)
        }
        var resultado = db.insert("persona", null, personaValues)
        if(resultado == -1.toLong()){
            return "La persona fue cargada exitosamente"
        }else{
            return "Hubo un error en la carga de los datos"
        }
    }

    fun personaExiste(dniPersona: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.query(
            "persona", arrayOf<String>("dni"),
            "dni" + " = ?", arrayOf<String>(dniPersona),
            null, null, null
        )
        val existe = cursor.count > 0
        cursor.close()
        db.close()
        return existe
    }

    fun validarCamposCompletos(
        nombre: String?,
        apellido: String?,
        fechaNac: String?,
        dni: String?,
        domicilio: String?,
        telefono: String?
    ): Boolean {
        return !TextUtils.isEmpty(nombre) &&
                !TextUtils.isEmpty(apellido) &&
                !TextUtils.isEmpty(fechaNac) &&
                !TextUtils.isEmpty(dni) &&
                !TextUtils.isEmpty(domicilio) &&
                !TextUtils.isEmpty(telefono)
    }

}