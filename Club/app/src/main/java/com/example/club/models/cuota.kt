package com.example.club.models

data class cuota (
    val idCuota: Int,
    val idPersona: Int,
    val monto: Double,
    val fechaVencimiento: String,
    val periodo: String,
    val medioPago: String?,
    val fechaEmision: String
)