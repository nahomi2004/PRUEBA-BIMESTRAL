/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andreflores
 */
public class DireccEntrega {
    private int idCDir;
    private String calle1;
    private String calle2;
    private String referencia;

    /*
    Valide que las direcciones no sean las mismas
    Puede tener varias direcciones, la última ingresada se considera la dirección actual
    */

    public DireccEntrega() {
    }

    public DireccEntrega(int idCDir, String calle1, String calle2, String referencia) {
        this.idCDir = idCDir;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.referencia = referencia;
    }

    public int getIdCDir() {
        return idCDir;
    }

    public void setIdCDir(int idCDir) {
        this.idCDir = idCDir;
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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean isEmptyDirecc() {
        return calle1 == null;
    }

    @Override
    public String toString() {
        return "\nDireccion de Entrega" + "\nidCDir: " + idCDir + "\nCalle Principal: "
                + calle1 + "\nCalle Secundaria: " + calle2 + "\nReferencia: "
                + referencia;
    }
    
}

