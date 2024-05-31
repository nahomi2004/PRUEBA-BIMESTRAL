package org.example.persistencia;

import java.util.Collection;

public class EsposasEntity {
    private int idEsp;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Collection<ClientesEntity> clientesByIdEsp;

    public int getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(int idEsp) {
        this.idEsp = idEsp;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EsposasEntity that = (EsposasEntity) o;

        if (idEsp != that.idEsp) return false;
        if (cedula != null ? !cedula.equals(that.cedula) : that.cedula != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEsp;
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        return result;
    }

    public Collection<ClientesEntity> getClientesByIdEsp() {
        return clientesByIdEsp;
    }

    public void setClientesByIdEsp(Collection<ClientesEntity> clientesByIdEsp) {
        this.clientesByIdEsp = clientesByIdEsp;
    }
}
