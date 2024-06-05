/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bimestral_curso_2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author D E L L
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bimestral_Curso_2_PU");
        EntityManager em = emf.createEntityManager();
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        CountDownLatch endController = new CountDownLatch(4);
        
        // Hilo2 h = null;
                
        HiloPersistencia hilo = new HiloPersistencia(500, endController, emf);
        HiloPersistencia hilo2 = new HiloPersistencia(500, endController, emf);
        HiloPersistencia hilo3 = new HiloPersistencia(500, endController, emf);
        HiloPersistencia hilo4 = new HiloPersistencia(500, endController, emf);
        
        /*for(int i = 0; i < 20; i++) {
            h = new Hilo2(25, endController);
            executor.execute(h);
        }*/
        
        executor.execute(hilo);
        executor.execute(hilo2);
        executor.execute(hilo3);
        executor.execute(hilo4);
        
        try {
            endController.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        executor.shutdown();
        System.out.println("\n\n\n");
        
        System.out.println("Total de números primos: " + hilo.getH().getContNumPrimos());
        
        em.close();
        emf.close();
    }
}
