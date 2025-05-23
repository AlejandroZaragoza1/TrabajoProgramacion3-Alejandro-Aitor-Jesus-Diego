package dev.alejandroaitorjesusdiego.proyectoprogramacion3.cache

import com.github.benmanes.caffeine.cache.Cache
import com.github.benmanes.caffeine.cache.Caffeine
import dev.alejandroaitorjesusdiego.proyectoprogramacion3.config.AppConfig
import org.example.newteam.gestion.models.Integrante
import org.lighthousegames.logging.logging
import java.util.concurrent.TimeUnit

fun ProvideIntegranteCache(config: AppConfig): Cache<Long, Integrante> {
    val logger = logging()
    logger.debug { "Inicializando cache con capacidad ${config.cacheCapacity} y duración ${config.cacheExpiration}" }
    return Caffeine.newBuilder()
        .maximumSize(config.cacheCapacity)
        .expireAfterWrite(
            config.cacheExpiration,
            TimeUnit.SECONDS
        )
        .build()
}