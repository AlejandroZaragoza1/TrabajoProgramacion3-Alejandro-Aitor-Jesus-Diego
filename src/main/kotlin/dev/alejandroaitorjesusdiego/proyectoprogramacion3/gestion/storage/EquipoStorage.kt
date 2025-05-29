package dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.storage

import com.github.michaelbull.result.Result
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.errors.GestionErrors
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Integrante
import java.io.File

/**
 * Interfaz que representa el contrato para crear un almacenamiento
 */
interface EquipoStorage {
    fun fileRead(file: File): Result<List<Integrante>, GestionErrors>
    fun fileWrite(equipo: List<Integrante>, file: File): Result<Unit, GestionErrors>
}