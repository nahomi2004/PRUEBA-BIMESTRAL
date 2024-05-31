
import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la dimension de las matrices a sumar:");
        System.out.println("Filas");
        int n = entrada.nextInt();
        System.out.println("Columnas");
        int n2 = entrada.nextInt();

        int[][] m1;
        int[][] m2;
        int[][] mr;

        // LLENAR MATRICES
        m1 = llenarMatrices(n, n2);
        m2 = llenarMatrices(n, n2);

        // SUMAR MATRICES Y DE PASO LLENAR LA MATRIZ C
        mr = sumarMatrices(m1, m2);

        // PRESENTAR MATRICES
        System.out.println("\nMatriz A");
        presentar(m1);
        System.out.println("\nMatriz B");
        presentar(m2);
        System.out.println("\nLa Matriz resultante de la suma es: ");
        System.out.println("Matriz C");
        presentar(mr);
    }

    public static int[][] sumarMatrices(int[][] m1, int [][] m2) {
        int[][] mr = new int[m1.length][m1[0].length];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                mr[i][j] = m1[i][j] + m2[i][j];
            }
        }

        return mr;
    }

    public static int[][] llenarMatrices(int x, int y) {
        int[][] m = new int[x][y];

        for (int i=0; i < m.length; i++) {
            for (int j=0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random()*9+1);
            }
        }

        return m;
    }

    public static void presentar(int[][] x){
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                System.out.print(x[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
