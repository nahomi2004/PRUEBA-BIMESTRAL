package S8_noVale;

public class Hilo extends Thread {
    private static Object bloqueo = new Object();
    private static int contGrupos = 0;
    private boolean llegue = false;
    private boolean[] llegadas;
    private int cont;
    private int nH;
    private ThreadGroup nombreG;
    private int numG;

    public Hilo(int cont, ThreadGroup nombreG, int nH, int numG) {
        super(nombreG, "Corredor " + nH);
        this.cont = cont;
        this.nombreG = nombreG;
        this.numG = numG;
    }

    @Override
    public void run() {
        synchronized (bloqueo) {
            contGrupos ++;
            if(contGrupos != numG) {
                try {
                    bloqueo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                bloqueo.notifyAll();
            }
        }
        int ac = 0;
        System.out.println("Está corriendo: " + getName() + " soy del grupo " + nombreG.getName());

        while (ac < cont) {
            ac++;
        }

        Thread[] hilos = new Thread[nombreG.activeCount()];
        nombreG.enumerate(hilos); // obtenemos un array de los Hilos activos del grupo

        if (nH < 4) {
            Thread siguiente = hilos[nH]; // con este hacemos referencia al siguiente hilo al cuál será
            // pasado el relevo
            System.out.println("Va a correr el hilo: " + siguiente.getName());
            siguiente.start();
            try {
                siguiente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El grupo " + nombreG.getName() + " ha finalizado");
        }

    }

    public boolean isLlegue() {
        return llegue;
    }

    public void setLlegue(boolean llegue) {
        this.llegue = llegue;
    }

    public boolean[] getLlegadas() {
        return llegadas;
    }

    public void setLlegadas(boolean[] llegadas) {
        this.llegadas = llegadas;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int getnH() {
        return nH;
    }

    public void setnH(int nH) {
        this.nH = nH;
    }

    public ThreadGroup getNombreG() {
        return nombreG;
    }

    public void setNombreG(ThreadGroup nombreG) {
        this.nombreG = nombreG;
    }
}
