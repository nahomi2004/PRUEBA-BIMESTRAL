package Entidades;

public class Direccion {
    private int idDir;
    private String calle1;
    private String calle2;

    public Direccion() {
    }

    public Direccion(int idDir, String calle1, String calle2) {
        this.idDir = idDir;
        this.calle1 = calle1;
        this.calle2 = calle2;
    }

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

    @Override
    public String toString() {
        return "\tDatos de la direccion" +
                "\n\t\tid Direccion: " + idDir +
                "\n\t\tCalle 1: " + calle1 +
                "\n\t\tCalle 2: " + calle2;
    }
}
