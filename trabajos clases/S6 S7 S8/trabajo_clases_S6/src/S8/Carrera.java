package S8;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class Carrera {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("BIENVENIDOS A LAS OLIMPIADAS");
        System.out.println("Ingrese el número de equipos que va a haber");
        int numEquipos = sc.nextInt();

        Equipo[] equipos = new Equipo[numEquipos];
        // long[] tiemposEquipos = new long[numEquipos];

        Map<String, Double> equipoTiempo = new HashMap<>();

        sc.nextLine();  // Consumir el salto de línea restante

        CyclicBarrier barrera = new CyclicBarrier(numEquipos);

        for (int i = 0; i < numEquipos; i++) {
            System.out.println("Ingrese el nombre del equipo");
            String nombreEquipo = sc.nextLine();
            Equipo equipo = new Equipo(nombreEquipo, barrera);
            equipo.start();
            equipos[i] = equipo;
        }

        for(Equipo xd: equipos) {
            try {
                xd.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*for (int i = 0; i < tiemposEquipos.length; i++) {
            tiemposEquipos[i] = equipos[i].tiempoTotalEquipo();
        }*/

        for(int i = 0; i < numEquipos; i++) {
            equipoTiempo.put(equipos[i].getName(), equipos[i].tiempoTotalEquipo());
        }

        /*for(int i = 0; i < equipos.length; i++) {
            System.out.println(equipos[i] + " - Tiempo: " + tiemposEquipos[i]);
        }*/

        ganadorPerdedor(equipoTiempo);
    }

    public static void ganadorPerdedor(Map<String, Double> tiemposEquipos) {
        double menorTiempo = Long.MAX_VALUE;
        String equipoGanador = "";
        double mayorTiempo = Long.MIN_VALUE;
        String equipoPerdedor = "";
        System.out.println("\nDATOS DE CADA EQUIPO\n");
        for (Map.Entry<String, Double> entry : tiemposEquipos.entrySet()) {
            System.out.println("Equipo " + entry.getKey() + ": " + entry.getValue() + " milisegundos");
            if (entry.getValue() < menorTiempo) {
                menorTiempo = entry.getValue();
                equipoGanador = entry.getKey();
            }
            if (entry.getValue() > mayorTiempo) {
                mayorTiempo = entry.getValue();
                equipoPerdedor = entry.getKey();
            }
        }

        if (menorTiempo == mayorTiempo) {
            System.out.println("\nEMPATE!!!!");
        } else {
            System.out.println("\nRESULTADOS DE LA CARRERA\n");
            System.out.println("El equipo ganador es: " + equipoGanador);
            System.out.println("El equipo perdedor es: " + equipoPerdedor);
        }
    }
}
