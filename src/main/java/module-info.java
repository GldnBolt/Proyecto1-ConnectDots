module com.proyecto1connectdots {
    requires javafx.controls;
    requires javafx.fxml;


    exports com;
    opens com to javafx.fxml;
    exports com.Clientes;
    opens com.Clientes to javafx.fxml;
    exports com.Servidor;
    opens com.Servidor to javafx.fxml;
}