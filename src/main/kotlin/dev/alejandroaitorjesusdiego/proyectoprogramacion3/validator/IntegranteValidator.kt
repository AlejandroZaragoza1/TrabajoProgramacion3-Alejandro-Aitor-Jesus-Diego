package dev.alejandroaitorjesusdiego.proyectoprogramacion3.validator

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.newteam.gestion.errors.GestionErrors
import org.example.newteam.gestion.models.Integrante
import org.example.newteam.gestion.models.Jugador
import org.lighthousegames.logging.logging
import java.time.LocalDate


class IntegranteValidator {
    private val logger = logging()

    fun validar (integrante: Integrante): Result<Integrante, GestionErrors.InvalidoError> {
        logger.debug { "Validando campos de los integrantes del equipo" }

        if (integrante.nombre.isBlank()){
            return Err(GestionErrors.InvalidoError("El nombre no puede estar vacío"))
        }

        if (integrante.apellidos.isBlank()){
            return Err(GestionErrors.InvalidoError("Los apellidos no pueden estar vacíos"))
        }

        if (integrante.fecha_nacimiento > LocalDate.now()){
            return Err(GestionErrors.InvalidoError("La fecha de nacimiento no puede ser después de la fecha actual"))
        }

        if (integrante.fecha_incorporacion > LocalDate.now()){
            return Err(GestionErrors.InvalidoError("La fecha de incorporación no puede ser después de la fecha actual"))
        }

        if (integrante.fecha_incorporacion < integrante.fecha_nacimiento){
            return Err(GestionErrors.InvalidoError("La fecha de incorporación no puede ser después de la fecha de nacimiento"))
        }

        if (integrante.salario < 0.0){
            return Err(GestionErrors.InvalidoError("El salario no puede ser inferior a 0"))
        }

        if (integrante.pais.isBlank()){
            return Err(GestionErrors.InvalidoError("El país no puede estar en blanco"))
        }
        return Ok(integrante)
    }

    private fun validarJugador (jugador: Jugador): Result<Integrante, GestionErrors.InvalidoError>{
        logger.debug { "Validando campos específicos de jugador" }

        if (jugador.dorsal !in 1..99) {
            return Err(GestionErrors.InvalidoError("El dorsal no puede ser menor a 1 ni mayor a 99"))
        }

        if (jugador.altura !in 0.0..3.0){
            return Err(GestionErrors.InvalidoError("La altura no puede ser negativa ni superar los 3 metros"))
        }

        if (jugador.peso < 0.0) {
            return Err(GestionErrors.InvalidoError("El peso no puede ser negativo"))
        }

        if (jugador.goles < 0) {
            return Err(GestionErrors.InvalidoError("El número de goles no puede ser negativo"))
        }

        if (jugador.partidos_jugados < 0){
            return Err(GestionErrors.InvalidoError("El número de partidos jugados no puede ser negativo"))
        }

        return Ok(jugador)
    }
}