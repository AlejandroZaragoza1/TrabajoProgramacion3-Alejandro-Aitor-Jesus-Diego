package storageTest

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.models.Tipo
import org.example.newteam.gestion.models.Entrenador
import org.example.newteam.gestion.models.Especialidad
import org.example.newteam.gestion.models.Jugador
import org.example.newteam.gestion.models.Posicion
import org.example.newteam.gestion.storage.EquipoStorageCSV
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.assertEquals

class EquipoStorageCsvTest {
    val storage: EquipoStorageCSV = EquipoStorageCSV()
    private val entrenador = Entrenador(
        id = 1L,
        nombre = "Ash",
        apellidos = "KetChum",
        fecha_nacimiento = LocalDate.of(1942, 1, 1),
        fecha_incorporacion = LocalDate.of(2025, 2, 2),
        salario = 1234.0,
        pais = "Italia",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
        imagen = "pepito-grillo.png",
        especialidad = Especialidad.ENTRENADOR_PRINCIPAL,
        tipo = Tipo.NINGUNO
    )
    private val jugador = Jugador (
        id = 2L,
        nombre = "Oliver",
        apellidos = "KetChum",
        fecha_nacimiento = LocalDate.of(1942, 1, 1),
        fecha_incorporacion = LocalDate.of(2025, 2, 2),
        salario = 12345.0,
        pais = "Italia",
        createdAt = LocalDateTime.now(),
        updatedAt = LocalDateTime.now(),
        imagen = "pepito-grillo.png",
        tipo = Tipo.NINGUNO,
        posicion = Posicion.DELANTERO,
        dorsal = 2,
        altura = 2.2,
        peso = 98.0,
        goles = 2,
        minutos_jugados = 24,
        partidos_jugados = 23
    )

    val list = listOf(jugador, entrenador)


