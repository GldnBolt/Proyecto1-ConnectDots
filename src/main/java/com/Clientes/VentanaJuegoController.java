package com.Clientes;

import javafx.application.Application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class VentanaJuegoController{

    @FXML
    private Button Boton1;
    @FXML
    private Button Boton2;
    @FXML
    private Button Boton3;
    @FXML
    private Button Boton4;
    @FXML
    private Button Boton5;
    @FXML
    private Button Boton6;
    @FXML
    private Button Boton7;
    @FXML
    private Button Boton8;
    @FXML
    private Button Boton9;
    @FXML
    private Button Boton10;
    @FXML
    private Button Boton11;
    @FXML
    private Button Boton12;
    @FXML
    private Button Boton13;
    @FXML
    private Button Boton14;
    @FXML
    private Button Boton15;
    @FXML
    private Button Boton16;
    @FXML
    private Line linea12;
    @FXML
    private Line linea23;
    @FXML
    private Line linea34;
    @FXML
    private Line linea67;
    @FXML
    private Line linea56;
    @FXML
    private Line linea78;
    @FXML
    private Line linea15;
    @FXML
    private Line linea26;
    @FXML
    private Line linea36;
    @FXML
    private Line linea48;
    @FXML
    private Line linea59;
    @FXML
    private Line linea910;
    @FXML
    private Line linea610;
    @FXML
    private Line linea1011;
    @FXML
    private Line linea711;
    @FXML
    private Line linea1112;
    @FXML
    private Line linea812;
    @FXML
    private Line linea1314;
    @FXML
    private Line linea1415;
    @FXML
    private Line linea1516;
    @FXML
    private Line linea913;
    @FXML
    private Line linea1014;
    @FXML
    private Line linea1115;
    @FXML
    private Line linea1216;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;");


    }
}
