package Presentacion;

import Entidades.Cliente;
import Logica.LCliente;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Cliente cliente1 = new Cliente(0, "1150057501", "Nahomi", "Cabrera");
    static LCliente lCliente1 = new LCliente();
    static Scanner entrada = new Scanner(System.in);
    static Cliente cliente = new Cliente();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        lCliente1.agregarCliente(cliente1);
        int menu = 0;

        System.out.println("BIENVENIDOS A TU NUEVO LUGAR FAVORITO");
        do {
            System.out.println("Ingresar Cliente            [1]");
            System.out.println("Buscar cliente por cédula   [2]");
            System.out.println("Actualizar cliente          [3]");
            System.out.println("Listar                      [4]");
            System.out.println("Agregar direccion           [5]");
            System.out.println("Agregar esposa              [6]");
            System.out.println("Salir                       [0]");
            menu = entrada.nextInt();

            switch (menu) {
                case 1:
                    if (agregarClienteMain().isEmpty()) {
                        System.out.println("No se puede ingresar el cliente");
                    } else {
                        lCliente1.agregarCliente(agregarClienteMain());
                    }
                    break;
                case 2:
                    if (buscarClienteCDL().getNombres() == null) {
                        System.out.println("No existe ese cliente");
                    } else {
                        System.out.println(cliente);
                    }
                    break;

                case 3:
                    actualizarCliente();

                case 4:
                    listarCliente();
            }
        } while(menu != 0);
    }

    public static Cliente agregarClienteMain() {
        System.out.println("Ingrese el nombre:");
        String nombre = entrada.next();

        System.out.println("Ingrese los apellidos:");
        String apellido = entrada.nextLine();

        System.out.println("Ingrese la cdl:");
        String cdl = entrada.nextLine();

        LCliente lCliente = new LCliente();

        if (lCliente.comprobarCedula(cdl)) {
            return new Cliente(0, nombre, apellido, cdl);
        } else {
            System.out.println("No se puede ingresar el cliente, revise la cdl");
        }
        return new Cliente();
    }

    public static Cliente buscarClienteCDL() throws SQLException, ClassNotFoundException {
        System.out.println("Ingrese el número de cdl:");
        String cdl = entrada.next();
        Cliente clienteBuscado = new Cliente();
        clienteBuscado.setCdl(cdl);

        return lCliente1.ObtenerCliente(clienteBuscado);
    }

    public static void actualizarCliente() {

    }

    public static void listarCliente() {

    }
}