package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Paquete {
    private int idPaquete;
    private String codigo;
    private String description;
    private double peso;
    private double largo;
    private double ancho;
    private Estado estado1;
    private Estado estado2;
    private Estado estado3;
    /*
    cuando se cree el paquete debe por defecto crearse los 3 estados (creado, despachado, entregado) y únicamente el primero se registrará
    Debe existir un cliente con su dirección.
    */
    public Paquete() {
    }

    public Paquete(int idPaquete, String codigo, String description, double peso, double largo, double ancho) {
        this.idPaquete = idPaquete;
        this.codigo = codigo;
        this.description = description;
        this.peso = peso;
        this.largo = largo;
        this.ancho = ancho;
        estado1 = new Estado(1, "Creado", LocalDate.now());
        estado2.setEstado("Despachado");
        estado3.setEstado("Entregado");
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public Estado getEstado1() {
        return estado1;
    }

    public void setEstado1(Estado estado1) {
        this.estado1 = estado1;
    }

    public Estado getEstado2() {
        return estado2;
    }

    public void setEstado2(Estado estado2) {
        this.estado2 = estado2;
    }

    public Estado getEstado3() {
        return estado3;
    }

    public void setEstado3(Estado estado3) {
        this.estado3 = estado3;
    }
}
