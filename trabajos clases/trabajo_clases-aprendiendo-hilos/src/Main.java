import java.util.stream.IntStream;

public class Main {
    private static final IntStream  values = IntStream.range(100_000,1_000_000);
    public static void main(String[] args) {

        var results = values.filter(Main::isPrime); // es una referencia al método ---> ::
        // :: es un operador que permite reutilizar varias veces el método al que hace referencia

        System.out.printf("Nro. primos: %d\n" , results.count());
    }

    public static boolean isPrime(int nro) {
        if(nro < 2) return false;
        if(nro == 2) return true;
        if(nro % 2 == 0) return false;

        for(var i = 2; i < nro; i++) {
            if(nro % i == 0) return false;
        }
        return true;
    }
}