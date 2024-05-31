package Entidades;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cliente {
    private int idCliente;
    private String cdl;
    private String apellidos;
    private String nombres;
    private Esposa esposa;
    private ArrayList<Direccion> direcciones = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int idCliente, String cdl, String apellidos, String nombres) {
        this.idCliente = idCliente;
        this.cdl = cdl;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCdl() {
        return cdl;
    }

    public void setCdl(String cdl) {
        this.cdl = cdl;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void insertarCliente(Cliente cliente) {

    }

    public boolean isEmpty() {
        return nombres == null;
    }

    @Override
    public String toString() {
        return "\tDatos del Cliente" +
                "\n\t\tidCliente: " + idCliente +
                "\n\t\tCdl: " + cdl +
                "\n\t\tApellidos: " + apellidos +
                "\n\t\tNombres: " + nombres +
                "\n\t\tESPOSA DEL CLIENTE: " + esposa +
                "\n\t\tDIRECCION DEL CLIENTE: " + direcciones;
    }
}
