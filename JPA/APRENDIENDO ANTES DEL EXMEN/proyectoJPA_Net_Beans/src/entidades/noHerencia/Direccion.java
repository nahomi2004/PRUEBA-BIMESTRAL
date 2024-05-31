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
public class Direccion implements Serializable {
    @Id
    private String codigo;

    @Basic
    private String calle1;
    private String calle2;
    private String referencia;
    private int actual;
    
    @ManyToOne
    @JoinColumn(name = "cliente_cedula")
    private Cliente cliente;

    public Direccion() {
    }

    public Direccion(String codigo, String calle1, String calle2, String referencia, int actual) {
        this.codigo = codigo;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.referencia = referencia;
        this.actual = actual;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Direccion" +
                "\n\tCodigo='" + codigo +
                "\n\tCalle1='" + calle1 +
                "\n\tCalle2='" + calle2 +
                "\n\tReferencia='" + referencia +
                "\n\tActual=" + actual;
    }
}
