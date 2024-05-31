package Logica;

import Entidades.DireccEntrega;

public class LDirecc {
    private DireccEntrega pDirecc;

    public LDirecc(DireccEntrega pDirecc) {
        this.pDirecc = pDirecc;
    }

    public Boolean comprobarCalles (){
        String principal = pDirecc.getCalle1().replaceAll("\\D", "").toLowerCase();
        String sec1 = pDirecc.getCalle2().replaceAll("\\D", "").toLowerCase();

        return principal.equals(sec1);
    }
}
