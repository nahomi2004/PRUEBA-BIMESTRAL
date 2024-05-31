package estoCopieYo;

public class Main {
    public static void main(String[] args) {

        PruebaTH t1, t2, t3;
        t1 = new PruebaTH("Thread 1", (int)(Math.random()*2000));
        t2 = new PruebaTH("Thread 2", (int)(Math.random()*2000));
        t3 = new PruebaTH("Thread 3", (int)(Math.random()*2000));

        t1.start();
        t2.start();
        t3.start();
    }
}