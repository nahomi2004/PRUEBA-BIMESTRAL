package S8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Corredor extends Thread {
    private int mt;
    private CyclicBarrier barrera;
    private String equipo;
    private double tiempoTotal;

    public Corredor(int n, CyclicBarrier barrera, String equipo) {
        super("Corredor " + n);
        this.mt = 0;
        this.barrera = barrera;
        this.equipo = equipo;
    }

    @Override
    public void run() {
        try {
            barrera.await();  // Espera a que todos los corredores estén listos
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("El " + getName() + " ha empezado a correr. Equipo: " + equipo);
        long inicio = System.currentTimeMillis();

        try { // duermo al hilo para que sea visible la demora jeje
            sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (mt < 100) { // simula que recorre los 100metros
            mt++;
        }

        long fin = System.currentTimeMillis();

        tiempoTotal = fin - inicio;
        System.out.println(getName() + " ha terminado de correr");
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }
}
