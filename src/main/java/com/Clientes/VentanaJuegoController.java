package com.Clientes;

import javafx.application.Application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentanaJuegoController{
    @FXML
    private Button Boton11;

    public void seleccionado() {
        //boton.getid
        Boton11.setStyle("-fx-background-color: green");
    }

}
