package dev.alejandroaitorjesusdiego.proyectoprogramacion3.dao

import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.kotlin.RegisterKotlinMapper
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery

@RegisterKotlinMapper(IntegranteEntity::class)
interface EquipoDao {
    @SqlQuery("SELECT * FROM integrante")
    fun getAll():List<IntegranteEntity>

    @SqlQuery ("SELECT * FROM integrante WHERE id = id")
    fun getById(@Bind ("id") id:Long): IntegranteEntity?

    @SqlQuery ("SELECT INSERT INTO integrante nombre, apellidos, fecha_nacimiento, fecha_incorporacion, salario, pais, rol, especialidad, posicion, dorsal, altura, peso, goles, partidos_jugados, minutos_jugados, createdAt, updatedAt, imagen)VALUES (:nombre, :apellidos, :fecha_nacimiento, :fecha_incorporacion, :salario, :pais, :rol, :especialidad, :posicion, :dorsal, :altura, :peso, :goles, :partidos_jugados, :minutos_jugados, :createdAt, :updatedAt, :imagen)")
    @GetGeneratedKeys("id")
    fun save(@BindBean integrante:IntegranteEntity ):Int

    @SqlQuery ("DELETER * FROM integrante where id = id")
    fun deleter(@Bind ("id") id: Long): Int

    @SqlQuery ("UPDATE integrante SET  nombre = :nombre, apellidos = :apellidos, fecha_nacimiento = :fecha_nacimiento, fecha_incorporacion = :fecha_incorporacion, salario = :salario, pais = :pais, rol = :rol, especialidad = :especialidad, posicion = :posicion, dorsal = :dorsal, altura = :altura, peso = :peso, goles = :goles, partidos_jugados = :partidos_jugados, minutos_jugados = :minutos_jugados, createdAt = :createdAt, updatedAt = :updatedAt, tipo = :tipo, imagen = :imagen WHERE id = :id")
    fun update(@BindBean integrante: IntegranteEntity):Int
}