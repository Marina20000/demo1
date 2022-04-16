package prod_cons;

import java.util.Stack;

public class ProdConsApplication {
    private static volatile Integer number = 0;

    public static void main(String... args) throws InterruptedException {
        Producer[] producers = new Producer[5];
        Stack<String> messagePool = new Stack<>();
        for (int i = 0; i < 5; i++) {
            producers[i] = new Producer(number, messagePool);
            producers[i].setName("Producer " + i);
        }

        Consumer[] consumers = new Consumer[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(messagePool, false);
            consumers[i].setName("Consumer " + i);
            consumers[i].start();
        }

        for (int i = 0; i < 5; i++) {
            producers[i].start();
        }

        Thread.sleep(10000);

        for (int i = 0; i < 3; i++) {
            consumers[i].setStop(true);
        }


    }
}
