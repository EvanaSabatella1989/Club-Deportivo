package com.example.club.models

data class persona (
        val idPersona: Int,
        val nombre: String,
        val apellido: String,
        val fechaNac: String,
        val dni: String,
        val domicilio: String,
        val telefono: String,
        val isSocio: Boolean,
        val aptoFisico: Boolean
)

