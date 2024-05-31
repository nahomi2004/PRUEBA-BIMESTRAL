package p1;

public class DemoTask implements Runnable {
    private int number;

    public DemoTask(int number) {
        this.number = number;
        run();
    }

    @Override
    public void run() {
        System.out.printf("%d\n", number);
    }
}
