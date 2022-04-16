package prod_cons;

import lombok.AllArgsConstructor;

import java.util.Stack;

@AllArgsConstructor
public class Producer extends Thread {
    private int number;
    private Stack<String> pool;

    public void run() {
        for (int i = 0; i < 10000; i++) {
            pool.push("message " + number);
            ++number;
        }
    }
}
