package Entidades;

public class Esposa {
    private int idEsp;
    private String Cedula;
    private String Nombres;
    private String Apellidos;

    public Esposa() {
    }

    public Esposa(int idEsp, String cedula, String nombres, String apellidos) {
        this.idEsp = idEsp;
        Cedula = cedula;
        Nombres = nombres;
        Apellidos = apellidos;
    }

    public int getIdEsp() {
        return idEsp;
    }

    public void setIdEsp(int idEsp) {
        this.idEsp = idEsp;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "\tDatos de la Esposa" +
                "\n\t\tidCliente: " + idEsp +
                "\n\t\tCedula: " + Cedula +
                "\n\t\tApellidos: " + Apellidos +
                "\n\t\tNombres: " + Nombres;
    }
}
