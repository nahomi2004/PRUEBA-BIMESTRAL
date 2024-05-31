import java.util.Scanner;

public class NumMatrices {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese la dimension de las matrices a sumar:");
        System.out.println("Filas");
        int n = entrada.nextInt();

        System.out.println("Columnas");
        int n2 = entrada.nextInt();

        int[][] m1;
        m1 = llenarMatrices(n, n2);
        presentar(m1);
        System.out.println("Suma de los números dentro: " + sumaNumMatrices(m1));
    }
    
    public static int sumaNumMatrices(int[][] x) {
        int ac = 0;

        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[0].length; j++){
                ac += x[i][j];
            }
        }        
        return ac;
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
        System.out.println();
        for(int i = 0; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                System.out.print(x[i][j] + " - ");
            }
            System.out.println();
        }
    }
}
