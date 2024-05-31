/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;
import entidades.noHerencia.*;
import entidades.herencia.*;
// import javax.persistence.*;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author D E L L
 */
public class Controller {
    BodegueroJpaController bodegueroJpaController = new BodegueroJpaController();
    ClienteJpaController clienteJpaController = new ClienteJpaController();
    DireccionJpaController direccionJpaController = new DireccionJpaController();
    EmpleadoJpaController empleadoJpaController = new EmpleadoJpaController();
    EntregaJpaController entregaJpaController = new EntregaJpaController();
    EstadoJpaController estadoJpaController = new EstadoJpaController();
    PaqueteJpaController paqueteJpaController = new PaqueteJpaController();
    PersonaJpaController personaJpaController = new PersonaJpaController();
    RepartidorJpaController repartidorJpaController = new RepartidorJpaController();
    
    public void crearBodeguero(Bodeguero bodeguero) {
        try {
            bodegueroJpaController.create(bodeguero);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarBodeguero(String bodeguero) {
        try {
            bodegueroJpaController.findBodeguero(bodeguero);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buscarNombreBodeguero(String bodeguero) {
        try {
            return bodegueroJpaController.findBodeguero(bodeguero).getNombre();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void borrarBodeguero(String bodeguero) {
        try {
            bodegueroJpaController.destroy(bodeguero);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarBodeguero(Bodeguero bodeguero) {
        try {
            bodegueroJpaController.edit(bodeguero);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // CLIENTES
    public void crearCliente(Cliente cliente) {
        try {
            clienteJpaController.create(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buscarNombreCliente(String bodeguero) {
        try {
            return clienteJpaController.findCliente(bodeguero).getNombre();
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Cliente buscarCliente(String cliente) {
        try {
            return clienteJpaController.findCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void borrarCliente(String cliente) {
        try {
            clienteJpaController.destroy(cliente);
            System.out.println("Cliente borrado con éxito");
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarCliente(Cliente cliente) {
        try {
            clienteJpaController.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // DIRECCIÓN
    public void crearDireccion(Direccion direccion) {
        try {
            direccionJpaController.create(direccion);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarDireccion(String direccion) {
        try {
            direccionJpaController.findDireccion(direccion);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarDireccion(String direccion) {
        try {
            direccionJpaController.destroy(direccion);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarDireccion(Direccion direccion) {
        try {
            direccionJpaController.edit(direccion);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // EMPLEADO
    public void crearEmpleado(Empleado empleado) {
        try {
            empleadoJpaController.create(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEmpleado(String empleado) {
        try {
            empleadoJpaController.findEmpleado(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEmpleado(String empleado) {
        try {
            empleadoJpaController.destroy(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarEmpleado(Empleado empleado) {
        try {
            empleadoJpaController.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ENTREGA
    public void crearEntrega(Entrega entrega) {
        try {
            entregaJpaController.create(entrega);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarEntrega(String entrega) {
        try {
            entregaJpaController.findEntrega(entrega);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEntrega(String entrega) {
        try {
            entregaJpaController.destroy(entrega);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarEntrega(Entrega entrega) {
        try {
            entregaJpaController.edit(entrega);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ESTADO
    public void crearEstado(Estado estado) {
        try {
            estadoJpaController.create(estado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Estado buscarEstado(int estado) {
        try {
            return estadoJpaController.findEstado(estado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void borrarEstado(int estado) {
        try {
            estadoJpaController.destroy(estado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarEstado(Estado estado) {
        try {
            estadoJpaController.edit(estado);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ESTADO
    public void crearPaquete(Paquete paquete) {
        try {
            paqueteJpaController.create(paquete);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarPaquete(int paquete) {
        try {
            paqueteJpaController.findPaquete(paquete);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarPaquete(int paquete) {
        try {
            paqueteJpaController.destroy(paquete);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarPaquete(Paquete paquete) {
        try {
            paqueteJpaController.edit(paquete);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // PERSONA
    public void crearPersona(Persona persona) {
        try {
            personaJpaController.create(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Persona buscarPersona(String persona) {
        try {
            return personaJpaController.findPersona(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void borrarPersona(String persona) {
        try {
            personaJpaController.destroy(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarPersona(Persona persona) {
        try {
            personaJpaController.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // REPARTIDOR
    public void crearRepartidor(Repartidor persona) {
        try {
            repartidorJpaController.create(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarRepartidor(String persona) {
        try {
            repartidorJpaController.findRepartidor(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarRepartidor(String persona) {
        try {
            repartidorJpaController.destroy(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarRepartidor(Repartidor persona) {
        try {
            repartidorJpaController.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
