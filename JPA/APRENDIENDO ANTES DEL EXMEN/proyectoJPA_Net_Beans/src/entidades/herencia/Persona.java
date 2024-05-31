
package entidades.herencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona implements Serializable {
    @Id
    private String cedula;

    @Basic
    private String apellido;
    private String nombre;
    private String mail;

    public Persona() {
    }

    public Persona(String cedula, String apellido, String nombre, String mail) {
        this.cedula = cedula;
        this.apellido = apellido;
        this.nombre = nombre;
        this.mail = mail;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
