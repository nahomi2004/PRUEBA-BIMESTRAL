package org.example.persistencia;

public class DireccionesEntity {
    private int idDir;
    private String calle1;
    private String calle2;
    private Integer idCli;
    private ClientesEntity clientesByIdCli;

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
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

    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        this.idCli = idCli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DireccionesEntity that = (DireccionesEntity) o;

        if (idDir != that.idDir) return false;
        if (calle1 != null ? !calle1.equals(that.calle1) : that.calle1 != null) return false;
        if (calle2 != null ? !calle2.equals(that.calle2) : that.calle2 != null) return false;
        if (idCli != null ? !idCli.equals(that.idCli) : that.idCli != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDir;
        result = 31 * result + (calle1 != null ? calle1.hashCode() : 0);
        result = 31 * result + (calle2 != null ? calle2.hashCode() : 0);
        result = 31 * result + (idCli != null ? idCli.hashCode() : 0);
        return result;
    }

    public ClientesEntity getClientesByIdCli() {
        return clientesByIdCli;
    }

    public void setClientesByIdCli(ClientesEntity clientesByIdCli) {
        this.clientesByIdCli = clientesByIdCli;
    }
}
