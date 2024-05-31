package S8_noVale;

import java.util.Scanner;

public class Carrera {
    public static void main(String[] args) {

        // crear grupos de hilos
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Cuántos grupos de hilos de 4 quiere?");
        int grupos = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < grupos; i++) {

            System.out.println("Dale un nombre al equipo N° " + (i + 1));
            String nombreGrupo = sc.nextLine();
            ThreadGroup x = new ThreadGroup(nombreGrupo);

            for (int j = 0; j < 4; j++) {
                new Hilo(100, x, j, grupos).start();
            }
        }

    }
}