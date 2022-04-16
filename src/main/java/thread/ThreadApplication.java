package thread;

public class ThreadApplication {
    static volatile Exchanger exchanger = new Exchanger(0);

    public static void main(String... args) throws InterruptedException {
        //Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    // synchronized (lock) {
                    exchanger.increment();
                    print(exchanger.getN(), "increment=");
                    // }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //synchronized (lock) {
                    exchanger.decrement();
                    print(exchanger.getN(), "decrement=");
                    //}
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("finish=" + exchanger.getN());
    }

    private static void print(Integer n, String label) {
        System.out.println(label + n);
    }

}
