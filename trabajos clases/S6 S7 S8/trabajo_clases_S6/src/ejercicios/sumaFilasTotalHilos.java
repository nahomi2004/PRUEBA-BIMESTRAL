package ejercicios;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class sumaFilasTotalHilos implements Runnable {
    private int [] row;
    private static int sumaTotal = 0;

    public sumaFilasTotalHilos(int[] row) {
        this.row = row;
    }

    public int[] getRow() {
        return row;
    }

    public static int getSumaTotal() {
        return sumaTotal;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int num: row) {
            sum += num;
        }

        System.out.printf("%s trabajando. Total: %d\n", Thread.currentThread().getName(), sum);
        sumaTotal += sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de filas");
        int f = sc.nextInt();
        System.out.println("Ingrese el número de columnas");
        int c = sc.nextInt();

        int [][] matriz = sumaFilasTotal.llenarMatriz(f,c);

        for(int[] xd: matriz) {
            Thread t = new Thread(new sumaFilasTotalHilos(xd));
            t.start();
        }

        try {
            sleep(15 * f);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Suma total: " + getSumaTotal());
        presentarMatriz(matriz);
    }

    public static void presentarMatriz(int [][] matriz) {
        System.out.println(">>> PRESENTAR MATRIZ <<<");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
