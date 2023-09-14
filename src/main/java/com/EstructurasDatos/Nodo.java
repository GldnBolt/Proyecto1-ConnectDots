package com.EstructurasDatos;

/**
 * Esta clase representa un nodo de una lista con su dato y referencia
 */
public class Nodo {
    public Object data;
    public Nodo next;

    /**
     * Contructor de nodo que lo inicializa
     * @param data la información guardada en el nodo
     */
    public Nodo(Object data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Obtiene el siguiente nodo en la lista
     * @return El siguiente nodo
     */
    public Nodo getNext() {
        return next;
    }

    /**
     *Esablece el siguiente nodo de la lista
     * @param next El noodo que se definira como siguiente
     */
    public void setNext(Nodo next) {
        this.next = next;
    }
}
