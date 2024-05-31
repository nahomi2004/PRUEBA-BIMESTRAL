public class HelloThread extends Thread {
    @Override
    public void run() {
        String helloMess = String.format("Hola, soy %s", HelloThread.currentThread().getName());
        System.out.println(helloMess);

    }
}


