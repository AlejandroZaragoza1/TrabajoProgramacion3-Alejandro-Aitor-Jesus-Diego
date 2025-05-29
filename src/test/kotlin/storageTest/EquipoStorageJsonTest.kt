package storageTest

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Tipo
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Entrenador
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Especialidad
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Jugador
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Posicion
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.storage.EquipoStorageJSON
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.io.TempDir
import java.io.File
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.math.E
import kotlin.test.Test
import kotlin.test.assertEquals

class EquipoStorageJsonTest {
    val storage = EquipoStorageJSON()
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
    private val jugador = Jugador(
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
    val lista = listOf(entrenador, jugador)

    @Nested
    @DisplayName("Tests correctos")
    inner class Successful {
        @Test
        @DisplayName("Verificar importar JSON")
        fun checkImportarEntrenador(@TempDir tempDir: File) {
            val file = File(tempDir, "data.json")
            file.writeText(
                "[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"nombre\": \"Ash\",\n" +
                        "        \"apellidos\": \"KetChum\",\n" +
                        "        \"fecha_nacimiento\": \"1942-01-01\",\n" +
                        "        \"fecha_incorporacion\": \"2025-02-02\",\n" +
                        "        \"salario\": 1234.0,\n" +
                        "        \"pais\": \"Italia\",\n" +
                        "        \"rol\": \"Entrenador\",\n" +
                        "        \"especialidad\": \"ENTRENADOR_PRINCIPAL\",\n" +
                        "        \"posicion\": \"\",\n" +
                        "        \"dorsal\": null,\n" +
                        "        \"altura\": null,\n" +
                        "        \"peso\": null,\n" +
                        "        \"goles\": null,\n" +
                        "        \"partidos_jugados\": null,\n" +
                        "        \"minutos_jugados\": null,\n" +
                        "        \"imagen\": \"pepito-grillo.png\"\n" +
                        "    }\n" +
                        "]"
            )
            val lista = storage.fileRead(file).value

            assertEquals(1, lista.size)

            val entrenadorImportado  = lista[0] as Entrenador
            assertAll(
                { assertEquals(entrenador.id, entrenadorImportado.id) },
                { assertEquals(entrenador.nombre, entrenadorImportado.nombre) },
                { assertEquals(entrenador.apellidos, entrenadorImportado.apellidos) },
                { assertEquals(entrenador.fecha_nacimiento, entrenadorImportado.fecha_nacimiento) },
                { assertEquals(entrenador.fecha_incorporacion, entrenadorImportado.fecha_incorporacion) },
                { assertEquals(entrenador.salario, entrenadorImportado.salario) },
                { assertEquals(entrenador.pais, entrenadorImportado.pais) },
                { assertEquals(entrenador.imagen, entrenadorImportado.imagen) },
                { assertEquals(entrenador.especialidad, entrenadorImportado.especialidad) }
            )
        }
        @Test
        @DisplayName("Verificar importar JSON de Jugador")
        fun checkImportarJugador(@TempDir tempDir: File) {
            val file = File(tempDir, "data.json")
            file.writeText(
                "[\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"nombre\": \"Oliver\",\n" +
                        "        \"apellidos\": \"KetChum\",\n" +
                        "        \"fecha_nacimiento\": \"1942-01-01\",\n" +
                        "        \"fecha_incorporacion\": \"2025-02-02\",\n" +
                        "        \"salario\": 12345.0,\n" +
                        "        \"pais\": \"Italia\",\n" +
                        "        \"rol\": \"Jugador\",\n" +
                        "        \"especialidad\": \"\",\n" +
                        "        \"posicion\": \"DELANTERO\",\n" +
                        "        \"dorsal\": 2,\n" +
                        "        \"altura\": 2.2,\n" +
                        "        \"peso\": 98.0,\n" +
                        "        \"goles\": 2,\n" +
                        "        \"partidos_jugados\": 23,\n" +
                        "        \"minutos_jugados\": 24,\n" +
                        "        \"imagen\": \"pepito-grillo.png\"\n" +
                        "    }\n" +
                        "]"
            )

            val lista = storage.fileRead(file).value

            assertEquals(1, lista.size)

            val jugadorImportado = lista[0] as Jugador

            assertAll(
                "Datos del jugador importado",
                { assertEquals(jugador.id, jugadorImportado.id) },
                { assertEquals(jugador.nombre, jugadorImportado.nombre) },
                { assertEquals(jugador.apellidos, jugadorImportado.apellidos) },
                { assertEquals(jugador.fecha_nacimiento, jugadorImportado.fecha_nacimiento) },
                { assertEquals(jugador.fecha_incorporacion, jugadorImportado.fecha_incorporacion) },
                { assertEquals(jugador.salario, jugadorImportado.salario) },
                { assertEquals(jugador.pais, jugadorImportado.pais) },
                { assertEquals(jugador.posicion, jugadorImportado.posicion) },
                { assertEquals(jugador.dorsal, jugadorImportado.dorsal) },
                { assertEquals(jugador.altura, jugadorImportado.altura) },
                { assertEquals(jugador.peso, jugadorImportado.peso) },
                { assertEquals(jugador.goles, jugadorImportado.goles) },
                { assertEquals(jugador.partidos_jugados, jugadorImportado.partidos_jugados) },
                { assertEquals(jugador.minutos_jugados, jugadorImportado.minutos_jugados) },
                { assertEquals(jugador.imagen, jugadorImportado.imagen) }
            )
        }

    }
}