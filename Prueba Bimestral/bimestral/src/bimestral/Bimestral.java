
package bimestral;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Bimestral {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bimestral_PU");
        EntityManager em = emf.createEntityManager();
        
        List<valores> numeros = em.createQuery("SELECT v FROM valores v", valores.class).getResultList();
        // obtengo por FILAS todos los datos de la BD
        hacertodo(numeros);
        em.close();
        emf.close();
    }
    // medio punto este bimestre uwu
    public static void hacertodo(List<valores> numeros) {
        System.out.println(numeros.size());
        
        // var numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        CountDownLatch endController = new CountDownLatch(4);
        
        List<Integer> col1List = new ArrayList<>();
        List<Integer> col2List = new ArrayList<>();
        List<Integer> col3List = new ArrayList<>();
        List<Integer> col4List = new ArrayList<>();
        // List<Integer> id = new ArrayList<>();
        
        for (valores valor : numeros) {
            col1List.add(valor.getCol1()); // 0, 1, 2, 3, 4
            col2List.add(valor.getCol2()); // 0, 1, 2, 3, 4
            col3List.add(valor.getCol3()); // 0, 1, 2, 3, 4
            col4List.add(valor.getCol4()); // 0, 1, 2, 3, 4
            // id.add(valor.getId()); // solo estaba probando si solo tomaba las col
        }
        
        Hilo h1 = new Hilo(col1List, endController);
        Hilo h2 = new Hilo(col2List, endController);
        Hilo h3 = new Hilo(col3List, endController);
        Hilo h4 = new Hilo(col4List, endController);
        // Hilo h5 = new Hilo(id, endController);
        
        executor.execute(h1);
        executor.execute(h2);
        executor.execute(h3);
        executor.execute(h4);
        // executor.execute(h5);
        
        try {
            endController.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        executor.shutdown();
        System.out.println("\n\n\n");
        
        System.out.println("Total de números primos: " + h1.getContNumPrimos());
    }
}
