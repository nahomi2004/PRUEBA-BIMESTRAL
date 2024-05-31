import java.util.Random;

public class ResolCarrera extends Thread {
    static boolean seguir = true; // variable que comparte todos los hilos STATIC
    Random random = new Random();
    int con;
    int inc;

    public void run() {
        while (con < 100 && seguir) {
            inc = random.nextInt(1, 10);
            con = con + inc;

            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (con >= 100 && seguir) {
                seguir = false;
                System.out.println(this.getName() + " " + "gana");
            } else {
                System.out.println(this.getName() + " " + con);
            }
        }
    }

    public static void main(String[] args) {

        // este programa lo que hace es generar numeros aleatorios y que cuando el acumulador que suma todos estos
        // llegue a 100 será el ganador,
        // en el mejor de los casos es que en 10 repeticiones del ciclo while se llegue a 100 y gane
        // en el peor de los casos es que siempre random tire el número 1

        ResolCarrera t1 = new ResolCarrera();
        ResolCarrera t2 = new ResolCarrera();
        ResolCarrera t3 = new ResolCarrera();
        ResolCarrera t4 = new ResolCarrera();

        t1.start(); // este ganó (round 2) Thread-0 gana (round 3) Thread-0 gana
        t2.start();
        t3.start(); // este ganó (round 1) Thread-2 gana (round 4) Thread-2 gana (round 5) Thread-2 gana (round 6) Thread-2 gana
        t4.start();

        // ganador de estas 6 rondas >>> Thread-2 (t3) <<<
    }
}
