import java.util.Scanner;

public class MatricesHilos extends Thread {
    int[] row;
    int[] totalSum;
    public MatricesHilos(int[] row, int[] totalSum) {
        this.row = row;
        this.totalSum = totalSum;
    }

    @Override
    public void run() {
        int sum = 0;
        System.out.println(row);
        for (int num : row) {
            sum += num; // suma de los elementos de la fila
        }
        synchronized (totalSum) { // secciones de código que deben ser ejecutadas por un solo hilo a la vez. Evita inconsistencias
            totalSum[0] += sum;
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la dimension de las matrices a sumar:");
        System.out.println("Filas");
        int n = entrada.nextInt();

        System.out.println("Columnas");
        int n2 = entrada.nextInt();

        int[][] m1;
        m1 = llenarMatrices(n, n2);

        int[] totalSum = {0};

        MatricesHilos[] threads = new MatricesHilos[m1.length];

        // Crear hilos para sumar cada fila de la matriz
        for (int i = 0; i < m1.length; i++) {
            threads[i] = new MatricesHilos(m1[i], totalSum);
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen su ejecución
        for (MatricesHilos thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        presentar(m1);
        // Imprimir la suma total
        System.out.println("Suma total de la matriz: " + totalSum[0]);
    }

    public static int[][] llenarMatrices(int x, int y) {
        int[][] m = new int[x][y];

        for (int i=0; i < m.length; i++) {
            for (int j=0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random()*9+1);
            }
        }

        return m;
    }

    public static void presentar(int[][] x){
        System.out.println();
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                System.out.print(x[i][j] + " - ");
            }
            System.out.println();
        }
    }
}
