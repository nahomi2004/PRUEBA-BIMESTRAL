package org.example.persistencia;

public class ClientesEntity {
    private int idCliente;
    private String cedula;
    private String nombres;
    private String apellidos;
    private int esposasIdEsp;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public int getEsposasIdEsp() {
        return esposasIdEsp;
    }

    public void setEsposasIdEsp(int esposasIdEsp) {
        this.esposasIdEsp = esposasIdEsp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idCliente != that.idCliente) return false;
        if (esposasIdEsp != that.esposasIdEsp) return false;
        if (cedula != null ? !cedula.equals(that.cedula) : that.cedula != null) return false;
        if (nombres != null ? !nombres.equals(that.nombres) : that.nombres != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente;
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + esposasIdEsp;
        return result;
    }
}
