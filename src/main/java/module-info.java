module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires logging.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;
    requires koin.annotations.jvm;
    requires kotlinx.serialization.core;
    requires net.devrieze.xmlutil.serialization;
    requires ch.qos.logback.classic;
    requires kotlin.result.jvm;
    requires org.jdbi.v3.sqlobject.kotlin;
    requires com.github.benmanes.caffeine;
    requires kotlinx.serialization.json;
    requires java.sql;
    requires io.leangen.geantyref;
    requires kotlin.reflect;
    requires open;
    requires jbcrypt; // BCrypt


    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml, kotlin.reflect, org.jdbi.v3.core;
    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.dao to kotlin.reflect, org.jdbi.v3.core;
    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.controllers to javafx.fxml;
    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3.gestion.models to org.jdbi.v3.core, javafx.fxml, javafx.base; // Si no esta esto revienta leyendo los modelos


    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}

