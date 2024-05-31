import Entidades.Cliente;

import java.util.Scanner;

/*
* Nahomi Cabrera
* Orly Flores
* */

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int menu = 0;

        System.out.println("---------------------------------------------------------------------");

        do {
            System.out.println("Ingresar Cliente            (0)");
            System.out.println("Ingresar Paquete            (1)");
            System.out.println("Dirección del usuario       (2)");
            System.out.println("Listar                      (3)");
            System.out.println("Salir                       (4)");

            switch (menu) {
                case 1:
                    if (cliente.isEmptyUwU()) {
                        cliente = agregarCliente();
                    } else {
                        System.out.println("Ya existe un cliente");
                    }
                    break;
                case 2:
                    if (cliente.isEmptyUwU() || cliente.getDireccEntrega().isEmpty()) {
                        System.out.println("Debe ingresar un cliente y su dirección");
                    } else {

                    }
                    break;
                case 3:
                    if (cliente.isEmptyUwU()) {
                        System.out.println("Se debe agregar a un cliente");
                    } else {

                    }
                    break;
                case 4:
                    if (cliente.isEmptyUwU()) {
                        System.out.println("No hay nada que listar");
                    } else {

                    }
                    break;
            }
        } while (menu != 4);
    }

    public static Cliente agregarCliente() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Nombre del usuario");
        String nombre = entrada.nextLine();
        System.out.println("Apellido del usuario");
        String apellido = entrada.nextLine();
        System.out.println("Cedula del usuario");
        String cedula = entrada.nextLine();

        System.out.println("Ingrese el correo electrónico del usuario");
        String correo = entrada.nextLine();

        return new Cliente(1, nombre, apellido, cedula, correo);
    }
}