/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral_curso_2;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
/**
 *
 * @author D E L L
 */
public class Hilo2 extends Thread {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static int contNumPrimos;
    private static Random r;
    private ArrayList<valores2> valores;
    private int numRep;
    private CountDownLatch endController;
    
    public Hilo2(int numRep, CountDownLatch endController) {
        emf = Persistence.createEntityManagerFactory("Bimestral_Curso_2_PU");
        em = emf.createEntityManager();
        this.numRep = numRep;
        this.endController = endController;
        valores = new ArrayList<>();
    }
    
    public int getContNumPrimos() {
        return contNumPrimos;
    }

    public void setContNumPrimos(int contNumPrimos) {
        this.contNumPrimos = contNumPrimos;
    }

    public ArrayList<valores2> getValores() {
        return valores;
    }

    public void setValores(ArrayList<valores2> valores) {
        this.valores = valores;
    }
    
    @Override
    public void run() {
        // 4 numeros 
        for (int i=0; i < numRep; i++) {
            int n1 = r.nextInt(20) + 1;
            int n2 = r.nextInt(20) + 1;
            int n3 = r.nextInt(20) + 1;
            int n4 = r.nextInt(20) + 1;
            
            int []  nA = {n1, n2, n3, n4};
            
            for (int n: nA) {
                if (esPrimo(n)) {
                    contNumPrimos++;
                    System.out.println("Este si es un primo. Contado por: " + Thread.currentThread().getName());
                }
            }
            
            int nHilo = Integer.parseInt(getName().split(" ")[1]);
            valores2 v2 = new valores2(nHilo, n1, n2, n3, n4);
            valores.add(v2);
        }
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
