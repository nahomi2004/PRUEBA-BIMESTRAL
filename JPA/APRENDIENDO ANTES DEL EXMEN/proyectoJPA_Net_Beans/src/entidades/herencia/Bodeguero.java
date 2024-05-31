/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Bodeguero extends Empleado implements Serializable {
    @Basic
    private String local;
    
    @OneToMany(mappedBy = "bodeguero")
    private List<Paquete> paquetes;

    public Bodeguero() {
    }

    public Bodeguero(String cedula, String nombre, String apellido, String mail, String ciudad, String local) {
        super(cedula, nombre, apellido, mail, ciudad);
        this.local = local;
        this.paquetes = new ArrayList<>();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return super.toString() + "\n\tTipo: Bodeguero" +
                "\n\tLocal: " + local;
    }
}
