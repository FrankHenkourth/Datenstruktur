#include "listas.hpp"

void ListaSE::insertar(int valor) {
    NodoSE* nuevo = new NodoSE(valor);
    nuevo->siguiente = cabeza;
    cabeza = nuevo;
}

void ListaSE::mostrar() {
    NodoSE* temp = cabeza;
    while (temp) {
        std::cout << temp->dato << " -> ";
        temp = temp->siguiente;
    }
    std::cout << "NULL\n";
}

void manejarListas() {
    ListaSE lista;
    lista.insertar(10);
    lista.insertar(20);
    lista.mostrar();
}
