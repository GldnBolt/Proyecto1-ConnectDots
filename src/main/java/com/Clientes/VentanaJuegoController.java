package com.Clientes;

import javafx.application.Application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentanaJuegoController{


    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;");


    }
}
