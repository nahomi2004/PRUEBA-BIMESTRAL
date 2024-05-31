/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidades.DireccEntrega;

/**
 *
 * @author andreflores
 */
public class LDirecc {

    private DireccEntrega pDirecc;

    public LDirecc() {

    }
    public LDirecc(DireccEntrega pDirecc) {
        this.pDirecc = pDirecc;
    }

    public Boolean comprobarCalles (String c1, String c2){
        String principal = c1.replaceAll("\\s", "").toLowerCase();
        String sec1 = c2.replaceAll("\\s", "").toLowerCase();

        return principal.equals(sec1);
    }
}