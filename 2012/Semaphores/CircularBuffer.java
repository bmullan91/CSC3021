import java.util.concurrent.Semaphore;

public class CircularBuffer {

    public int head = 0, tail = 0;
    private int[] buffer;
    private final int CAPACITY;

    public Semaphore spaces, mutex, data;

    public CircularBuffer(int cap) {
        this.CAPACITY = cap;
        this.buffer = new int[cap];
        this.spaces = new Semaphore(cap, true);
        this.mutex = new Semaphore(1, true);
        this.data = new Semaphore(0);
    }

    public void add(int i) {
        try {
            spaces.acquire();
            mutex.acquire();
            //critical section
            buffer[tail] = i;
            tail = (tail+1) % CAPACITY;

            data.release();
            mutex.release();

        } catch (InterruptedException e) {}

    }

    public int remove() {
        int i = 0;
        try {
            data.acquire();
            mutex.acquire();
            //critical section
            i = buffer[head];
            head = (head+1) % CAPACITY;

            spaces.release();
            mutex.release();

        } catch (InterruptedException e) {}
        finally {
            return i;
        }

    }

}
