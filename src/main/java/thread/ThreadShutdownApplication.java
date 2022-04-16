package thread;

import java.util.Scanner;

public class ThreadShutdownApplication {
    public static void main(String... args) {
        ShutDownThread shutDownThread = new ShutDownThread();
        shutDownThread.start();
        Scanner in = new Scanner(System.in);
        if(in.hasNext()){
            shutDownThread.shutdown();
        }
    }
}
