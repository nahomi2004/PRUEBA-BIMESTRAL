package Matriz;// @Author: CABRERA PICOITA NAHOMI ASTRID

import java.util.Random;
import java.util.Scanner;

// Llenar una matriz de dimensión (n x m (par)) con valores de 1 a n de forma aleatoria en la proporcion de veces cada
// numero (si la matriz es 3x4 se debe llenar con 1,2,3 4 veces cada numero de forma aleatoria)
public class Secuencial {

    private static int[] comprueba;
    private static int[][] matriz;
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main(String[] args) {

        System.out.println("Ingrese las filas:");
        int f = sc.nextInt();
        System.out.println("Ingrese las columnas (número par):");
        int c = sc.nextInt();

        comprueba = new int[f];
        matriz = new int[f][c];

        if (c % 2 != 0) {
            System.out.println("Las columnas deben ser un número par");
            System.out.println("Adiós :D");
        } else {
            llenarMatriz();

            for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(matriz[i][j]);
                }
                System.out.println();
            }
        }
    }

    // lo que hay que tener en cuenta en este problema es que el número de veces que se van a repetir los números del
    // 1 al numero de filas, serán el número de columnas, por eso el array de contadores debe
    // llegar al número de columnas - 1
    public static void llenarMatriz() {
        int n;
        int ixFila = 0;
        int ixColum = 0;
        while (!verifica()) {
            n = r.nextInt(matriz.length) + 1; // es lo mismo que esto int n = 1 + r.nextInt(f);

            if (comprueba[n - 1] < matriz[0].length) { // si es que el contador no ha llegado a num de columnas entonces se pueden seguir insertando
                if (ixColum == matriz[0].length) {
                    ixColum = 0;
                    ixFila++;
                }

                matriz[ixFila][ixColum] = n;
                comprueba[n - 1]++;
                ixColum++;
            }
        }
    }

    public static boolean verifica() {
        for (int i = 0; i < comprueba.length; i++) {
            if (comprueba[i] < matriz[0].length)
                return false;
        }
        return true;
    }
}

/*
antes de crear verifica

for (int i = 0; i < f; i++) {
                for (int j = 0; j < c; j++) {
                    int n = 1 + r.nextInt(f);
                    matriz[i][j] = n;
                }
            }
        }

        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }

* */
