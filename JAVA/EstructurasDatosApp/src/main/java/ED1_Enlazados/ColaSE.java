/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public class ColaSE<T> {
    private ListaSE<T> lista;

    public ColaSE() {
        this.lista = new ListaSE<>();
    }

    public void encolar(T valor) {
        lista.adicionar(valor);
    }

    public T desencolar() {
        if (lista.vacia()) {
            throw new IllegalStateException("Cola vacía");
        }
        T valor = lista.obtener(0);
        lista.eliminar(0);
        return valor;
    }

    public T frente() {
        if (lista.vacia()) {
            throw new IllegalStateException("Cola vacía");
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
