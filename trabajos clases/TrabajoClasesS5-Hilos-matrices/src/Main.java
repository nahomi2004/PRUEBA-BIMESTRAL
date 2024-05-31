public class Main {
    static int S = 0;
    static void suma(int x, int y, int S) {
        S = x + y;
    }

    public static void main(String[] args) {
        int a = 5, b = 6;
        suma(a,b,S);
        System.out.println(a + " + " + b + " = " + S);
    }
}