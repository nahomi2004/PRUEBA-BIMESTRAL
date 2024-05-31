package Presentacion;

import PEntidades.Cliente;
import PEntidades.Direcc;
import PEntidades.Hijo;
import PLogica.LCliente;
import PLogica.LDirecc;
import PLogica.LHijo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Hijo> hijos = new ArrayList<>();
        Cliente cliente = new Cliente();
        int menu = 0;

        System.out.println("------------------------------------------------------------");
        System.out.println("PARA PODER MODIFICAR EL USUARIO, POR FAVOR, CREELO");

        do {
            System.out.println("Ingresar Cliente (0)");
            System.out.println("Dirección del usuario (1)");
            System.out.println("Hijos del usuario (2)");
            System.out.println("Listar (3)");
            System.out.println("Salir (4)");
            menu = entrada.nextInt();

            switch (menu) {
                case 0:
                    if (cliente.isEmptyuwu()) {
                        cliente = agregarCliente();
                    } else {
                        System.out.println("Ya existe un cliente");
                    }
                    break;

                case 1:
                    if (!cliente.isEmptyuwu() && cliente.getDirec() == null) {
                        cliente.setDirec(agregarDireccion());
                    } else {
                        System.out.println(">>> Error al agregar la dirección <<<");
                        System.out.println("RECUERDE:");
                        System.out.println("No puede agregar una direccion sin un cliente");
                        System.out.println("No puede agregar una direccion más al cliente");
                    }
                    break;

                case 2:
                    if (!cliente.isEmptyuwu()) {
                       cliente.setHijos(agregarHijos(hijos));
                    }  else {
                        System.out.println(">>> Error al registrar hijos <<<");
                        System.out.println("RECUERDE:");
                        System.out.println("No puede registrar hijos sin un cliente");
                    }
                    break;

                case 3:
                    if(cliente.getDirec() != null && !cliente.isEmptyuwu()) {
                        listarClienteTodo(cliente);
                    } else if (cliente.getDirec() == null && !cliente.isEmptyuwu()){
                        LCliente lcliente = new LCliente(cliente);

                        boolean valido = lcliente.comprobarCedula();
                        boolean valido3 = lcliente.comprobarCorreo();

                        if (valido && valido3) {
                            System.out.println("Nombre del cliente " + cliente.getNombre());
                            System.out.println("Apellido del cliente " + cliente.getApellido());
                            System.out.println("Cedula del usuario " + cliente.getCedula());
                            System.out.println("Correo del usuario: " + cliente.getCorreo());
                            if (!cliente.getHijos().isEmpty()) {
                                for(int i = 0; i < cliente.getHijos().size(); i++) {
                                    System.out.printf("Nombre (hijo): %s\n" +
                                                    "Edad (hijo): %d\n",
                                            cliente.getHijos().get(i).getNombre(),
                                            cliente.getHijos().get(i).getEdad());
                                }
                            }
                        } else if (!valido) {
                            System.out.println("Compruebe su cdl");
                            System.out.println(cliente.getCedula());
                        } else {
                            System.out.println("Compruebe el correo, no debe faltar el dominio\n" + cliente.getCorreo());
                        }
                    } else {
                        System.out.println("No ha ingresado nada uwu");
                    }
                    break;
            }
        } while (menu != 4);
    }

    public static Direcc agregarDireccion() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Dirección del usuario");
        System.out.println("Calle Principal:");
        String cllp = entrada.nextLine();
        System.out.println("Primera Calle Secundaria:");
        String clls1 = entrada.nextLine();
        System.out.println("En caso de no tener informacion sobre lo siguiente poner \"ninguno\":");
        System.out.println("Segunda Calle Secundaria:");
        String clls2 = entrada.nextLine();
        System.out.println("Referencia:");
        String refe = entrada.nextLine();

        return new Direcc(cllp, clls1, clls2, refe);
    }

    public static ArrayList<Hijo> agregarHijos(ArrayList<Hijo> hijos) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Indique la cantidad de hijos que desea agregar:");
        int numHijos = entrada.nextInt();

        if(numHijos < 0) {
            System.out.println("Ingrese un número válido, por favor");
        } else if (numHijos > 0) {

            for (int i = 0; i < numHijos; i++) {
                System.out.println("------------------------------------------------");
                System.out.printf("Hijo #%d\n", i + 1);
                System.out.println("Ingrese su nombre (hijo):");
                String nombreHijo = entrada.next();
                System.out.println("Ingrese su edad (hijo):");
                int edadHijo = entrada.nextInt();
                LHijo lHijo = new LHijo(new Hijo(nombreHijo, edadHijo));
                if (lHijo.comprobarEdad()){
                    hijos.add(new Hijo(nombreHijo, edadHijo));
                }
            }
        }
        return hijos;
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
        return new Cliente(nombre, apellido, cedula, correo);
    }

    public static void listarClienteTodo(Cliente cliente) {
        LCliente lcliente = new LCliente(cliente);

        LDirecc lDirecc = new LDirecc(cliente.getDirec());

        boolean valido = lcliente.comprobarCedula();
        boolean valido2 = lDirecc.comprobarCalles();
        boolean valido3 = lcliente.comprobarCorreo();

        if (valido && valido2 && valido3) {
            System.out.println("Nombre del cliente " + cliente.getNombre());
            System.out.println("Apellido del cliente " + cliente.getApellido());
            System.out.println("Cedula del usuario " + cliente.getCedula());
            System.out.println("Correo del usuario: " + cliente.getCorreo());
            System.out.printf("Direccción del Usuario\n" +
                            "Calle Principal: %s\n" +
                            "Calle Secundaria 1: %s\n" +
                            "Calle Secundaria 2: %s\n", cliente.getDirec().getCllPrincipal(), cliente.getDirec().getCllSec1(),
                    cliente.getDirec().getCllSec2());
            if (!cliente.getHijos().isEmpty()) {
                for(int i = 0; i < cliente.getHijos().size(); i++) {
                    System.out.printf("Nombre (hijo): %s\n" +
                                    "Edad (hijo): %d\n",
                            cliente.getHijos().get(i).getNombre(),
                            cliente.getHijos().get(i).getEdad());
                }
            }
        } else if (!valido) {
            System.out.println("Compruebe su cdl");
            System.out.println(cliente.getCedula());
        } else if (!valido2) {
            System.out.println("Compruebe su dirección, las calles no se pueden repetir");
            System.out.printf("Calle Principal: %s\n" +
                            "Calle Secundaria 1: %s\n" +
                            "Calle Secundaria 2: %s\n",
                    cliente.getDirec().getCllPrincipal(),
                    cliente.getDirec().getCllSec1(),
                    cliente.getDirec().getCllSec2());
        } else {
            System.out.println("Compruebe el correo, no debe faltar el dominio\n" + cliente.getCorreo());
        }
    }
}




