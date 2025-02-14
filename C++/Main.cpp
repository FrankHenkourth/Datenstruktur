#include <iostream>
#include "Listas.hpp"
#include "pilas_colas.hpp"
#include "arboles.hpp"

using namespace std;

void menuListasPilasColas() {
    int opcion;
    do {
        cout << "\nMENU LISTAS, PILAS Y COLAS";
        cout << "\n1. Manejar Listas";
        cout << "\n2. Manejar Pilas";
        cout << "\n3. Manejar Colas";
        cout << "\n4. Volver al menu principal";
        cout << "\nIngrese una opcion: ";
        cin >> opcion;
        
        switch(opcion) {
            case 1:
                manejarListas();
                break;
            case 2:
                manejarPilas();
                break;
            case 3:
                manejarColas();
                break;
        }
    } while(opcion != 4);
}
/*
void menuArboles() {
    int opcion;
    do {
        cout << "\nMENU ARBOLES";
        cout << "\n1. Manejar Arbol de Busqueda";
        cout << "\n2. Manejar Arbol Binario de Busqueda";
        cout << "\n3. Volver al menu principal";
        cout << "\nIngrese una opcion: ";
        cin >> opcion;
        
        switch(opcion) {
            case 1:
                manejarArbolBusqueda();
                break;
            case 2:
                manejarABB();
                break;
        }
    } while(opcion != 3);
}

int main() {
    int opcion;
    do {
        cout << "\nMENU PRINCIPAL";
        cout << "\n1. Listas, Pilas y Colas";
        cout << "\n2. Arboles";
        cout << "\n3. Salir";
        cout << "\nIngrese una opcion: ";
        cin >> opcion;
        
        switch(opcion) {
            case 1:
                menuListasPilasColas();
                break;
            case 2:
                menuArboles();
                break;
        }
    } while(opcion != 3);
    
    return 0;
}
*/