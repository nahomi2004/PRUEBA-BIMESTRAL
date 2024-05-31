public class HelloRunneable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        String helloMess = String.format("Hola, soy %s", threadName);
        System.out.println(helloMess);
    }
}
