package com.Clientes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class VentanaClienteController {
    @FXML
    public Button botonUnirse;
    @FXML
    private TextField textPuerto;
    @FXML
    private TextField textIp;

    public void conectarseServidor() throws IOException {
        if (!textPuerto.getText().isEmpty() && !textIp.getText().isEmpty()) {
            MainCliente.cliente.ejecutar(Integer.parseInt(textPuerto.getText()), textIp.getText());
            com.Clientes.MainCliente.ventanajuego();
        }

    }
}
