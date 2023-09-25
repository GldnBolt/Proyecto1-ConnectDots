package com.Clientes;

import javafx.application.Application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.shape.Line;


public class VentanaJuegoController{
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button7;
    @FXML
    public Button button8;
    @FXML
    public Button button9;
    @FXML
    public Button button10;
    @FXML
    public Button button11;
    @FXML
    public Button button12;
    @FXML
    public Button button13;
    @FXML
    public Button button14;
    @FXML
    public Button button15;
    @FXML
    public Button button16;
    @FXML
    public Line Linea12;
    @FXML
    public Line Linea23;
    @FXML
    public Line linea67;
    @FXML
    public Line linea34;
    @FXML
    public Line linea56;
    @FXML
    public Line linea78;
    @FXML
    public Line Linea15;
    @FXML
    public Line linea36;
    @FXML
    public Line linea26;
    @FXML
    public Line linea48;
    @FXML
    public Line linea59;
    @FXML
    public Line linea910;
    @FXML
    public Line linea610;
    @FXML
    public Line linea1011;
    @FXML
    public Line linea711;
    @FXML
    public Line linea1112;
    @FXML
    public Line linea812;
    @FXML
    public Line linea1314;
    @FXML
    public Line linea1415;
    @FXML
    public Line linea1516;
    @FXML
    public Line linea913;
    @FXML
    public Line linea1014;
    @FXML
    public Line linea1115;
    @FXML
    public Line linea1216;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; " +
                "-fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;");


        if (clickedButton == button1) {
            //Linea12.setEndX(button1.getLayoutX());
            Linea12.setEndY(button1.getLayoutY());
            Linea15.setEndX(button1.getLayoutX());
           // Linea15.setEndY(button1.getLayoutY());

        } else if (clickedButton == button2) {
            Linea23.setEndX(button2.getLayoutX());
            Linea23.setEndY(button2.getLayoutY());
            linea26.setEndX(button2.getLayoutX());
            linea26.setEndY(button2.getLayoutY());

        }}
}