    @Nested
    @DisplayName("Tests correctos")
    inner class TestCorrectos {
        @Test
        @DisplayName("Comprobar que se importa correctamente el CSV")
        fun comprobarImportarEntrenador(@TempDir tempDir: File) {
            val file = File(tempDir, "test.csv")
            file.writeText( """
    id,nombre,apellidos,fecha_nacimiento,fecha_incorporacion,salario,pais,tipo,rol,especialidad,posicion,dorsal,altura,peso,goles,partidos_jugados,minutos_jugados,imagen
    2,Oliver,KetChum,1942-01-01,2025-02-02,12345.0,Italia,NINGUNO,JUGADOR,,DELANTERO,2,2.2,98.0,2,23,24,pepito-grillo.png
    1,Ash,KetChum,1942-01-01,2025-02-02,1234.0,Italia,NINGUNO,ENTRENADOR,ENTRENADOR_PRINCIPAL,,,,,,,pepito-grillo.png
    """)
            val lista = storage.fileRead(file).value

            assertEquals(1, lista.size)

            val entrenadorEsperado = Entrenador(
                id = 1L,
                nombre = "Alegrandro",
                apellidos = "Zaragoza",
                fecha_nacimiento = LocalDate.of(2003, 3, 13),
                fecha_incorporacion = LocalDate.of(2013, 11, 10),
                salario = 60000.0,
                pais = "España",
                imagen = "media/entrenador1.png",
                especialidad = Especialidad.ENTRENADOR_PRINCIPAL,
                tipo = Tipo.NINGUNO,
            )
            val entrenadorActual = lista.first() as Entrenador

            assertAll(
                { assertEquals(entrenadorEsperado.id, entrenadorActual.id) },
                { assertEquals(entrenadorEsperado.nombre, entrenadorActual.nombre) },
                { assertEquals(entrenadorEsperado.apellidos, entrenadorActual.apellidos) },
                { assertEquals(entrenadorEsperado.fecha_nacimiento, entrenadorActual.fecha_nacimiento) },
                { assertEquals(entrenadorEsperado.fecha_incorporacion, entrenadorActual.fecha_incorporacion) },
                { assertEquals(entrenadorEsperado.salario, entrenadorActual.salario) },
                { assertEquals(entrenadorEsperado.pais, entrenadorActual.pais) },
                { assertEquals(entrenadorEsperado.imagen, entrenadorActual.imagen) },
                { assertEquals(entrenadorEsperado.especialidad, entrenadorActual.especialidad) },
                { assertEquals(entrenadorEsperado.tipo, entrenadorActual.tipo) }
            )
        }
        @Nested
        @DisplayName("Tests correctos")
        inner class TestCorrectos {

            @Test
            @DisplayName("Comprobar que se importa correctamente el Jugador")
            fun comprobarImportarJugador(@TempDir tempDir: File) {
                val file = File(tempDir, "test.csv")
                file.writeText("""
            id,nombre,apellidos,fecha_nacimiento,fecha_incorporacion,salario,pais,tipo,rol,especialidad,posicion,dorsal,altura,peso,goles,partidos_jugados,minutos_jugados,imagen
            2,Oliver,KetChum,1942-01-01,2025-02-02,12345.0,Italia,NINGUNO,JUGADOR,,DELANTERO,2,2.2,98.0,2,23,24,pepito-grillo.png
            1,Ash,KetChum,1942-01-01,2025-02-02,1234.0,Italia,NINGUNO,ENTRENADOR,ENTRENADOR_PRINCIPAL,,,,,,,pepito-grillo.png
        """)

                val lista = storage.fileRead(file).value

                // Filtramos para obtener solo los jugadores
                val jugadorActual = lista.filterIsInstance<Jugador>().first()

                val jugadorEsperado = Jugador(
                    id = 2L,
                    nombre = "Oliver",
                    apellidos = "KetChum",
                    fecha_nacimiento = LocalDate.of(1942, 1, 1),
                    fecha_incorporacion = LocalDate.of(2025, 2, 2),
                    salario = 12345.0,
                    pais = "Italia",
                    tipo = Tipo.NINGUNO,
                    posicion = Posicion.DELANTERO,
                    dorsal = 2,
                    altura = 2.2,
                    peso = 98.0,
                    goles = 2,
                    partidos_jugados = 23,
                    minutos_jugados = 24,
                    imagen = "pepito-grillo.png",
                    createdAt = jugadorActual.createdAt, // No disponible en CSV, dejamos igual
                    updatedAt = jugadorActual.updatedAt  // No disponible en CSV, dejamos igual
                )

                assertAll(
                    { assertEquals(jugadorEsperado.id, jugadorActual.id) },
                    { assertEquals(jugadorEsperado.nombre, jugadorActual.nombre) },
                    { assertEquals(jugadorEsperado.apellidos, jugadorActual.apellidos) },
                    { assertEquals(jugadorEsperado.fecha_nacimiento, jugadorActual.fecha_nacimiento) },
                    { assertEquals(jugadorEsperado.fecha_incorporacion, jugadorActual.fecha_incorporacion) },
                    { assertEquals(jugadorEsperado.salario, jugadorActual.salario) },
                    { assertEquals(jugadorEsperado.pais, jugadorActual.pais) },
                    { assertEquals(jugadorEsperado.tipo, jugadorActual.tipo) },
                    { assertEquals(jugadorEsperado.rol, jugadorActual.rol) },
                    { assertEquals(jugadorEsperado.posicion, jugadorActual.posicion) },
                    { assertEquals(jugadorEsperado.dorsal, jugadorActual.dorsal) },
                    { assertEquals(jugadorEsperado.altura, jugadorActual.altura) },
                    { assertEquals(jugadorEsperado.peso, jugadorActual.peso) },
                    { assertEquals(jugadorEsperado.goles, jugadorActual.goles) },
                    { assertEquals(jugadorEsperado.partidos_jugados, jugadorActual.partidos_jugados) },
                    { assertEquals(jugadorEsperado.minutos_jugados, jugadorActual.minutos_jugados) },
                    { assertEquals(jugadorEsperado.imagen, jugadorActual.imagen) }
                )
            }
        }
        @Test
        @DisplayName("Comprobar que se exporta bien")
        fun comprobarExportar(@TempDir tempDir: File) {
            val file = File(tempDir, "data.csv")
            storage.fileWrite(list, file)

            val expectedString =
                "id,nombre,apellidos,fecha_nacimiento,fecha_incorporacion,salario,pais,rol,especialidad,posicion,dorsal,altura,peso,goles,partidos_jugados,minutos_jugados,imagen\n" +
                        "2,Oliver,KetChum,1942-01-01,2025-02-02,12345.0,Italia,Jugador,,DELANTERO,2,2.2,98.0,2,23,24,pepito-grillo.png"
            val stringActual = file.readText().trim()
            assertEquals(expectedString.trim(), stringActual)
        }

        @Test
        @DisplayName("Test decomprobacion de error de exportacion")
        fun notFileOnExport(@TempDir tempDir: File){
            val file = File("data.csv", "data.csv")

            val error = storage.fileWrite(list, file)
            assertTrue(error.isErr)
        }

    }
}