/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.noHerencia;

import entidades.herencia.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */
@Entity
public class Entrega implements Serializable {
    @Id
    private String codigo;

    @Basic
    private String obs;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    
    @OneToMany(mappedBy = "entrega")
    private List<Paquete> paquetes;
    
    @ManyToOne
    @JoinColumn(name = "repartidor_cedula")
    private Repartidor repartidor;
    
    public Entrega() {
    }

    public Entrega(String codigo, Date fecha, String obs) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.obs = obs;
        this.paquetes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquete) {
        this.paquetes = paquete;
    }
    
    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    @Override
    public String toString() {
        return "Entrega" +
                "\n\tCodigo: " + codigo +
                "\n\tFecha: " + fecha +
                "\n\tObservación: " + obs;
    }
}
