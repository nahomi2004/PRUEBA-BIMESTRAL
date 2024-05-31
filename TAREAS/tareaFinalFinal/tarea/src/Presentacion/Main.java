/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import Entidades.Cliente;
import Entidades.DireccEntrega;
import Entidades.Paquete;
import Logica.LCliente;
import Logica.LDirecc;

import java.util.Scanner;

/**
 *
 * @author andreflores
 */

/*
* Orly Flores
* Nahomi Cabrera
* */
public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Cliente cliente = new Cliente();
        int menu;

        System.out.println("---------------------------------------------------------------------");

        do {
            System.out.println("Ingresar Cliente            (1)");
            System.out.println("Dirección del usuario       (2)");
            System.out.println("Ingresar Paquete            (3)");
            System.out.println("Listar                      (4)");
            System.out.println("Salir                       (0)");
            menu = entrada.nextInt();
            switch (menu) {
                case 1:
                    if (cliente.isEmptyUwU()) {
                        agregarCliente(cliente);
                    } else {
                        System.out.println("Ya existe un cliente");
                    }
                    break;
                case 2:
                    if (cliente.isEmptyUwU()) {
                        System.out.println("Debe ingresar un cliente primero");
                    } else {
                        DireccEntrega direccion = agregarDireccion();
                        cliente.getDireccEntrega().add(direccion);
                        System.out.println("Dirección agregada exitosamente");
                    }
                    break;
                case 3:
                    if (cliente.isEmptyUwU() || cliente.getDireccEntrega().isEmpty()) {
                        System.out.println("Debe ingresar un cliente y su dirección primero");
                    } else {
                        Paquete paquete = agregarPaquete();
                        cliente.setPaquete(paquete); 
                        System.out.println("Paquete agregado exitosamente");
                    }
                    break;

                case 4:
                    if (cliente.isEmptyUwU()) {
                        System.out.println("No hay nada que listar");
                    } else {
                        System.out.println(cliente.toString());

                    }
                    break;
            }
        } while (menu != 0);

    }

    public static void agregarCliente(Cliente cliente) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos:");
        System.out.println("Nombre del usuario");
        String nombre = entrada.nextLine();
        cliente.setNombre(nombre);
        System.out.println("Apellido del usuario");
        String apellido = entrada.nextLine();
        cliente.setApellido(apellido);
        String cedula;
        do {
            System.out.println("Cedula del usuario");
            cedula = entrada.nextLine();
            if (!LCliente.comprobarCedula(cedula)) {
                System.out.println("Cédula inválida. Inténtelo de nuevo.");
            } else {
                cliente.setCedula(cedula);
            }
        } while (!LCliente.comprobarCedula(cedula));

        String correo;
        do {
            System.out.println("Ingrese el correo electrónico del usuario");
            correo = entrada.nextLine();
            if (!LCliente.comprobarCorreo(correo)) {
                System.out.println("Correo electrónico inválido. Inténtelo de nuevo.");
            } else {
                cliente.setCorreo(correo);
            }
        } while (!LCliente.comprobarCorreo(correo));

    }

    public static DireccEntrega agregarDireccion() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos de la dirección:");

        LDirecc lDirecc = new LDirecc();

        String calle1, calle2;
        do {
            System.out.println("Calle Principal");
            calle1 = entrada.nextLine();
            System.out.println("Calle Secundaria");
            calle2 = entrada.nextLine();

            if (lDirecc.comprobarCalles(calle1, calle2)) {
                System.out.println("Ambas calles no pueden ser iguales. Inténtelo de nuevo.");
                System.out.println(lDirecc.comprobarCalles(calle1, calle2));
            }
        } while (lDirecc.comprobarCalles(calle1, calle2));

        System.out.println("Referencia");
        String referencia = entrada.nextLine();

        return new DireccEntrega(1, calle1, calle2, referencia);
    }

    public static Paquete agregarPaquete() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos del paquete:");
        System.out.println("Código");
        String codigo = entrada.nextLine();
        System.out.println("Descripción");
        String descripcion = entrada.nextLine();
        System.out.println("Peso (kg)");
        double peso = entrada.nextDouble();
        System.out.println("Largo (m)");
        double largo = entrada.nextDouble();
        System.out.println("Ancho (m)");
        double ancho = entrada.nextDouble();

        return new Paquete(1, codigo, descripcion, peso, largo, ancho);
    }

}
