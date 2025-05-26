module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires logging.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;
    requires koin.annotations.jvm;
    requires net.devrieze.xmlutil.serialization;
    requires com.github.benmanes.caffeine;
    requires koin.core.jvm;
    requires kotlin.result.jvm;
    requires kotlinx.serialization.json;


    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}