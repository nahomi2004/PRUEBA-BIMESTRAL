package p1;

public class DemoTask1 implements Runnable {
    private int number;

    public DemoTask1(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.printf("%d\n", number);
    }
}
