/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class NodoSE<T> {
    private T info;
    private NodoSE<T> siguiente;

    public NodoSE(T info) {
        this.info = info;
        this.siguiente = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoSE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSE<T> siguiente) {
        this.siguiente = siguiente;
    }
}
