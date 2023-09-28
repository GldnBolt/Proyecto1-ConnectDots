package com.Servidor;

import com.EstructurasDatos.Cola;
import com.EstructurasDatos.ListaEnlazada;
import com.EstructurasDatos.MatrizListas;
import com.EstructurasDatos.Nodo;
import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private final ListaEnlazada clientes = new ListaEnlazada();
    private final Cola colaClientes = new Cola();
    private final Cola colaSalidaClietnes = new Cola();
    private final ListaEnlazada flujosSalida = new ListaEnlazada();
    private final ListaEnlazada flujosEntrada = new ListaEnlazada();
    private ServerSocket serverSocket;
    private int turno;
    MatrizListas matriz = new MatrizListas();
    Gson gson = new Gson();
    String matrizJson;

    /**
     * Esta función permite que se cree el socket al cual se van a conectar los clientes y genera una cola de clientes
     * para almacenar cuantos hay y poder cargar las partidas. También inicia los flujos de recibir información y ejecuta la función que inicia la partida.
     * @param puerto es el puerto que se pone a la hora de que se abre la ventana del servidor.
     */
    public void ejecutar(int puerto) {
        Thread hiloServidor = new Thread(() -> {
            try {
                serverSocket = new ServerSocket(puerto);
                System.out.println("Servidor esperando jugadores en el puerto " + puerto + "...");
                while (true) {
                    Socket clienteSocket = serverSocket.accept();
                    System.out.println("Un jugador se ha conectado");

                    clientes.agregar(clienteSocket);
                    colaClientes.enqueue(clienteSocket);
                    DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
                    flujosSalida.agregar(salida);
                    colaSalidaClietnes.enqueue(salida);
                    DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
                    flujosEntrada.agregar(entrada);

                    if (turno <= 0) {
                        empezarJuego();
                    }

                    Thread hiloClientes = new Thread(() -> {
                        try {
                            recibir(clienteSocket, entrada);
                        } finally {
                            cerrarConexion(clienteSocket, salida, entrada);
                        }
                    });
                    hiloClientes.start();
                }
            } catch (IOException e) {
                System.out.println("Error al iniciar el servidor");
            }
        });
        hiloServidor.start();
    }

    /**
     * Esta función verifica que haya dos jugadores conectados para empezar el juego y llama a la función que define los turnos.
     */
    public void empezarJuego(){
        if (colaClientes.tamano() >= 2){
            System.out.println("empezar"); //poner funcion empezar
            turno++;
            enviarTodos("turno");
        } else {
            System.out.println("Esperando más jugadores");
            //manejoMatriz();
        }
    }

    public void manejoMatriz(){
        if (this.matriz.obtenerElemento(1, 1) != 0){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    this.matriz.agregarElemento(i, j, 0);
                }
            }
        }
        this.matrizJson = gson.toJson(this.matriz);
        System.out.println(this.matrizJson);

    }

    /**
     * Esta funcion permite enviar los mensajes entre el servidor y los clientes.
     * @param mensaje es el mensaje que se envia entre el servidor y los clientes.
     */
    public void enviarTodos(String mensaje) {
        try {
            Nodo nodoSalida = flujosSalida.getHead();
            while (nodoSalida != null) {
                DataOutputStream salida = (DataOutputStream) nodoSalida.data;
                salida.writeUTF(mensaje);
                salida.flush();
                nodoSalida = nodoSalida.getNext();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Esta función envia un mensaje a un cliente especifico en el orden de la cola.
     * @param mensaje mensaje a enviar
     */
    public void enviarEspecifico(String mensaje){
        try {
            DataOutputStream salida = (DataOutputStream) colaSalidaClietnes.dequeue();
            salida.writeUTF(mensaje);
            salida.flush();
            colaSalidaClietnes.enqueue(salida);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Esta funcion permite recibir los mensajes que envian los clientes.
     * @param clienteSocket el socket al cual se está escuchando
     * @param entrada la entrada de la cual está leyendo el mensaje
     */
    public void recibir(Socket clienteSocket, DataInputStream entrada) {
        try {
            while (true) {
                String mensajeRecibido = entrada.readUTF();

                if (mensajeRecibido.equals("turno")) {
                    turno++;
                    //enviarEspecifico(mensajeRecibido);
                    colaClientes.dequeue();
                    enviarTodos(mensajeRecibido);
                    colaClientes.enqueue(clienteSocket);
                } else {
                    matriz = gson.fromJson(mensajeRecibido,MatrizListas.class);
                    matrizJson = gson.toJson(matriz);
                    enviarTodos(matrizJson);
                }
            }
        } catch (EOFException e) {
            System.out.println("Conexión cerrada por el cliente");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Esta función permite cerrar la conexión entre el servidor y los clientes de manera que no haya errores.
     * @param clienteSocket Socket que se va a cerrar
     * @param salida Salida del socket a cerrar
     * @param entrada entrada del socket a cerrar
     */
    public void cerrarConexion(Socket clienteSocket, DataOutputStream salida, DataInputStream entrada) {
        try {
            clienteSocket.close();
            clientes.eliminar(clienteSocket);

            Nodo nodoSalida = flujosSalida.getHead();
            while (nodoSalida != null) {
                if (nodoSalida.data == salida) {
                    flujosSalida.eliminar(salida);
                    break;
                }
                nodoSalida = nodoSalida.getNext();
            }

            Nodo nodoEntrada = flujosEntrada.getHead();
            while (nodoEntrada != null) {
                if (nodoEntrada.data == entrada) {
                    flujosEntrada.eliminar(entrada);
                    break;
                }
                nodoEntrada = nodoEntrada.getNext();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
