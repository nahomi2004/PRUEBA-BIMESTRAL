public class Test2 {
    public static void main(String[] args) {
        System.out.printf("%s - ejecutándose\n", HelloThread.currentThread().getName());
        // creación 5 hilos
        for(int i = 0 ; i < 5; i++) {
            new Thread(() -> {
                System.out.printf("%s - ejecutándose\n", HelloThread.currentThread().getName());
            }).start();
        }
        System.out.printf("Fin del %s\n", HelloThread.currentThread().getName());
    }
}
