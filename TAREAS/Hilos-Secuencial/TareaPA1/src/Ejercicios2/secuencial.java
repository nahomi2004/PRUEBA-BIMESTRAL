
/*2. Llenar una matriz de dimensión (n x m (par)) con valores de 
1 a n de forma aleatoria en la proporcion de veces cada numero 
(si la matriz es 3x4 se debe llenar con 1,2,3 4 veces cada 
numero de forma aleatoria)*/

package Ejercicios2;

import java.util.Random;
import java.util.Scanner;

public class secuencial {
    static Scanner entrada = new Scanner(System.in);
    static int m; // Columnas de la matriz
    static int[][] matriz; // Matriz a llenar
    static int[] contNums; // Contador para cada número
    static int repNums;
    static int n; 
    
    public static void main(String[] args) {
        
        // n = 3;
        // m = 4;
        
        System.out.println("Ingrese el número de filas:");
        n = entrada.nextInt();
        
        System.out.println("Ingrese un número PAR de columnas:");
        m = entrada.nextInt();

        if (m % 2 == 0) {
            matriz = new int[n][m]; 
            contNums = new int[n]; 
            repNums = (n * m) / n; // Número de repeticiones para cada número

            completarMatriz();

            // Imprimir la matriz final
            System.out.println("\nMatriz final:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }

            // Contar números repetidos
            for (int i = 1; i <= n; i++) {
                contar(i);
            }
            
        } else {
            System.out.println("El número de columnas debe ser par");
        }
    }

    public static void completarMatriz() {
        Random rand = new Random();
        int filledCount = 0;

        while (filledCount < n * m) {
            int num = rand.nextInt(n) + 1; // Genera un número aleatorio entre 1 y n
            if (contNums[num - 1] < repNums) { // Si no se han insertado todas las repeticiones de este número
                boolean insertar = false;
                while (!insertar) {
                    int i = rand.nextInt(n); // genera numeros desde n
                    int j = rand.nextInt(m); // genera las repeticiones de los numeros
                    if (matriz[i][j] == 0) {
                        matriz[i][j] = num;
                        contNums[num - 1]++;
                        filledCount++;
                        System.out.println("Se insertó " + num + " en la posición [" + i + "][" + j + "]");
                        insertar = true;
                    }
                }
            }
        }
    }
    
    public static void contar(int numero) {
        int cont = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == numero) {
                    cont++;
                }
            }
        }
        System.out.println("Hay " + cont + " números " + numero + " en la matriz.");
    }
}
