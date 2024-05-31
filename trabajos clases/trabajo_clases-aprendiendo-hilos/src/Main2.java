public class Main2 {
    public static void main(String[] args) {
        var t1 = new HelloThread();
        var t2 = new Thread(new HelloRunneable());
        Thread myThread = new Thread(new HelloRunneable(), "my-thread");
        Thread t3 = new Thread(() -> {
            System.out.println(String.format("Hola, soy %s", Thread.currentThread().getName()));
        });
    }
}
