package com.example.club
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION)  {
    companion object {
        private const val DATABASE_NAME = "ClubDatabase.db"
        private const val DATABASE_VERSION = 2
        private const val TABLE_USERS = "User"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"

        private const val CREATE_PERSONA_TABLE = "CREATE TABLE persona " + "(idPersona INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellido TEXT, fechaNac DATE, dni INTEGER, aptoFisico TINYINT)"
        private const val CREATE_SOCIO_TABLE = "CREATE TABLE socio " + "(idSocio INTEGER PRIMARY KEY AUTOINCREMENT, idPersona INTEGER, FOREIGN KEY (idPersona) REFERENCES persona(idPersona))"
        private const val CREATE_NOSOCIO_TABLE = "CREATE TABLE nosocio " + "(idNoSocio INTEGER PRIMARY KEY AUTOINCREMENT, idPersona INTEGER, FOREIGN KEY (idPersona) REFERENCES persona(idPersona))"
        private const val CREATE_CUOTA_TABLE = "CREATE TABLE cuota " + "(idCuota INTEGER PRIMARY KEY AUTOINCREMENT, idSocio INTEGER, monto FLOAT, fechaVencimiento DATE, periodo TEXT, medioPago TEXT, fechaEmision DATE, FOREIGN KEY (idSocio) REFERENCES socio(idSocio))"
        private const val CREATE_ACTIVIDAD_TABLE = "CREATE TABLE actividad " + "(idActividad INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, costo FLOAT)"
        private const val CREATE_NOSOCIOACTIVIDAD_TABLE = "CREATE TABLE nosocioactividad " + "(idNoSocio INTEGER, idActividad INTEGER, PRIMARY KEY (idNoSocio, idActividad), FOREIGN KEY (idNoSocio) REFERENCES nosocio(idNoSocio), FOREIGN KEY (idActividad) REFERENCES actividad(idActividad))"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUsersTable = "CREATE TABLE $TABLE_USERS ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_USERNAME TEXT, $COLUMN_PASSWORD TEXT)"
        db.execSQL(createUsersTable)
        db.execSQL(CREATE_PERSONA_TABLE)
        db.execSQL(CREATE_SOCIO_TABLE)
        db.execSQL(CREATE_NOSOCIO_TABLE)
        db.execSQL(CREATE_CUOTA_TABLE)
        db.execSQL(CREATE_ACTIVIDAD_TABLE)
        db.execSQL(CREATE_NOSOCIOACTIVIDAD_TABLE)
        val adminValues = ContentValues().apply {
            put(COLUMN_USERNAME, "clubdeportivo")
            put(COLUMN_PASSWORD, "admin12345")
        }
        val activityValues = ContentValues().apply {
            put("nombre","Voley")
            put("costo", 50.00)
        }
        //db.execSQL("INSERT INTO actividad (idActividad, nombre, costo) VALUES (1, 'Yoga', 50.00);")
        db.insert(TABLE_USERS, null, adminValues)
        db.insert("actividad", null, activityValues)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        db.execSQL("DROP TABLE IF EXISTS persona")
        db.execSQL("DROP TABLE IF EXISTS socio")
        db.execSQL("DROP TABLE IF EXISTS nosocio")
        db.execSQL("DROP TABLE IF EXISTS cuota")
        db.execSQL("DROP TABLE IF EXISTS actividad")
        db.execSQL("DROP TABLE IF EXISTS nosocioactividad")
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



}