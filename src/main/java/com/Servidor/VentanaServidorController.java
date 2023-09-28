package com.Servidor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VentanaServidorController {
    public Button botonEmpezar;
    @FXML
    private TextField textPuerto;

    /**
     * Inicia la conexión enviando los datos de la barra de texto de la interfaz.
     */
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
