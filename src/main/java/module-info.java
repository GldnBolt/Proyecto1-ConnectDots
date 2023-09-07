module com.example.proyecto1connectdots {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyecto1connectdots to javafx.fxml;
    exports com.example.proyecto1connectdots;
}