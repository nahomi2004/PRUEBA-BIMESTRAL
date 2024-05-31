package org.example.persistencia;

public class EsposasEntity {
    private int idEsp;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Integer idCliente;
    private ClientesEntity clientesByIdCliente;

    public EsposasEntity(int idEsp, String cedula, String nombres, String apellidos, ClientesEntity clientesByIdCliente) {
        this.idEsp = idEsp;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idCliente = clientesByIdCliente.getIdCliente();
        this.clientesByIdCliente = clientesByIdCliente;
    }

    public EsposasEntity() {
    }
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

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEsp;
        result = 31 * result + (cedula != null ? cedula.hashCode() : 0);
        result = 31 * result + (nombres != null ? nombres.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        return result;
    }

    public ClientesEntity getClientesByIdCliente() {
        return clientesByIdCliente;
    }

    public void setClientesByIdCliente(ClientesEntity clientesByIdCliente) {
        this.clientesByIdCliente = clientesByIdCliente;
    }

    @Override
    public String toString() {
        return "Datos Esposa\n" +
                "ID:" + idEsp +
                "\nCedula:" + cedula +
                "\nNombres:" + nombres +
                "\nApellidos:" + apellidos +
                "\nESPOSO\n" + clientesByIdCliente;
    }
}
