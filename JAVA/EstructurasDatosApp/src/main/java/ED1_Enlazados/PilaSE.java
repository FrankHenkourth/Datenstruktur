/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class PilaSE<T> {
    private ListaSE<T> lista;

    public PilaSE() {
        this.lista = new ListaSE<>();
    }

    public void push(T valor) {
        lista.insertar(0, valor);
    }

    public T pop() {
        if (lista.vacia()) {
            throw new IllegalStateException("Pila vacía");
        }
        T valor = lista.obtener(0);
        lista.eliminar(0);
        return valor;
    }

    public T peek() {
        if (lista.vacia()) {
            throw new IllegalStateException("Pila vacía");
        }
        return lista.obtener(0);
    }

    public boolean vacia() {
        return lista.vacia();
    }

    public int longitud() {
        return lista.longitud();
    }
}
