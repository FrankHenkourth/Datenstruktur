/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ED1_Arboles;

/**
 *
 * @author Henkourth
 */

import java.util.Scanner;

public class MainArboles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        while (true) {
            System.out.println("\nMenu de Arboles Binarios");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Recorrido In-Orden");
            System.out.println("3. Recorrido Pre-Orden");
            System.out.println("4. Recorrido Post-Orden");
            System.out.println("5. Buscar elemento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a insertar: ");
                    arbol.insertar(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Recorrido In-Orden: ");
                    arbol.inOrden();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Recorrido Pre-Orden: ");
                    arbol.preOrden();
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Recorrido Post-Orden: ");
                    arbol.postOrden();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Ingrese el valor a buscar: ");
                    System.out.println(arbol.buscar(scanner.nextInt()) ? "Encontrado" : "No encontrado");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no vlida. Intente de nuevo.");
            }
        }
    }
}
