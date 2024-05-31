package p1;

public class MainDemoTask1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (var num : numbers) {
            Thread run = new Thread(new DemoTask1(num));
            run.start();
        }
    }
}
