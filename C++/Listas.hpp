#ifndef LISTAS_HPP
#define LISTAS_HPP

#include <iostream>

struct NodoSE {
    int dato;
    NodoSE* siguiente;
    NodoSE(int valor) : dato(valor), siguiente(nullptr) {}
};

class ListaSE {
public:
    NodoSE* cabeza;
    ListaSE() : cabeza(nullptr) {}
    void insertar(int valor);
    void mostrar();
};

void manejarListas();

#endif
