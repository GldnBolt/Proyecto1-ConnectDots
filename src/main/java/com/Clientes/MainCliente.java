package com.Clientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Esta clase controla las inicializaciones para que la ventana cliente pueda funcionar.
 */
public class MainCliente extends Application {
    public static Cliente cliente = new Cliente();
    public VentanaClienteController ventanaClienteController = new VentanaClienteController();
    public static VentanaJuegoController ventanaJuegoController = new VentanaJuegoController();

    /**
     * Esta funcion carga el archivo FXML de la ventana de chat del cliente, crea la scene, el titulo y todo lo necesario para la interfaz grafica.
     * @param stage the primary stage for this application, onto which the application scene can be set.
     * Applications may create other stages, if needed, but they will not be primary stages.
     * @throws IOException Esto permite que el programa mande el error si es que falla
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainCliente.class.getResource("VentanaCliente.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        ventanaClienteController = fxmlLoader.getController();

        stage.setTitle("Unirse a la partida");
        stage.setScene(scene2);
        stage.resizableProperty().setValue(false);
        stage.show();
    }

    /**
     * Esta funcion permite cargar la ventana del juego, ademas de crear el scene.
     * @throws IOException funciona como posible error.
     */
    public static void ventanajuego() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaJuegoController.class.getResource("ventanajuego2.fxml"));
        Scene scene2 = new Scene(fxmlLoader.load());
        Stage Venjuego= new Stage();
        ventanaJuegoController = fxmlLoader.getController();

        Venjuego.setScene(scene2);
        Venjuego.resizableProperty().setValue(false);
        Venjuego.show();
    }
    /**
     * Esta funcion nada más carga
     * @param args son argumentos internos necesarios para el correcto funcionamiento.
     */
    public static void main(String[] args) {
        launch();
    }
}