import java.util.Scanner;

public class MatricesHilos2 extends Thread {
    int[] row;
    int[] totalSum;
    public MatricesHilos2(int[] row, int[] totalSum) {
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
        MatricesHilos2[] threads;

        System.out.println("Ingrese la dimension de las matrices a sumar:");
        System.out.println("Filas");
        int n = entrada.nextInt();

        System.out.println("Columnas");
        int n2 = entrada.nextInt();

        int[][] m1;
        m1 = llenarMatrices(n, n2);

        int[] totalSum = {0};

        if(n > n2) {
            threads = new MatricesHilos2[m1[0].length];

            for (int i = 0; i < m1[0].length; i++) {
                threads[i] = new MatricesHilos2(m1[i], totalSum);
                threads[i].start();
            }
        } else {
            threads = new MatricesHilos2[m1.length];

            for (int i = 0; i < m1.length; i++) {
                threads[i] = new MatricesHilos2(m1[i], totalSum);
                threads[i].start();
            }
        }

        for (MatricesHilos2 thread : threads) {
            try {
                thread.join(); // evitar que el hilo actual sea interrumpido por otros
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        presentar(m1);
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
