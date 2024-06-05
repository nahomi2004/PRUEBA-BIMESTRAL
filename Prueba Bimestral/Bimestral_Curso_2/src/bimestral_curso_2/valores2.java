/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral_curso_2;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author D E L L
 */
@Entity
public class valores2 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private int nHilo;
    private int col1;
    private int col2;
    private int col3;
    private int col4;
    
    // Constructor por defecto
    public valores2() {
    }

    public valores2(int nHilo, int col1, int col2, int col3, int col4) {
        this.id = 0;
        this.nHilo = nHilo;
        this.col1 = col1;
        this.col2 = col2;
        this.col3 = col3;
        this.col4 = col4;
    }

    
    public int getnHilo() {
        return nHilo;
    }

    public void setnHilo(int nHilo) {
        this.nHilo = nHilo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCol1() {
        return col1;
    }

    public void setCol1(int col1) {
        this.col1 = col1;
    }

    public int getCol2() {
        return col2;
    }

    public void setCol2(int col2) {
        this.col2 = col2;
    }

    public int getCol3() {
        return col3;
    }

    public void setCol3(int col3) {
        this.col3 = col3;
    }

    public int getCol4() {
        return col4;
    }

    public void setCol4(int col4) {
        this.col4 = col4;
    }
}
