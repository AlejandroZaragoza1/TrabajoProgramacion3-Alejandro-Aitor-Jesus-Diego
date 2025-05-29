package dev.alejandroaitorjesusdiego.proyectoprogramacion3

import javafx.application.Application
import javafx.stage.Stage
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.di.Dependencies
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models.Usuario
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.routes.RoutesManager
import org.mindrot.jbcrypt.BCrypt
import kotlin.concurrent.thread

class HelloApplication : Application() {
    override fun start(stage: Stage) {
        RoutesManager.apply {
            app = this@HelloApplication
        }.run {
            initSplashStage(stage)
        }
        thread{
            val dao = Dependencies.provideUserDao()
            val hashAdmin = BCrypt.hashpw("1234", BCrypt.gensalt())
            val hashUser = BCrypt.hashpw("1234", BCrypt.gensalt())
            val a = Usuario("admin", hashAdmin)
            val u = Usuario("user", hashUser)
            dao.saveUser(a)
            dao.saveUser(u)
        }
    }
}

fun main() {
    Application.launch(HelloApplication::class.java)
}
