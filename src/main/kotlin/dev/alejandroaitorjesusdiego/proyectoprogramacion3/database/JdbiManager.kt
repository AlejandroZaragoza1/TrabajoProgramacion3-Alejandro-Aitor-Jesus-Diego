package dev.alejandroaitorjesusdiego.proyectoprogramacion3.database

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.configuration.Configuration
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.koin.core.annotation.Property
import org.koin.core.annotation.Singleton
import org.lighthousegames.logging.logging

import java.io.File

@Singleton
class JdbiManager(databaseUrl: String, databaseInitTables: String) {
    private val log = logging()

    val urlNormal = Configuration.configurationProperties.databaseUrl
    val databaseTables = Configuration.configurationProperties.databaseInitTables



    val jdbi by lazy { Jdbi.create(urlNormal) }


    init {
        log.debug { "Inicializar Jdbi" }
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (databaseTables){
            log.debug { "creando tablas" }
            executeSqlScriptFromResources("tabla.Sql")
        }

    }

    fun executeSqlScriptFromResources(resourcePath:String){
        log.debug { "ejecutamos script SQL desde resorces: $resourcePath" }
        val inputStream = ClassLoader.getSystemResourceAsStream(resourcePath)?.bufferedReader()!!
        val script = inputStream.readText()
        jdbi.useHandle<Exception>{ handle ->
            handle.createScript(script).execute()
        }
    }

    fun executeSqlScript(scriptFilePath: String){
        log.debug { "ejecutando el script Sql $scriptFilePath" }
        val script = File(scriptFilePath).readText()
        jdbi.useHandle<Exception> {handle ->
            handle.createScript(script).execute()
        }
    }

    @Singleton
    fun provideDataBaseManager(
        @Property("database.url") databaseUrl: String = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
        @Property("database.init.tables") databaseInitTables: String = "false"
    ):Jdbi{
        log.debug { "Instanciando JdbiManager" }
        return JdbiManager(
            databaseUrl,
            databaseInitTables
        ).jdbi
    }

}