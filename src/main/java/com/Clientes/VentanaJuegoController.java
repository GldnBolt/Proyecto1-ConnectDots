package com.Clientes;

import javafx.application.Application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class VentanaJuegoController{
    public AnchorPane linea1111;
    public Line linea1216;
    public Line linea1115;
    public Line linea1014;
    public Line linea913;
    public Line linea1516;
    public Line linea1415;
    public Line linea1314;
    public Line linea812;
    public Line linea1112;
    public Line linea711;
    public Line linea1011;
    public Line linea610;
    public Line linea910;
    public Line linea59;
    public Line linea48;
    public Line linea36;
    public Line linea26;
    public Line Linea15;
    public Line linea78;
    public Line linea56;
    public Line linea67;
    public Line linea34;
    public Line Linea23;
    public Line Linea12;
    public Button Button1;
    public Button Button2;
    public Button Button3;
    public Button Button4;
    public Button Button5;
    public Button Button6;
    public Button Button7;
    public Button Button8;
    public Button Button9;
    public Button Button10;
    public Button Button11;
    public Button Button12;
    public Button Button13;
    public Button Button14;
    public Button Button15;
    public Button Button16;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;");


    }
}
