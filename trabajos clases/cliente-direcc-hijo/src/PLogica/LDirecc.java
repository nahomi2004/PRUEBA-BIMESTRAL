package PLogica;

import PEntidades.Direcc;

public class LDirecc {
    private Direcc pDirecc;

    public LDirecc(Direcc pDirecc) {
        this.pDirecc = pDirecc;
    }

    public Boolean comprobarCalles (){
        String principal = pDirecc.getCllPrincipal().replaceAll("\\D", "").toLowerCase();
        String sec1 = pDirecc.getCllSec1().replaceAll("\\D", "").toLowerCase();
        String sec2 = pDirecc.getCllSec2().replaceAll("\\D", "").toLowerCase();

        return principal.equals(sec1) || principal.equals(sec2) || sec1.equals(sec2);
    }
}
