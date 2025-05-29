package dev.alejandroaitorjesusdiego.proyectoprogramacion3.configuration

import org.lighthousegames.logging.logging
import java.nio.file.Path
import java.util.*
import kotlin.io.path.pathString

object Configuration {
    private val log = logging()
    val configurationProperties: ConfigurationProperties = loadConfig()

    private  fun loadConfig(): ConfigurationProperties{
        val propiedades = Properties()

        val cadenaPropiedades = this::class.java.getResourceAsStream("/config.propierties")
            ?:throw  RuntimeException("No esta el fichero")
        propiedades.load(cadenaPropiedades)

        val directorioActual = System.getProperty("user.dir")
        var directoryDataProperties: String? = propiedades.getProperty("data.directory")
        if (directoryDataProperties.isNullOrEmpty()){
            directoryDataProperties = "data"
        }
        var directorioBackupProperties: String? = propiedades.getProperty("backup.directory")
        if (directorioBackupProperties.isNullOrEmpty()){
            directorioBackupProperties = "backup"
        }

        var directorioImagenesPropiedades: String? = propiedades.getProperty("imagenes.directory")
        if (directorioBackupProperties.isNullOrEmpty()){
            directorioBackupProperties = "imagenes"
        }
        val directorioData = Path.of(directorioActual, directoryDataProperties).pathString
        val directorioBackup = Path.of(directorioActual,directorioBackupProperties).pathString
        val directorioImagenes = Path.of(directorioActual,directorioImagenesPropiedades).pathString
        val databaseUrl = propiedades.getProperty("database.url")
        val databaseInitTable = propiedades.getProperty("database.init.tables").toBoolean()
        val cacheSize = propiedades.getProperty("cache.size").toLong()
        val cacheExpiration = propiedades.getProperty("cache.expiration").toLong()



        return ConfigurationProperties(directorioData,directorioBackup,directorioImagenes,databaseUrl,databaseInitTable,cacheSize,cacheExpiration)
    }
}