/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Entidades.Cliente;
import Entidades.DireccEntrega;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author andreflores
 */
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

    public static Boolean comprobarCedula(String cedula) {
        return cedula.length() == 10 && cedula.substring(0, 9).matches("[0-9]*");
    }

    public static Boolean comprobarCorreo(String correo) {
        String regex = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
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
