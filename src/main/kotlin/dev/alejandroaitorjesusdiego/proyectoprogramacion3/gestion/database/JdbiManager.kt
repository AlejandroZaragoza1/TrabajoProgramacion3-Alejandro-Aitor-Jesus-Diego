package dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.database

import dev.alejandroaitorjesusdiego.proyectoprogramacion3.configuration.Configuration
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.sqlobject.SqlObjectPlugin

import org.lighthousegames.logging.logging

import java.io.File


class JdbiManager(databaseUrl: String, databaseInitTables: String) {
    private val log = logging()

    val urlNormal = Configuration.configurationProperties.databaseUrl
    val InitTables = Configuration.configurationProperties.databaseInitTables

    val jdbi by lazy { Jdbi.create(urlNormal) }


    init {
        log.debug { "Inicializar Jdbi" }
        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (InitTables){
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


    fun provideDataBaseManager(config: Configuration):Jdbi{
        log.debug { "Instanciando JdbiManager" }
        return JdbiManager(
        urlNormal,
            InitTables.toString()


        ).jdbi
    }

    companion object {
        val instance: Jdbi = TODO()
    }

}