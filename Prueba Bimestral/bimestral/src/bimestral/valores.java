/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral;
import java.util.ArrayList;
import javax.persistence.*;
/**
 *
 * @author D E L L
 */
@Entity
@Table(name = "valores")
public class valores {
    @Id
    private int id;
    @Basic
    private int col1;
    private int col2;
    private int col3;
    private int col4;

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
