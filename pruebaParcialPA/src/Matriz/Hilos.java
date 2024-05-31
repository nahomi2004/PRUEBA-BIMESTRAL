package Matriz;// @Author: CABRERA PICOITA NAHOMI ASTRID

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Hilos extends Thread {
    private static int[][] matriz;
    private static Scanner sc = new Scanner(System.in);
    private static ReentrantLock lock = new ReentrantLock();

    private static int ixFila = 0;
    private static int ixColum = 0;

    private int row;
    private int f;
    private int c;
    private int n;

    public Hilos(int row, int f, int c, int n) {
        this.row = row;
        this.f = f;
        this.c = c;
        this.n = n;
        if (matriz == null) {
            matriz = new int[f][c];
        }
    }

    /*
        @Override
        public void run() {
            for (int i = 0; i < c; i++) {
                lock.lock(); // esto es para evitar la desincronización o inconsistencia de datos
                try {
                    System.out.println(getName() + " Agregado: " + n);
                    matriz[row][i] = n;
                } finally {
                    lock.unlock();
                }
            }
        }
        ESTE RUN DE AQUÍ EVITA QUE LAS CARRERAS ENTRE HILOS PASEN Y ASÍ EVITA QUE LOS DATOS SE SOBREPONGAN UNO
        SOBRE OTRO
     */
    @Override
    public void run() {
        for (int i = 0; i < c; i++) {
            System.out.println(getName() + " Agregado: " + n);
            matriz[ixFila][ixColum] = n;

            ixFila++;
            ixColum++;

            if (ixFila == f) {
                ixFila = 0;
            }
            if (ixColum == c) {
                ixColum = 0;
            }
        }
    }

    public static int[][] getMatriz() {
        return matriz;
    }

    public static void main(String[] args) {

        System.out.println("Ingrese las filas:");
        int f = sc.nextInt();
        System.out.println("Ingrese las columnas (número par):");
        int c = sc.nextInt();

        if (c % 2 != 0) {
            System.out.println("Las columnas deben ser un número par");
            System.out.println("Adiós :D");
        } else {
            Thread[] threads = new Thread[f];
            int numeros = 1;

            for (int i = 0; i < threads.length; i++) { // se le envía la row por el run en el comentario
                threads[i] = new Hilos(i, f, c, numeros); // se inicializan los hilos dentro del array y se corren
                threads[i].start();
                numeros++;
            }

            for (Thread xd : threads) { // se espera a que todos los hilos acaben
                try {
                    xd.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < f; i++) { // se imprime
                for (int j = 0; j < c; j++) {
                    System.out.print(getMatriz()[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

/*
BORRADOR
        Hilos h1 = new Hilos(3, 4, 1);
        Hilos h2 = new Hilos(3, 4, 2);
        Hilos h3 = new Hilos(3, 4, 3);
        // Hilos h4 = new Hilos(3,4,1);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
* */
