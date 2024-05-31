/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.noHerencia;

import entidades.herencia.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */
@Entity
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tipo;

    @Basic
    private String estado;
    private String observacion;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "paquete_idPaquete")
    private Paquete paquete;

    public Estado() {
    }

    public Estado(int tipo, String estado, Date fecha, String observacion) {
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "Estado" +
                "\n\tTipo: " + tipo +
                "\n\tEstado " + estado +
                "\n\tFecha: " + fecha +
                "\n\tObservacion: " + observacion;
    }
}
