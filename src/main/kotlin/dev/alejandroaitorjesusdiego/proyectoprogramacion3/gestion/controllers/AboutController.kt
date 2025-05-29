package dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.controllers

import com.vaadin.open.Open
import javafx.fxml.FXML
import javafx.scene.Cursor
import javafx.scene.control.Hyperlink
import org.lighthousegames.logging.logging

/**
 * Clase que representa el controlador de la vista About.
 * @property githubLinkDiego Link al GitHub de Carlos.
 * @property githubLinkAitor Link al GitHub de Samuel.
 * @property githubLinkJesus Link al GitHub de Jesús.
 * @property githubLinkAlejandro Link al GitHub de Jesús.
 */
class AboutController {
    private val logger = logging()

    @FXML
    lateinit var githubLinkDiego: Hyperlink

    @FXML
    lateinit var githubLinkAitor: Hyperlink

    @FXML
    lateinit var githubLinkJesus: Hyperlink

    @FXML
    lateinit var githubLinkAlejandro: Hyperlink

    /**
     * Método automáticamente llamado por JavaFX cuando se crea el [AboutController] asociado al correspondiente .fxml
     * @see initLinks
     * @see initEffects
     */
    fun initialize() {
        initLinks()
        initEffects()
    }

    /**
     * Establece las funciones que tendrán los links al pulsar en ellos.
     */
    private fun initLinks(){
        githubLinkDiego.setOnAction {
            logger.debug{ "Abriendo Github de Diego" }
            Open.open("https://github.com/ByDiegox78")
        }
        githubLinkAitor.setOnAction {
            logger.debug{ "Abriendo Github de Aitor" }
            Open.open("https://github.com/Aitoraros")
        }


        githubLinkJesus.setOnAction {
            logger.debug{ "Abriendo Github de Jesus" }
            Open.open("https://github.com/JesusCoboArrogante")
        }
        githubLinkAlejandro.setOnAction {
            logger.debug{ "Abriendo Github de Alejandro" }
            Open.open("https://github.com/AlejandroZaragoza1")
        }
    }

    /**
     * Establece los cambios en el estado del ratón al posicionarlo encima de los enlaces.
     */
    private fun initEffects() {
        githubLinkDiego.setOnMouseEntered {
            githubLinkDiego.scene.cursor = Cursor.HAND
        }

        githubLinkAitor.setOnMouseClicked {
            githubLinkAitor.scene.cursor = Cursor.HAND
        }
        githubLinkJesus.setOnMouseClicked {
            githubLinkJesus.scene.cursor = Cursor.HAND
        }

        githubLinkAlejandro.setOnMouseClicked {
            githubLinkAlejandro.scene.cursor = Cursor.HAND
    }
    }
}