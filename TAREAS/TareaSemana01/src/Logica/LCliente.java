package Logica;

import Entidades.Cliente;
import Entidades.DireccEntrega;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LCliente {
    private Cliente logicaC;
    public LCliente(Cliente logicaC) {
        this.logicaC = logicaC;
    }

    public Cliente getLogicaC() {
        return logicaC;
    }

    public void setLogicaC(Cliente logicaC) {
        this.logicaC = logicaC;
    }

    public Boolean comprobarCedula() {
        if (logicaC.getCedula().length() == 10 && logicaC.getCedula().substring(0, 9).matches("[0-9]*")) {
            return true;
        }

        return false;
    }

    public Boolean comprobarCorreo() {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(logicaC.getCorreo());
        return matcher.matches();
    }

    public Boolean comprobarDirecciones() {
        for (int i = 0; i < logicaC.getDireccEntrega().size(); i++) {
            for (int j = i + 1; j < logicaC.getDireccEntrega().size(); i++) {
                return (logicaC.getDireccEntrega().get(i).equals(logicaC.getDireccEntrega().get(j)));
            }
        }
        return false;
    }

    public DireccEntrega direccionActual() {
        return logicaC.getDireccEntrega().get(logicaC.getDireccEntrega().size() - 1);
    }
}
