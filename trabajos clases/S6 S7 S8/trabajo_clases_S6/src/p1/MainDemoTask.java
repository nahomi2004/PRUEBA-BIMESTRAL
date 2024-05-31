package p1;

public class MainDemoTask {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (var num : numbers) {
            Runnable run = new DemoTask(num);
        }
    }
}
