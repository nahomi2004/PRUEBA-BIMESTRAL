package Vector;// @Author: CABRERA PICOITA NAHOMI ASTRID

import java.util.Random;


// Llenar un vector de dimensión = 80 con valores (1,2,3,4) de forma aleatoria en la misma
// proporción, 20 veces cada numero.

public class Secuencial {
    private static int[] vector = new int[80];
    private static int[] comprueba = new int[4];
    private static Random r = new Random();

    public static void main(String[] args) {
        llenarVector();

        int uwu = 1;
        for (int xd : vector) { // este for each permite que se imprima en filas de 20 el vector principal
            System.out.print(xd + " - ");
            if (uwu == 20 || uwu == 40 || uwu == 60) {
                System.out.println();
            }
            uwu++;
        }
    }

    public static void llenarVector() {
        int n;
        int indx = 0;
        while (!verifica()) {
            n = r.nextInt(4) + 1;
            if (comprueba[n - 1] < 20) { // si es que el contador no ha llegado a 19 entonces se pueden seguir insertando
                vector[indx] = n;
                comprueba[n - 1]++;
                indx++;
            }
        }
    }

    // verifica es la union de los contadores por cada número, la unión de estos contadores es un array de 4
    // cuando todas los posiciones sean 20 decuelve un true indicando de que el vector principal tiene 20 veces
    // cada uno de los números (1 2 3 4)
    public static boolean verifica() {
        for (int i = 0; i < comprueba.length; i++) {
            if (comprueba[i] < 20)
                return false;
        }
        return true;
    }
}

// este es el código que se hizo antes de todo esto, no llegaba a ser eficiente para nada

/*
int a = 1, b = 1, c = 1, d = 1;

        for (int i = 0; i < vector.length; i++) {
            int n = 1 + r.nextInt(4);

            if (d > 20 && c > 20 && b > 20) {
                n = 1;
            } else if (d > 20 && c > 20 && a > 20) {
                n = 2;
            } else if (d > 20 && b > 20 && a > 20) {
                n = 3;
            } else if (c > 20 && b > 20 && a > 20) {
                n = 4;
            }

            if (n == 1 && a < 20) {
                vector[i] = n;
                a++;
            } else if (n == 2 && b < 20) {
                vector[i] = n;
                b++;
            } else if (n == 3 && c < 20) {
                vector[i] = n;
                c++;
            } else if (n == 4 && d < 20) {
                vector[i] = n;
                d++;
            }

            if (n == 1 && a >= 20) {
                i--;
            } else if (n == 2 && b >= 20) {
                i--;
            } else if (n == 3 && c >= 20) {
                i--;
            } else if (n == 4 && d >= 20) {
                i--;
            }
        }

        for (int uwu : vector) {
            System.out.println(uwu);
        }

        System.out.printf("1: %d - 2: %d - 3: %d - 4: %d", a, b, c, d);
*/

/*
            if (a > 20) {
                n = 2 + r.nextInt(3);
            } else if (a > 20 && b > 20) {
                n = 3 + r.nextInt(2);
            } else if (a > 20 && b > 20 && c > 20) {
                n = 4;
            }


            if (d > 20) {
                n = 2 + r.nextInt(3);
            } else if (d > 20 && c > 20) {
                n = 3 + r.nextInt(2);
            } else if (d > 20 && c > 20 && b > 20) {
                n = 1;
            }

* */