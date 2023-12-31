package com.EstructurasDatos;

public class MatrizListas {
    private ListaEnlazada matriz;

    /**
     * Contructor de la clase matriz formada por listas de listas enlazadas.
     */
    public MatrizListas() {
        this.matriz = new ListaEnlazada();
        for (int i = 0; i < 4; i++) {
            ListaEnlazada fila = new ListaEnlazada();
            matriz.agregar(fila);
        }
    }

    /**
     * Obtiene las listas dentro de la matriz
     * @param fila numero de listas
     * @return el dato dentro de la lista
     */
    public ListaEnlazada obtenerFila(int fila) {
        Nodo filaActual = matriz.getHead();

        for (int i = 0; i < fila; i++) {
            filaActual = filaActual.next;
        }
        return (ListaEnlazada) filaActual.data;
    }

    /**
     * Recorre las filas y colunmas para agregar el dato en el espacio específico dado.
     * @param fila numero de filas
     * @param columna numero de columnas
     * @param valor dato que se va a agregar
     */
    public void agregarElemento(int fila, int columna, Object valor) {
        ListaEnlazada filaActual = obtenerFila(fila);

        Nodo nuevoNodoValor = new Nodo(valor);
        Nodo nuevoNodoColumna = new Nodo(columna);
        nuevoNodoValor.setNext(nuevoNodoColumna);
        Nodo nodoActual = filaActual.getHead();
        Nodo nodoAnterior = null;

        // Busca la columna o la última columna en la fila
        while (nodoActual != null) {
            if ((int) nodoActual.next.data == columna) {
                // Actualizar el valor existente en lugar de agregar uno nuevo
                nodoActual.data = valor;
                return; // Salir de la función si la columna ya existe
            }
            nodoAnterior = nodoActual.next;
            nodoActual = nodoAnterior.next;
        }

        if (nodoAnterior == null) {
            // Si la nueva columna debe ir al principio de la fila
            nuevoNodoColumna.setNext(nodoActual);
            filaActual.setHead(nuevoNodoValor);
        } else {
            // Agrega los nuevos nodos en medio de la fila
            nodoAnterior.setNext(nuevoNodoValor);
            nuevoNodoColumna.setNext(nodoActual);
        }

    }

    /**
     * Recorre la matriz y hace return del valor buscado en las coordenadas dadas.
     * @param fila coordenada de fila
     * @param columna coordenada de columna
     * @return elemento en la posicion
     */
    public int obtenerElemento(int fila, int columna) {
        ListaEnlazada filaActual = obtenerFila(fila);

        if (filaActual == null) {
            return 0;
        }

        Nodo nodoActual = filaActual.getHead();

        // Busca el valor en la columna especificada
        while (nodoActual != null) {
            if ((int) nodoActual.next.data == columna) {
                return (int) nodoActual.data; // Devuelve el valor almacenado en esa posición
            }
            nodoActual = nodoActual.next.next; // Avanza dos nodos en cada iteración
        }

        return 0; // Devuelve 0 si el elemento no se encuentra en la fila y columna especificadas
    }

}
