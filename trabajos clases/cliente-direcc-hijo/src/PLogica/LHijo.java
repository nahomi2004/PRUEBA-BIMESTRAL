package PLogica;

import PEntidades.Hijo;

import java.util.ArrayList;

public class LHijo {
    private Hijo hijos;

    public LHijo(Hijo hijos) {
        this.hijos = hijos;
    }

    public Boolean comprobarEdad() {
        return hijos.getEdad() >= 0;
    }
}
