module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}