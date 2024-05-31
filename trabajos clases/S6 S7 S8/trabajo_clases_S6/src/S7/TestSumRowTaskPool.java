package S7;

import java.util.List;
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

        int s = Integer.valueOf("2");
        System.out.println(s);
        /*
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
        ejercicios.sumaFilasTotalHilos2.presentarMatriz(mat);*/
    }

    public static void hacertodo(List<String> numeros) {
        System.out.println(numeros.size());

        // var numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        int [] v1 = new int[400];
        int [] v2 = new int[400];
        int [] v3 = new int[400];
        int [] v4 = new int[400];
        int [] v5 = new int[400];
        int j = 0;

        for (int i = 0; i < numeros.size(); i++) {
            if (i < 400) {
                v1[j] = Integer.valueOf(numeros.get(i));
                j++;
                //Thread t = new Thread(new Hilo());
            } else if (i >= 400 && i < 800) {
                v2[i-400] = Integer.valueOf(numeros.get(i));
            } else if (i >= 800 && i < 1200) {
                v3[i-800] = Integer.valueOf(numeros.get(i));
            } else if (i >= 1200 && i < 1600) {
                v3[i-1200] = Integer.valueOf(numeros.get(i));
            } else if (i >= 1600 && i < 2000) {
                v3[i-1600] = Integer.valueOf(numeros.get(i));
            }
        }
    }
}
