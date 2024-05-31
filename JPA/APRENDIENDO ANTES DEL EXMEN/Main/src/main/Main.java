package main;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "corredores")
class Corredor extends Thread implements Serializable {
    @Id
    private String cedula;
    private String nombre;
    private int velocidad;
    
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

    @Override
    public void run() {
        
    }
}
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MainPU");
        EntityManager em = emf.createEntityManager();
        
        List<Corredor> corredores = em.createQuery("SELECT c FROM Corredor c", Corredor.class).getResultList();
        
        String[][] matrizCorredores = new String[corredores.size()][3];
        System.out.println("CEDULA\t\tNombre\t\tVelocidad");
        for (int i = 0; i < corredores.size(); i++) {
            Corredor corredor = corredores.get(i);
            matrizCorredores[i][0] = corredor.getCedula();
            matrizCorredores[i][1] = corredor.getNombre();
            matrizCorredores[i][2] = String.valueOf(corredor.getVelocidad());
        }
        
        for (String[] fila : matrizCorredores) {
            for (String dato : fila) {
                System.out.print(dato + "\t");
            }
            System.out.println();
        }
      
        em.close();
        emf.close();
        
    }
    
}
