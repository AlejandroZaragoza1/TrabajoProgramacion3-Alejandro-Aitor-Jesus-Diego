package dev.alejandroaitorjesusdiego.proyectoprogramacion3.dao

import java.time.LocalDate
import java.time.LocalDateTime

data class IntegranteEntity(
    val id: Long,
    val nombre: String,
    val apellidos: String,
    val fecha_nacimiento: LocalDate,
    val fecha_incorporacion: LocalDate,
    val salario: Double,
    val pais: String,
    val rol: String,
    val especialidad: String?,
    val posicion: String?,
    val dorsal: Int?,
    val altura: Double?,
    val peso: Double?,
    val goles: Int?,
    val partidos_jugados: Int?,
    val minutos_jugados: Int?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime,
    val tipo: String,
    val imagen: String
)
