
/*2. Llenar una matriz de dimensión (n x m (par)) con valores de 
1 a n de forma aleatoria en la proporcion de veces cada numero 
(si la matriz es 3x4 se debe llenar con 1,2,3 4 veces cada 
numero de forma aleatoria)*/

package Ejercicios2;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/*public class hilos extends Thread {
    static int n; // Filas de la matriz
    static int m; // Columnas de la matriz
    static int[][] matrix; // Matriz a llenar
    static int[] counts; // Contador para cada número
    static int reps; // Número de repeticiones para cada número
    static int filledCount = 0; // Contador para las celdas llenadas
    int number; // Número que este hilo va a insertar

    public hilos(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (counts[number - 1] < reps) {
            int i = rand.nextInt(n);
            int j = rand.nextInt(m);

            synchronized (matrix) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = number;
                    counts[number - 1]++;
                    filledCount++;
                    System.out.println(this.getName()+ " insertó " + number + " en posición [" + i + "][" + j + "]");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        n = 3;
        m = 4;
        
        if (m % 2 != 0) {
            System.out.println("El número de columnas (m) debe ser par.");
            return;
        }

        matrix = new int[n][m];
        counts = new int[n];
        reps = (n * m) / n; // Número de repeticiones para cada número

        // Crear y arrancar los hilos
        Thread[] threads = new Thread[n];
        for (int i = 0; i < n; i++) {
            threads[i] = new hilos(i + 1);
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < n; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir la matriz final
        System.out.println("\nMatriz final:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}*/