/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class NodoDE<T> {
    private T info;
    private NodoDE<T> siguiente;
    private NodoDE<T> anterior;

    public NodoDE(T info) {
        this.info = info;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoDE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDE<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDE<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDE<T> anterior) {
        this.anterior = anterior;
    }
}
