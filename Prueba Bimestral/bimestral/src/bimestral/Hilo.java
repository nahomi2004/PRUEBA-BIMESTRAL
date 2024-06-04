/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author D E L L
 */
public class Hilo implements Runnable {
    private static int contNumPrimos;

    List<Integer> numeros;
    
    private CountDownLatch endController;
    
    public Hilo(List<Integer> numeros, CountDownLatch endController) {
        this.contNumPrimos = 0;
        this.numeros = numeros;
        this.endController = endController;
    }

    public int getContNumPrimos() {
        return contNumPrimos;
    }

    public void setContNumPrimos(int contNumPrimos) {
        this.contNumPrimos = contNumPrimos;
    }

    @Override
    public void run() {
        System.out.println("Hola soy el hilo " + Thread.currentThread().getName());
        
        for (int i = 0; i < numeros.size(); i++) {
            if (esPrimo(numeros.get(i))) {
                contNumPrimos++;
                System.out.println("Este si es un primo. Contado por: " + Thread.currentThread().getName());
            }
        }
        
        endController.countDown();
    }
    
    public boolean esPrimo(int n) {
        if(n > 1) { // no toma en cuenta los numeros del 1 para abajo
            if (n == 2) {
                return true; // el dos siempre es primo
            }
            for (int i = 2; i < n / 2; i++) { // se queda hasta la mitad porque desde ahi ya no hay más divisores
                if (n%i == 0) {
                    return false;  // si encuenta un divisor entonces no es primo
                }
            }
            return true;
        }
        return false; // es 0 o 1 o un número menor tampoco es primo
    }
}
