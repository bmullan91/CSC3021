import java.nio.IntBuffer;
import java.util.concurrent.*;

public class Main {

    public static Semaphore mutex, spaces;
    public static CircularBuffer buffer;
    private static final int CAPACITY = 10;

    public static void main(String[] args) {

        mutex = new Semaphore(1);
        spaces = new Semaphore(CAPACITY);
        buffer = new CircularBuffer(CAPACITY);

        //create printer
        Printer p = new Printer(buffer);
        p.start();

        //create n clients

        for(int i = 0; i < 9; i++) {
            Client c = new Client(i, buffer);
            c.start();
        }
    }

}
