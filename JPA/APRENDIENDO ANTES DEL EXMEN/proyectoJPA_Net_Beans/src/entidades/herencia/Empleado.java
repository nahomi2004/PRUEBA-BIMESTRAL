/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.herencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Empleado extends Persona implements Serializable {
    @Basic
    private String ciudad;
    
    public Empleado() {
    }

    public Empleado(String cedula, String nombre, String apellido, String mail, String ciudad) {
        super(cedula, nombre, apellido, mail);
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDatos del Empleado\n" +
                "\tCiudad: " + ciudad;
    }
}
