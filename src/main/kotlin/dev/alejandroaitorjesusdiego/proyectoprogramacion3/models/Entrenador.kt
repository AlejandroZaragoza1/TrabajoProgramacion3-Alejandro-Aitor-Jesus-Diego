package org.example.newteam.gestion.models

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.models.Tipo
import java.time.LocalDate
import java.time.LocalDateTime

/**
 * Clase que representa un Entrenador y hereda de [Integrante]
 * @param id [Long] Identificador
 * @param nombre [String] Nombre
 * @param apellidos [String] Apellidos
 * @param fecha_nacimiento [LocalDate] Fecha de nacimiento
 * @param fecha_incorporacion [LocalDate] Fecha de incorporacion al equipo
 * @param pais [String] Pais de origen
 * @param createdAt [LocalDateTime] Fecha y hora a la que se creo el objeto
 * @param updatedAt [LocalDateTime] Fecha y hora a la que se actualizo el objeto por ultima vez
 * @param isDeleted [Boolean] Campo que identifica si esta operativo o no
 * @param especialidad [Especialidad] Especializacion del entrenador
 * @property rol [String] Con valor "Entrenador"
 */
class   Entrenador(
    id: Long = 0L,
    nombre: String,
    apellidos: String,
    fecha_nacimiento: LocalDate,
    fecha_incorporacion: LocalDate,
    salario: Double,
    pais: String,
    createdAt: LocalDateTime = LocalDateTime.now(),
    updatedAt: LocalDateTime = LocalDateTime.now(),
    imagen: String,
    tipo: Tipo,
    val especialidad: Especialidad
): Integrante(id = id, nombre = nombre, apellidos = apellidos, fecha_nacimiento = fecha_nacimiento, fecha_incorporacion = fecha_incorporacion, salario = salario, pais = pais, createdAt = createdAt, updatedAt = updatedAt, imagen = imagen, tipo = tipo) {
    /**
     * Sobreescribe la funcion [toString] predeterminada dandole un formato mas legible
     */
    override fun toString(): String {
        return "Entrenador(id= $id, nombre= $nombre, apellidos= $apellidos, fecha_nacimiento= $fecha_nacimiento, fecha_incorporacion= $fecha_incorporacion, salario= $salario, pais = $pais, createdAt= $createdAt, updatedAt= $updatedAt, especialidad = $especialidad, imagen = $imagen)"
    }

    val rol: String = "Entrenador"

    val miEspecialidad = especialidad.toString()
}