import dev.alejandroaitorjesusdiego.proyectoprogramacion3.models.Tipo
import org.example.newteam.gestion.dto.IntegranteDTO
import org.example.newteam.gestion.dto.IntegranteXmlDTO
import org.example.newteam.gestion.mapper.toDto
import org.example.newteam.gestion.mapper.toModel
import org.example.newteam.gestion.mapper.toXmlDTO
import org.example.newteam.gestion.models.Entrenador
import org.example.newteam.gestion.models.Especialidad
import org.example.newteam.gestion.models.Jugador
import org.example.newteam.gestion.models.Posicion
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class IntegrantesMapperTest {
    private val jugador = Jugador(
        id = 1L,
        nombre = "Jugador",
        apellidos = "prueba",
        fecha_nacimiento = LocalDate.parse("2020-01-01"),
        fecha_incorporacion = LocalDate.parse("2020-01-02"),
        salario = 20000.0,
        pais = "España",
        createdAt = LocalDateTime.parse("2020-01-02T00:00:00"),
        updatedAt = LocalDateTime.parse("2020-01-03T00:00:00"),
        imagen = "sdfsdfs",
        posicion = Posicion.DEFENSA,
        dorsal = 12,
        altura = 1.8,
        peso = 70.3,
        goles = 2,
        partidos_jugados = 32,
        minutos_jugados = 91,
        tipo = Tipo.NINGUNO
    )
    private val entrenador = Entrenador(
        id = 2L,
        nombre = "Entrenador",
        apellidos = "prueba",
        fecha_nacimiento = LocalDate.parse("2020-01-01"),
        fecha_incorporacion = LocalDate.parse("2020-01-02"),
        salario = 20000.0,
        pais = "Espa",
        createdAt = LocalDateTime.parse("2020-01-02T00:00:00"),
        updatedAt = LocalDateTime.parse("2020-01-03T00:00:00"),
        imagen = "sdfsdfs",
        especialidad = Especialidad.ENTRENADOR_ASISTENTE,
        tipo = Tipo.NINGUNO
    )
    private val jugadorDTO = IntegranteDTO(
        id = 1L,
        nombre = "JugadorDTO",
        apellidos = "prueba",
        fecha_nacimiento = "2020-01-01",
        fecha_incorporacion = "2020-01-02",
        salario = 20000.0,
        pais = "Espa",
        tipo = "Normal",
        rol = "JugadorDTO",
        especialidad = null,
        posicion = "defensa",
        dorsal = 12,
        altura = 1.8,
        peso = 70.3,
        goles = 2,
        partidos_jugados = 32,
        minutos_jugados = 91,
        imagen = "sdfsdfs",
    )
    private val entrenadorDTO = IntegranteDTO(
        id = 2L,
        nombre = "EntrenadorDTO",
        apellidos = "prueba",
        fecha_nacimiento = "2020-01-01",
        fecha_incorporacion = "2020-01-02",
        salario = 20000.0,
        pais = "Espa",
        rol = "Entrenador",
        especialidad = "Entrenador_Especial",
        posicion = null,
        dorsal = null,
        altura = null,
        peso = null,
        goles = null,
        partidos_jugados = null,
        minutos_jugados = null,
        imagen = "sdfsdfs",
        tipo = "Normal"
    )
    private val jugadorXmlDTO = IntegranteXmlDTO(
        id = 1L,
        nombre = "JugagorXmlDTO",
        apellidos = "prueba",
        fecha_nacimiento = "2020-01-01",
        fecha_incorporacion = "2020-01-02",
        salario = 20000.0,
        pais = "Espa",
        tipo = "Normal",
        rol = "Jugagor",
        especialidad = null,
        posicion = "defensa",
        dorsal = "24",
        altura = "1.5",
        peso = "90",
        minutos_jugados = "90",
        partidos_jugados = "2",
        goles = "3",
        imagen = "sdfsdfs",
    )
    private val entrenadorXmlDTO = IntegranteXmlDTO(
        id = 2L,
        nombre = "EntrenadorXmlDTO",
        apellidos = "prueba",
        fecha_nacimiento = "2020-01-01",
        fecha_incorporacion = "2020-01-02",
        salario = 20000.0,
        pais = "Espa",
        rol = "Entrenador",
        especialidad = "Entrenador_Especial",
        posicion = null,
        dorsal = null,
        altura = null,
        peso = null,
        goles = null,
        partidos_jugados = null,
        minutos_jugados = null,
        imagen = "sdfsdfs",
        tipo = "Normal",

    )

    @Nested
    @DisplayName("Test")
    inner class TestBuenos {
        @Test
        @DisplayName("Test DTO a Jugador modelo")
        fun dtoModelJugador() {
            val expected = jugador

            val result = jugadorDTO.toModel()

            assertTrue(result is Jugador)
            assertEquals(
                expected.posicion,
                (result as Jugador).posicion,
                "El mapeo debe ser correcto"
            )
        }
        @Test
        @DisplayName("Test DTO a Entrenador")
        fun dtoToModelEntrenador() {
            val expected = entrenador

            val result = entrenadorDTO.toModel()

            assertTrue(result is Entrenador)
            assertEquals(
                expected.especialidad,
                (result as Entrenador).especialidad,
                "El mapeo debe ser correcto"
            )
        }
        @Test
        @DisplayName("Test de XmlDto a el modelo de jugador")
        fun xmlToModeloJugador() {
            val expected = jugador

            val result = jugadorXmlDTO.toModel()

            assertTrue(result is Jugador)
            assertEquals(
                expected.posicion,
                (result as Jugador).posicion,
                "El mapeo debe ser correcto"
            )
        }
        @Test
        @DisplayName("Test XmlDto a el modelo de Entrenador")
        fun xmlToModelEntrenador() {
            val expected = entrenador

            val result = entrenadorXmlDTO.toModel()

            assertTrue(result is Entrenador)
            assertEquals(
                expected.especialidad,
                    (result as Entrenador).especialidad,
                "El mapeo debe ser correcto"
            )
        }
        @Test
        @DisplayName("Modelo de jugador a XmlDto")
        fun jugadorXmltoDto() {
            val expected = jugadorXmlDTO

            val result = jugador.toXmlDTO()

            assertTrue(result is IntegranteXmlDTO)
            assertEquals(expected.posicion,
                result.posicion,
                "El resultado del mapeo debe coincidir con lo esperado.")
        }

        @Test
        @DisplayName("Modelo de entrenador a XMLDTO")
        fun entrenadorXmltoDto() {
            val expected = entrenadorXmlDTO

            val result = entrenador.toXmlDTO()

            assertTrue(result is IntegranteXmlDTO)
            assertEquals(
                expected.especialidad,
                result.especialidad,
                "El mapeo debe ser correcto"
            )
        }
        @Test
        @DisplayName("Modelo de entrenador a Dto")
        fun entrenadorToDTO(){
            val expected = entrenadorDTO

            val result = entrenador.toDto()

            assertTrue(result is IntegranteDTO)
            assertEquals(expected.especialidad,
                result.especialidad,
                "El resultado del mapeo debe coincidir con lo esperado.")
        }

        @Test
        @DisplayName("Modelo de entrenador a DTO")
        fun jugadorToDTO(){
            val expected = jugadorDTO

            val result = jugador.toDto()

            assertTrue(result is IntegranteDTO)
            assertEquals(expected.posicion,
                result.posicion,
                "El resultado del mapeo debe coincidir con lo esperado.")
        }
    }
}






















