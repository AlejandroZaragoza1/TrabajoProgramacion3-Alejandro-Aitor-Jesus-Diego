module dev.alejandroaitorjesusdiego.proyectoprogramacion3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires logging.jvm;
    requires org.jdbi.v3.core;
    requires org.jdbi.v3.kotlin;
    requires org.jdbi.v3.sqlobject;
    requires koin.annotations.jvm;
<<<<<<< HEAD
    requires kotlinx.serialization.core;
    requires net.devrieze.xmlutil.serialization;
=======
    requires org.jdbi.v3.sqlobject.kotlin;
>>>>>>> dev


    opens dev.alejandroaitorjesusdiego.proyectoprogramacion3 to javafx.fxml;
    exports dev.alejandroaitorjesusdiego.proyectoprogramacion3;
}