
/* 1. Llenar un vector de dimensión = 80 con valores (1,2,3,4) 
de forma aleatoria en la misma proporción, 20 veces cada numero.*/

package Ejercicios1;

/*public class hilos extends Thread {
    static int dim = 80;
    static int rep = 20;
    static int[] vector = new int[dim];
    static int incide = 0;
    int num;

    public hilos(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < rep; i++) { 
            while (vector[incide] != 0) {
                incide++;
            }
            vector[incide] = num;
            System.out.println(this.getName() + " | " + num + " rep# "+ (i+1));
            
        }
    }

    public static void main(String[] args) {
        Thread h1 = new hilos(1);
        Thread h2 = new hilos(2);
        Thread h3 = new hilos(3);
        Thread h4 = new hilos(4);

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        try {
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nVector final: ");
        for (int i = 0; i < dim; i++) { 
            System.out.print(vector[i] +" ");
        }
    }
}*/