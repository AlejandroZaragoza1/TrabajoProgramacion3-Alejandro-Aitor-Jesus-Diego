package dev.alejandroaitorjesusdiego.proyectoprogramacion3.configuration

data class ConfigurationProperties(
    val dataDirectory: String,
    val backupDirectory: String,
    val imagesDirectory: String,
    val databaseUrl: String,
    val databaseInitTables: Boolean,
    val cacheSize: Long,
    val cacheExpiration: Long
)
