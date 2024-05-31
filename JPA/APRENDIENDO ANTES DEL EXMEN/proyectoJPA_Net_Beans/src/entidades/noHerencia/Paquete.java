/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades.noHerencia;

import entidades.herencia.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author D E L L
 */
@Entity
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idPaquete;

    @Basic
    private String codigo;
    private String descrip;
    private double peso;
    private double alto;

    @ManyToOne
    @JoinColumn(name = "cliente_cedula")
    private Cliente cliente;

    @OneToMany(mappedBy = "paquete")
    private List<Estado> estados;  // Cambiado a List

    @ManyToOne
    @JoinColumn(name = "entrega_codigo")
    private Entrega entrega;

    @ManyToOne
    @JoinColumn(name = "bodeguero_cedula")
    private Bodeguero bodeguero;
    
    public Paquete() {
    }

    public Paquete(int idPaquete, String codigo, String descrip, double peso, double alto) {
        this.idPaquete = idPaquete;
        this.codigo = codigo;
        this.descrip = descrip;
        this.peso = peso;
        this.alto = alto;
        this.estados = new ArrayList<>();
        // estados[0] = new Estado(1, "Creado", LocalDate.now(), "Creado con éxito");
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(Bodeguero bodeguero) {
        this.bodeguero = bodeguero;
    }

    @Override
    public String toString() {
        String cadena = String.format("Paquete" +
                "\n\tID: " + idPaquete +
                "\n\tCodigo: " + codigo +
                "\n\tDescripción: " + descrip +
                "\n\tPeso: " + peso +
                "\n\tAlto: " + alto +
                "\n\tEstados: ");

        for(Estado e: estados) {
            cadena = cadena + e.toString() + "\n";
        }

        return cadena;
    }
}
