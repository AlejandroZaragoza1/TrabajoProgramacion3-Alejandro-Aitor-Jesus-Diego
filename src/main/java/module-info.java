module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires ch.qos.logback.classic;
    requires net.devrieze.xmlutil.serialization;
    requires kotlin.result.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;
    requires org.jdbi.v3.sqlobject.kotlin;
    requires com.github.benmanes.caffeine;
    requires kotlinx.serialization.json;
    requires logging.jvm;
    requires java.sql;
    requires io.leangen.geantyref;
    requires kotlin.reflect;
    requires open;
    requires jbcrypt; // BCrypt


    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}