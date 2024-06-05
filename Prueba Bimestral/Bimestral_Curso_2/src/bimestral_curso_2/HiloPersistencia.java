/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral_curso_2;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author D E L L
 */
public class HiloPersistencia extends Thread {
    private static EntityManagerFactory emf;
    // private static EntityManager em;
    private int numDatosGenerar;
    private CountDownLatch endController;
    private Hilo2 h;

    public HiloPersistencia(int numDatosGenerar, CountDownLatch endController, EntityManagerFactory emf) {
        this.numDatosGenerar = numDatosGenerar;
        this.emf = emf;
        // em = emf.createEntityManager();
        this.endController = endController;
    }

    public Hilo2 getH() {
        return h;
    }

    public void setH(Hilo2 h) {
        this.h = h;
    }
    
    @Override
    public void run() {
        valores2JpaController v = new valores2JpaController(emf);
        h = new Hilo2(numDatosGenerar, endController);
        
        ArrayList<valores2> valores = h.getValores();
        
        for (int i=0; i < valores.size(); i++) {
            v.create(valores.get(i));
        }
        
    }
}
