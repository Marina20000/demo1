package thread;

import lombok.SneakyThrows;

public class SleepThreadApplication {
    public static void main(String... args) {

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread1.interrupt();
    }
}
