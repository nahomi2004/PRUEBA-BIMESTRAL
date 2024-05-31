package PEntidades;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private Direcc direc;
    private ArrayList<Hijo> hijos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String cedula, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula.replaceAll("\\D", "");
        this.correo = correo;
    }
    public Cliente(String nombre, String apellido, String cedula, Direcc direc, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula.replaceAll("\\D", "");
        this.direc = direc;
        this.correo = correo;
    }
    public Cliente(String nombre, String apellido, String cedula, Direcc direc, String correo,
    ArrayList<Hijo> hijos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula.replaceAll("\\D", "");
        this.direc = direc;
        this.correo = correo;
        this.hijos = hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public Direcc getDirec() {
        return direc;
    }

    public ArrayList<Hijo> getHijos() {
        return hijos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDirec(Direcc direc) {
        this.direc = direc;
    }

    public void setHijos(ArrayList<Hijo> hijos) {
        this.hijos = hijos;
    }

    public boolean isEmptyuwu() {
        return nombre == null && apellido == null;
    }
}
