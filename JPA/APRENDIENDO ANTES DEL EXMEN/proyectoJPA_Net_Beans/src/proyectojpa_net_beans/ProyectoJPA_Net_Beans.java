
package proyectojpa_net_beans;

import Persistence.Controller;
import entidades.herencia.Cliente;

public class ProyectoJPA_Net_Beans {

    public static void main(String[] args) {
        // Cliente cliente = new Cliente("1104692163", "Cabrera", "Nahomi", "nacabrera3@utpl.edu.ec", "0968467693");
        
        Controller controller = new Controller();
        // controller.crearCliente(cliente);
        
        
        
        // controller.borrarCliente("1104692163");
        
        String n = controller.buscarNombreCliente("1104692163");
        if (n == null) {
            System.out.println("No existe");
        }
       
    }
    
}
