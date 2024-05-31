package ejercicios;

import java.util.Random;
import java.util.Scanner;

public class sumaFilasTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el número de filas");
        int f = sc.nextInt();
        System.out.println("Ingrese el número de columnas");
        int c = sc.nextInt();

        int [][] matriz = llenarMatriz(f,c);
        int [] sumas = sumarFilasTotal(matriz);
        int total = sumarTotal(sumas);

        System.out.println("Matriz          >> Sumas por filas");
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("        >> " + sumas[i]);
        }
/*
        System.out.println("Sumas por Filas");
        for (int xd: sumas) {
            System.out.println(">> " + xd);
        }
 */

        System.out.println("Suma total:" + total);
    }

    public static int[] [] llenarMatriz(int f, int c) {
        Random r = new Random();
        int [][] matriz = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = r.nextInt(9) + 1;
            }
        }

        return matriz;
    }

    public static int[] sumarFilasTotal(int[][] matriz) {
        int[] sumasFilas = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                sumasFilas[i] += matriz[i][j];
            }
        }

        return sumasFilas;
    }

    public static int sumarTotal(int[] vector) {
        int total = 0;

        for (int i = 0; i < vector.length; i++) {
            total += vector[i];
        }

        return total;
    }
}
