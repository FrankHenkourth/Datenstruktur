/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ED1_Enlazados;

/**
 *
 * @author Henkourth
 */
public interface ILista<T> {
    void adicionar(T valor);
    void insertar(int pos, T valor);
    T obtener(int pos);
    void eliminar(int pos);
    boolean vacia();
    int longitud();
    int buscar(T valor);
}
