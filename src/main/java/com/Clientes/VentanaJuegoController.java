package com.Clientes;

import javafx.application.Application;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaJuegoController extends Application {
   // public static Cliente cliente = new Cliente();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaJuegoController.class.getResource("ventanajuego2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        stage.setTitle("Unirse a la partida");
        stage.setScene(scene2);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

}
