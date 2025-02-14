package ED1_Enlazados;

import java.util.Scanner;

public class EstructurasDatosApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaSE<Integer> listaSE = new ListaSE<>();
        PilaSE<Integer> pilaSE = new PilaSE<>();
        ColaSE<Integer> colaSE = new ColaSE<>();

        while (true) {
            System.out.println("\nMenu Principal");
            System.out.println("1. Lista Simple Enlazada");
            System.out.println("2. Pila Simple Enlazada");
            System.out.println("3. Cola Simple Enlazada");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuListaSE(listaSE, scanner);
                    break;
                case 2:
                    menuPilaSE(pilaSE, scanner);
                    break;
                case 3:
                    menuColaSE(colaSE, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private static void menuListaSE(ListaSE<Integer> lista, Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Lista Simple Enlazada");
            System.out.println("1. Adicionar elemento");
            System.out.println("2. Insertar elemento en posicion");
            System.out.println("3. Obtener elemento");
            System.out.println("4. Eliminar elemento");
            System.out.println("5. Mostrar longitud");
            System.out.println("6. Buscar elemento");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a adicionar: ");
                    lista.adicionar(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Ingrese la posicion: ");
                    int pos = scanner.nextInt();
                    System.out.print("Ingrese el valor a insertar: ");
                    lista.insertar(pos, scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Ingrese la posicion: ");
                    System.out.println("Elemento: " + lista.obtener(scanner.nextInt()));
                    break;
                case 4:
                    System.out.print("Ingrese la posicion: ");
                    lista.eliminar(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Longitud: " + lista.longitud());
                    break;
                case 6:
                    System.out.print("Ingrese el valor a buscar: ");
                    int index = lista.buscar(scanner.nextInt());
                    System.out.println(index != -1 ? "Encontrado en posicion: " + index : "No encontrado");
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private static void menuPilaSE(PilaSE<Integer> pila, Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Pila Simple Enlazada");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Mostrar longitud");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a apilar: ");
                    pila.push(scanner.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Elemento desapilado: " + pila.pop());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento en la cima: " + pila.peek());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Longitud: " + pila.longitud());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    private static void menuColaSE(ColaSE<Integer> cola, Scanner scanner) {
        while (true) {
            System.out.println("\nMenu Cola Simple Enlazada");
            System.out.println("1. Encolar");
            System.out.println("2. Desencolar");
            System.out.println("3. Frente");
            System.out.println("4. Mostrar longitud");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a encolar: ");
                    cola.encolar(scanner.nextInt());
                    break;
                case 2:
                    try {
                        System.out.println("Elemento desencolado: " + cola.desencolar());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Elemento en el frente: " + cola.frente());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Longitud: " + cola.longitud());
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        }
    }
}