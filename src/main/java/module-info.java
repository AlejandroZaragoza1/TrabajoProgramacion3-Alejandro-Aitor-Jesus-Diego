module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires ch.qos.logback.classic;
    requires net.devrieze.xmlutil.serialization;
    requires kotlin.result.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;

    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}
