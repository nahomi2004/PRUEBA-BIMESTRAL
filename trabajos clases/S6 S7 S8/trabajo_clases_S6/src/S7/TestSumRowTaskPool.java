package S7;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestSumRowTaskPool {
    public static void main(String[] args) {
        var pos = 0;
        int a = 5;
        int[][] mat = ejercicios.sumaFilasTotal.llenarMatriz(12,12);
        int[] sums = new int[mat.length];

        System.out.println("Longitud: " + mat.length);

        var numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);

        CountDownLatch endController = new CountDownLatch(12);

        ejercicios.sumaFilasTotalHilos2.presentarMatriz(mat);

        System.out.println("\n>>> Creando y ejecutando hilos <<<");

        for(var row: mat) {
            Thread thread = new Thread(new SumRowTask(row, pos ++, sums, endController, a));
            executor.execute(thread);
            System.out.print(a + " - ");
        }
        System.out.println("\n");

        try {
            endController.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n>>> FIN <<<\n");
        executor.shutdown();

        var sumTotal = 0;
        ejercicios.sumaFilasTotalHilos2.printRow(sums);  // crear esta función
        System.out.println("\n\n\n");

        for(var sum: sums) {
            sumTotal += sum;
        }

        System.out.printf("Suma total: %d\n", sumTotal);
        ejercicios.sumaFilasTotalHilos2.printRow(sums);
        System.out.println();
        ejercicios.sumaFilasTotalHilos2.presentarMatriz(mat);
    }
}
