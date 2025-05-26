package dev.alejandroaitorjesusdiego.proyectoprogramacion3.database

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class JdbiManagerTest {

    @Test
    fun getUrlNormal() {
    }

    @Test
    fun getDatabaseTables() {
        val jdbi = JdbiManager(
            databaseUrl = TODO(),
            databaseInitTables = TODO()
        )
        val realidad = jdbi.databaseTables

        assertEquals(realidad, true)
    }

    @Test
    fun getJdbi() {
    }

    @Test
    fun executeSqlScriptFromResources() {
    }

    @Test
    fun executeSqlScript() {
    }

    @Test
    fun provideDataBaseManager() {
    }
}