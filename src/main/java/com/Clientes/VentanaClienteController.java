package com.Clientes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VentanaClienteController {
    @FXML
    public Button botonUnirse;
    @FXML
    private TextField textPuerto;
    @FXML
    private TextField textIp;

    public void conectarseServidor(){
        if (!textPuerto.getText().isEmpty() && !textIp.getText().isEmpty()) {
            MainCliente.cliente.ejecutar(Integer.parseInt(textPuerto.getText()), textIp.getText());
        }

    }
}
