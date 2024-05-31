import java.util.stream.IntStream;

public class Test1 {
    private static final IntStream values = IntStream.range(100_000,1_000_000);
    public static void main(String[] args) {

        var results = values.parallel().filter(Main::isPrime);

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
