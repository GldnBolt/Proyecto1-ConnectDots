module com.proyecto1connectdots {
    requires javafx.controls;
    requires javafx.fxml;
    requires RXTXcomm;
    // requires RXTXcomm;

    exports com;
    exports com.Clientes;
    opens com to javafx.fxml;
    opens com.Clientes to javafx.fxml;
    exports com.Servidor;
    opens com.Servidor to javafx.fxml;
}