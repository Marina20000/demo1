package prod_cons;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.Stack;

@AllArgsConstructor
@Setter
public class Consumer extends Thread {
    private Stack<String> pool;
    private boolean stop;

    public void run() {
        while (!stop) {
            while (pool == null || pool.size() == 0) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (pool) {
                if (pool.size() > 1) {
                    System.out.println(pool.pop());
                }
            }
        }
    }
}
