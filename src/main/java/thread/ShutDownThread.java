package thread;

public class ShutDownThread extends Thread {
    private boolean isRunning = true;

    public void run() {
        while (isRunning) {
            System.out.println("Hello!");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        isRunning = false;
    }
}
