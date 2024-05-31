package S7;

import java.util.concurrent.CountDownLatch;

public class SumRowTask implements Runnable {
    private int[] row;
    private final int pos;
    private final int[] sums;
    private CountDownLatch endController;
    int a;

    public SumRowTask(int[] row, int pos, int[] sums, CountDownLatch endController, int a) {
        this.row = row;
        this.pos = pos;
        this.sums = sums;
        this.endController = endController;
        this.a = a;
    }

    @Override
    public void run() {
        var sum = 0;

        for(var num: row) {
            sum += num;
        }

        sums[pos] = sum;
        a = 99999;
        System.out.println("Hilo ------> " + Thread.currentThread().getId());
        endController.countDown();
    }

    public int getA() {
        return a;
    }
}
