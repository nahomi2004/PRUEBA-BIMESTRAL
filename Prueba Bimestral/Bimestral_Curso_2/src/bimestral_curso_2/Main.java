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
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bimestral_Curso_2_PU");
        // EntityManager em = emf.createEntityManager();
        
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        CountDownLatch endController = new CountDownLatch(4);
        
        Hilo2 hilo = new Hilo2();
        
        for(int i = 0; i < 4; i++) {
            hilo = new Hilo2(500, endController);
            executor.execute(hilo);
        }
        
        try {
            endController.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        executor.shutdown();
        
        System.out.println(hilo.getContNumPrimos());
    }
}
