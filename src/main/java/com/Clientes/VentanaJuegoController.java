package com.Clientes;

import com.EstructurasDatos.MatrizListas;
import java.util.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
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
    public Button button6;
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
    public Line linea37;
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
    ArrayList<Button> botones = new ArrayList<>();
    @FXML
    ArrayList<Line> lineas = new ArrayList<>();

    public boolean estado;
    public String estiloBase = "-fx-background-color: #0072C6; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;";
    public String estiloBoton = "-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; -fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;";

    @FXML
    MatrizListas matriz = new MatrizListas();

    public void initialize(){
        List<Button> botonesAgregados = Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14, button15, button16);
        List<Line> lineasAgregadas = Arrays.asList(Linea12, Linea15, Linea23, linea34, linea26, linea67, linea78, linea37, linea48, linea56, linea59, linea711, linea610, linea812, linea910, linea913, linea1011, linea1014, linea1112, linea1115, linea1216, linea1314, linea1415, linea1516);
        botones.addAll(botonesAgregados);
        lineas.addAll(lineasAgregadas);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #8608a5; -fx-background-radius: 50%; -fx-min-width: 50px; " +
                "-fx-min-height: 50px; -fx-max-width: 50px; -fx-max-height: 50px;");
        verificarLineas();
        verificarFinal();
    }

    @FXML
    public void cambiarEstadoBotones(boolean estado){
        if (estado){
            for (Button boton : botones){
                Platform.runLater(() -> boton.setDisable(true));
            }
        } else {
            for (Button boton : botones){
                Platform.runLater(() -> boton.setDisable(false));
            }
        }
    }

    @FXML
    public void recibir(String mensaje) {
        System.out.println("Cliente ha recibido:" + mensaje);
        estado = !estado;
        if (mensaje.equals("turno")){
            cambiarEstadoBotones(estado);
        } else {
            System.out.println("manejo de matriz");
        }
    }

    @FXML
    public void enviarMatriz() {
        MainCliente.cliente.enviar("turno");
    }
    @FXML
    public void verificarFinal() {
        for (Line linea : lineas){
            if (linea.getStroke().equals(Paint.valueOf("#33FF36"))){
                System.out.println("bien");
            } else {
                return;
            }
        }
        Alert ventanaFinal = new Alert(Alert.AlertType.INFORMATION);
        ventanaFinal.setTitle("Final del Juego");
        ventanaFinal.setHeaderText("La partida ha terminado");
        ventanaFinal.setContentText("¡Gracias por jugar!");
        ventanaFinal.showAndWait();
    }
    @FXML
    public void verificarLineas(){
        if ((Objects.equals(button1.getStyle(), estiloBoton) & (Objects.equals(button2.getStyle(), estiloBoton)))) {
            button1.setStyle(estiloBase);
            button2.setStyle(estiloBase);
            Linea12.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button2.getStyle(), estiloBoton) & (Objects.equals(button3.getStyle(), estiloBoton)))) {
            button2.setStyle(estiloBase);
            button3.setStyle(estiloBase);
            enviarMatriz();
            Linea23.setStroke(Paint.valueOf("#33FF36"));
        }
        if ((Objects.equals(button3.getStyle(), estiloBoton) & (Objects.equals(button4.getStyle(), estiloBoton)))) {
            button3.setStyle(estiloBase);
            button4.setStyle(estiloBase);
            linea34.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button1.getStyle(), estiloBoton) & (Objects.equals(button5.getStyle(), estiloBoton)))) {
            button1.setStyle(estiloBase);
            button5.setStyle(estiloBase);
            Linea15.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button5.getStyle(), estiloBoton) & (Objects.equals(button6.getStyle(), estiloBoton)))) {
            button5.setStyle(estiloBase);
            button6.setStyle(estiloBase);
            linea56.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button6.getStyle(), estiloBoton) & (Objects.equals(button7.getStyle(), estiloBoton)))) {
            button6.setStyle(estiloBase);
            button7.setStyle(estiloBase);
            linea67.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button7.getStyle(), estiloBoton) & (Objects.equals(button8.getStyle(), estiloBoton)))) {
            button7.setStyle(estiloBase);
            button8.setStyle(estiloBase);
            linea78.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button2.getStyle(), estiloBoton) & Objects.equals(button6.getStyle(), estiloBoton))) {
            button2.setStyle(estiloBase);
            button6.setStyle(estiloBase);
            linea26.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button3.getStyle(), estiloBoton) & Objects.equals(button7.getStyle(), estiloBoton))) {
            button3.setStyle(estiloBase);
            button7.setStyle(estiloBase);
            linea37.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button4.getStyle(), estiloBoton) & (Objects.equals(button8.getStyle(), estiloBoton)))) {
            button4.setStyle(estiloBase);
            button8.setStyle(estiloBase);
            linea48.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button5.getStyle(), estiloBoton) & (Objects.equals(button9.getStyle(), estiloBoton)))) {
            button5.setStyle(estiloBase);
            button9.setStyle(estiloBase);
            linea59.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button6.getStyle(), estiloBoton) & (Objects.equals(button10.getStyle(), estiloBoton)))) {
            button6.setStyle(estiloBase);
            button10.setStyle(estiloBase);
            linea610.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button7.getStyle(), estiloBoton) & (Objects.equals(button11.getStyle(), estiloBoton)))) {
            button7.setStyle(estiloBase);
            button11.setStyle(estiloBase);
            linea711.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button8.getStyle(), estiloBoton) & (Objects.equals(button12.getStyle(), estiloBoton)))) {
            button8.setStyle(estiloBase);
            button12.setStyle(estiloBase);
            linea812.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button9.getStyle(), estiloBoton) & (Objects.equals(button13.getStyle(), estiloBoton)))) {
            button9.setStyle(estiloBase);
            button13.setStyle(estiloBase);
            linea913.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button10.getStyle(), estiloBoton) & (Objects.equals(button14.getStyle(), estiloBoton)))) {
            button10.setStyle(estiloBase);
            button14.setStyle(estiloBase);
            linea1014.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button11.getStyle(), estiloBoton) & (Objects.equals(button15.getStyle(), estiloBoton)))) {
            button11.setStyle(estiloBase);
            button15.setStyle(estiloBase);
            linea1115.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button12.getStyle(), estiloBoton) & (Objects.equals(button16.getStyle(), estiloBoton)))) {
            button12.setStyle(estiloBase);
            button16.setStyle(estiloBase);
            linea1216.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button9.getStyle(), estiloBoton) & (Objects.equals(button10.getStyle(), estiloBoton)))) {
            button9.setStyle(estiloBase);
            button10.setStyle(estiloBase);
            linea910.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button10.getStyle(), estiloBoton) & (Objects.equals(button11.getStyle(), estiloBoton)))) {
            button10.setStyle(estiloBase);
            button11.setStyle(estiloBase);
            linea1011.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button11.getStyle(), estiloBoton) & (Objects.equals(button12.getStyle(), estiloBoton)))) {
            button11.setStyle(estiloBase);
            button12.setStyle(estiloBase);
            linea1112.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button13.getStyle(), estiloBoton) & (Objects.equals(button14.getStyle(), estiloBoton)))) {
            button13.setStyle(estiloBase);
            button14.setStyle(estiloBase);
            linea1314.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button14.getStyle(), estiloBoton) & (Objects.equals(button15.getStyle(), estiloBoton)))) {
            button14.setStyle(estiloBase);
            button15.setStyle(estiloBase);
            linea1415.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
        if ((Objects.equals(button15.getStyle(), estiloBoton) & (Objects.equals(button16.getStyle(), estiloBoton)))) {
            button15.setStyle(estiloBase);
            button16.setStyle(estiloBase);
            linea1516.setStroke(Paint.valueOf("#33FF36"));
            enviarMatriz();
        }
    }
}
