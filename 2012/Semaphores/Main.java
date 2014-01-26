import java.nio.IntBuffer;
import java.util.concurrent.*;

public class Main {

    public static Semaphore mutex, spaces;
    public static CircularBuffer buffer;
    private static final int M = 10, N = 10;

    public static void main(String[] args) {
        //creat the shared buffer
        buffer = new CircularBuffer(M);

        //create printer
        Printer p = new Printer(buffer);
        p.start();

        //create n clients
        for(int i = 0; i < N; i++) {
            Client c = new Client(i, buffer);
            c.start();
        }
    }

}
