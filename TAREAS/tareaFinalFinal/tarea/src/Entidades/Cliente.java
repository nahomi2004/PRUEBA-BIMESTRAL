/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Logica.LCliente;

import java.util.ArrayList;

/**
 *
 * @author andreflores
 */
public class Cliente {

    private int idCliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private ArrayList<DireccEntrega> direccEntrega = new ArrayList<>();
    private Paquete paquete;
    // Valide sus atributos: número de cedula correcta y email valido

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String cedula, String correo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
    }

    public Cliente(int idCliente, String nombre, String apellido, String cedula, String correo, ArrayList<DireccEntrega> direccEntrega) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.direccEntrega = direccEntrega;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<DireccEntrega> getDireccEntrega() {
        return direccEntrega;
    }

    public void setDireccEntrega(ArrayList<DireccEntrega> direccEntrega) {
        this.direccEntrega = direccEntrega;
    }

    public boolean isEmptyUwU() {
        return nombre == null;
    }

    @Override
    public String toString() {
        String fila = "Cliente\nNombre: " + nombre + "\nApellido: " + apellido
                + "\nCedula: " + cedula + "\nCorreo: " + correo
                + "\nDireccion/es:\n";

        int i;
        for(i=0; i<direccEntrega.size()-1; i++) {
            fila = fila + "\nDirección " + (i + 1) + ": \n\t" + direccEntrega.get(i);
        }

        return fila + "\nDirección actual: " + direccEntrega.get(i)
                + "\n\nPaquete:" + paquete;
    }

}
