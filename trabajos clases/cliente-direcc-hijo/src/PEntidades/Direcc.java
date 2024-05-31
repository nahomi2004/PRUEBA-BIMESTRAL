package PEntidades;

public class Direcc {
    private String cllPrincipal;
    private String cllSec1;
    private String cllSec2;
    private String referencia;

    public Direcc(String cllPrincipal, String cllSec1, String cllSec2, String referencia) {
        this.cllPrincipal = cllPrincipal;
        this.cllSec1 = cllSec1;
        this.cllSec2 = cllSec2;
        this.referencia = referencia;
    }

    public String getCllPrincipal() {
        return cllPrincipal;
    }

    public String getCllSec1() {
        return cllSec1;
    }

    public String getCllSec2() {
        return cllSec2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setCllPrincipal(String cllPrincipal) {
        this.cllPrincipal = cllPrincipal;
    }

    public void setCllSec1(String cllSec1) {
        this.cllSec1 = cllSec1;
    }

    public void setCllSec2(String cllSec2) {
        this.cllSec2 = cllSec2;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
}
