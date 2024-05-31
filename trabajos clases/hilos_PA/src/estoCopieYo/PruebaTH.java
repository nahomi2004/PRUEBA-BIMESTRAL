package estoCopieYo;

public class PruebaTH extends Thread {
    private String nombre;
    private int retardo;

    public PruebaTH(String nombre, int retardo) {
        this.nombre = nombre;
        this.retardo = retardo;
    }

    public void run() {
        try {
            sleep(retardo);
        } catch (InterruptedException e) {
            ;
        }

        System.out.println("¡Hola mundo!" + nombre + " " + retardo);
    }
}
