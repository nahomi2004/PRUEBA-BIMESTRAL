
package entidades.herencia;

import entidades.noHerencia.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */
@Entity
public class Cliente extends Persona implements Serializable {
    @Basic
    private String celular;

    @OneToMany(mappedBy = "cliente")
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "cliente")
    private List<Paquete> paquetes;
    
    public Cliente() {
    }

    public Cliente(String cedula, String nombre, String apellido, String mail, String celular) {
        super(cedula, nombre, apellido, mail);
        this.celular = celular;
        direcciones = new ArrayList<>();
        paquetes = new ArrayList<>();
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nDatos del Cliente\n"
                + "\tCelular: " + celular;
    }
}
