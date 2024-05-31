package S8;

import java.util.concurrent.CyclicBarrier;

class Equipo extends Thread {
    private double []tiemposCorredores;
    private String nombreEquipo;
    private Corredor[] corredores = new Corredor[4];
    private CyclicBarrier barrera;

    public Equipo(String nombreEquipo, CyclicBarrier barrera) {
        super(nombreEquipo.toUpperCase());
        this.nombreEquipo = nombreEquipo;
        this.barrera = barrera;
        tiemposCorredores = new double[4];
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            Corredor corredor = new Corredor(i, barrera, getName());
            corredores[i - 1] = corredor;
            corredor.start();

            try {
                corredor.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tiemposCorredores[i - 1] = corredor.getTiempoTotal();
        }
    }

    public double[] getTiemposCorredores() {
        return tiemposCorredores;
    }

    public double tiempoTotalEquipo() {
        double ac = 0;
        for (double xd: tiemposCorredores)
            ac += xd;

        return ac;
    }
}
