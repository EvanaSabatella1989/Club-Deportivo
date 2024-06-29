package com.example.club.models

data class cuotaPersona (
    val nombre: String,
    val apellido: String,
    val dni: Int,
    val isSocio: Boolean,
    val monto: String,
    val fechaVencimiento: String,
    val periodo: String,
    val fechaEmision: String
)