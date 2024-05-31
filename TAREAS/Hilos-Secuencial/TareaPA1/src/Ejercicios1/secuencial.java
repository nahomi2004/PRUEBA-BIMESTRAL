
/* 1. Llenar un vector de dimensión = 80 con valores (1,2,3,4) 
de forma aleatoria en la misma proporción, 20 veces cada numero.*/

package Ejercicios1;

import java.util.Random;

/*public class secuencial {
    static int dim = 80;
    static int rep = 20;
    static int[] vector = new int[dim]; // vectorNums = [0, 0, 0, 0]
    static int[] vectorNums = new int[4]; // Para llevar la cuenta de cuántas veces se ha insertado cada número

    public static void main(String[] args) {
        completarVector();

        // Imprimir el vector para verificar
        System.out.println("\nVector final:");
        for (int i = 0; i < dim; i++) {
            System.out.print(vector[i] +" ");
        }
        System.out.println("");
        contar(1);
        contar(2);
        contar(3);
        contar(4);
        
    }

    public static void completarVector() {
        Random rand = new Random();
        int indice = 0;
        while (!verificar()) { // Mientras no se hayan insertado todas las repeticiones de cada número
            int num = rand.nextInt(4) + 1; // Generar número aleatorio entre 1 y 4  | 3
            if (vectorNums[num - 1] < rep) { // Si no se han insertado todas las repeticiones de este número  |  if (vectorNums[2] < 20) {
                vector[indice] = num; // Insertar el número en el vector   |   vector[index] = 3;
                vectorNums[num - 1]++; // Incrementar el contador para este número  |  vectorNums = [0, 0, 1, 0]
                System.out.println("Se insertó " + num);
                indice++; // Avanzar al siguiente índice
            }
        }
    }

    public static boolean verificar() {
        for (int i = 0; i < vectorNums.length; i++) {
            if (vectorNums[i] < rep) { // vectorNums = [20, 20, 20, 20]
                return false; // Si alguna repetición no se ha completado, devuelve false
            }
        }
        return true; // Todas las repeticiones se han completado
    }
    
    public static void contar(int n){
        int cont = 0;
        for (int i = 0; i < vector.length; i++) {
            if(vector[i] == n){
                cont++;
            }
        }
        System.out.println("Hay " +cont+ " números " +n);
    }
}*/