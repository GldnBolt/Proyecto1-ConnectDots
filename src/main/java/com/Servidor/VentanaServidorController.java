package com.Servidor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VentanaServidorController {
    public Button botonEmpezar;
    @FXML
    private TextField textPuerto;

    public void iniciarConexion(){
        if (!textPuerto.getText().isEmpty()) {
            try {
                MainServidor.servidor.ejecutar(Integer.parseInt(textPuerto.getText()));
                textPuerto.setEditable(false);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
