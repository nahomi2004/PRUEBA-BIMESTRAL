package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "corredores")
class Corredor extends Thread {
    @Id
    private String cedula;
    private String nombre;
    private int velocidad;
    private long tiempo; 

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        int distancia = 100;
        double randomFactor = new Random().nextDouble() * 0.5 + 0.75; // Factor aleatorio entre 0.75 y 1.25
        long tiempoAleatorio = (long) (distancia / velocidad * 1000 * randomFactor);
        setTiempo(tiempoAleatorio);
        try {
            sleep(tiempoAleatorio);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
    

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MainPU");
        EntityManager em = emf.createEntityManager();

        List<Corredor> corredores = em.createQuery("SELECT c FROM Corredor c", Corredor.class).getResultList();

        String[][] matrizCorredores = new String[corredores.size()][3];
        System.out.println("¡Comienza la carrera!");
        List<Corredor> corredoresFinalizados = new ArrayList<>();

        for (int i = 0; i < corredores.size(); i++) {
            Corredor corredor = corredores.get(i);
            matrizCorredores[i][0] = corredor.getCedula();
            matrizCorredores[i][1] = corredor.getNombre();
            matrizCorredores[i][2] = String.valueOf(corredor.getVelocidad());
            corredor.start();
            corredoresFinalizados.add(corredor);
        }

        for (Corredor corredor : corredores) {
            try {
                corredor.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Tiempos de finalización:");
        for (Corredor corredor : corredoresFinalizados) {
            double tiempoEnSegundos = corredor.getTiempo() / 1000.0; 
            System.out.println(corredor.getNombre() + " ha terminado la carrera en " + tiempoEnSegundos + " segundos.");
        }

        Corredor ganador = determinarGanador(corredoresFinalizados);
        System.out.println("¡El ganador es: " + ganador.getNombre() + "!");

        em.close();
        emf.close();
    }

    public static Corredor determinarGanador(List<Corredor> corredores) {
    Corredor ganador = null;
    double tiempoMenor = Double.MAX_VALUE; 

    for (Corredor corredor : corredores) {
        double tiempoEnSegundos = corredor.getTiempo() / 1000.0; 
        if (tiempoEnSegundos < tiempoMenor) {
            tiempoMenor = tiempoEnSegundos;
            ganador = corredor;
        }
    }

    return ganador;
}
}

/*paquetes = em.createQuery(
                        "SELECT p FROM Paquete p WHERE p.cliente.cedula = :cedula", Paquete.class)
                        .setParameter("cedula", cedula)
                        .getResultList();*/

/* la licencia de este codigo es de STEVEN ISAAC NEIRA GRANDA*/