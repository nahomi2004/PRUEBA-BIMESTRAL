package org.example.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Estudiante {
    @Id
    private long idEstudiante;
    private String cedula;
    private String nombres;
    private String apellidos;

    public Estudiante() {
    }

    public long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(long id) {
        this.idEstudiante = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String name) {
        this.nombres = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellido) {
        this.apellidos = apellido;
    }

    @Override
    public String toString() {
        return "Estudiante" +
                "\n\tid: " + idEstudiante +
                "\n\tCDL.: " + cedula +
                "\n\tNombres: " + nombres +
                "\n\tApellidos: " + apellidos;
    }
}
