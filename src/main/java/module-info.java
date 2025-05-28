module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires logging.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;
<<<<<<< HEAD
    requires kotlinx.serialization.core;
    requires net.devrieze.xmlutil.serialization;
    requires org.jdbi.v3.sqlobject.kotlin;
    requires koin.core.jvm;
    requires java.sql;
=======
    requires koin.annotations.jvm;


>>>>>>> bbb6289dbed10a1e9d082484fb09ca16d0fa3adf

    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}
