package estoCopieYo;

public class Ejemplo_1 extends Thread {
    private int[] lista;
    private int numHilo;

    public Ejemplo_1(int[] lista, int numHilo) {
        this.lista = lista;
        this.numHilo = numHilo;
    }

    public void run() {
        int aux = 0;
        for(int i = 0; i < lista.length; i++) {
            aux += lista[i];
            if ((i % 100000) == 0) {
                System.out.println("Resultado Parcial de Hilo");
            }
        }
        System.out.println("Hilo " + numHilo + ": " + aux);
    }

    public static int[] generarLista(int numeroElementos) {
        int[] lista = new int[numeroElementos];
        for(int i = 0; i < lista.length; i++) {
            lista[i] = (int)(Math.random()*100);
        }
        return lista;
    }

    public static void main(String[] args) {
        int[] listaUno = generarLista(5000000);
        int[] listaDos = generarLista(5000000);

        Ejemplo_1 hilo1 = new Ejemplo_1(listaUno, 1);
        Ejemplo_1 hilo2 = new Ejemplo_1(listaUno, 2);

        hilo1.start();
        hilo2.start();
    }
}
