/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

/**
 *
 * @author andreflores
 */
public class Estado {
    private int idEstado;
    private String estado;
    private LocalDate fecha;

    public Estado() {
    }

    public Estado(int idEstado, String estado, LocalDate fecha) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Estado: " + estado + ", fecha: " + fecha;
    }
}
