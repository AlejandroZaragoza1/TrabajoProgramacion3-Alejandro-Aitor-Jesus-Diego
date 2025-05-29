package dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.repositories

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Integrante
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.repositories.CrudRepository

/**
 * Interfaz intermedia que especifica los tipos genericos de la interfaz [CrudRepository] para poder manejar [Long] como clave e [Integrante] como valor
 */
interface EquipoRepository<T, U> : CrudRepository<Long, Integrante> {
}