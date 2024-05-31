package Vector;// @Author: CABRERA PICOITA NAHOMI ASTRID

public class Hilos extends Thread {

    private int n;
    private static int vector[] = new int[80];
    private static int cont = 0;
    private int rango = 20;

    public Hilos(int n) {
        this.n = n;
    }

    // cada hilo se ejecutará 20 veces y agregarán un número en el vector que comparten los 4
    // se irán agregando los números conforme vayan llegando
    // lo único que recibe el hilo es el número
    @Override
    public void run() {
        for (int i = 0; i < rango; i++) {
            System.out.println("Agregado: " + n);
            vector[cont] = n;
            cont++;
        }
    }

    public int getN() {
        return n;
    }

    public static int[] getVector() {
        return vector;
    }

    public static void main(String[] args) {
        Hilos h1 = new Hilos(1);

        Hilos h2 = new Hilos(2);

        Hilos h3 = new Hilos(3);

        Hilos h4 = new Hilos(4);

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        try { // se espera a que todos acaben de llenar el vector para imprimir de igual forma que en la clase secuencial
            h1.join();
            h2.join();
            h3.join();
            h4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int uwu = 1;
        for (int xd : getVector()) {
            System.out.print(xd + " - ");
            if (uwu == 20 || uwu == 40 || uwu == 60) {
                System.out.println();
            }
            uwu++;
        }
    }
}
