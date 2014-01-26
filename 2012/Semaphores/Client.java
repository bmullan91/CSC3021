import java.util.Random;

public class Client extends Thread {

    private Random random;
    private int id;
    private CircularBuffer buffer;

    public Client(int id, CircularBuffer b) {
        this.random = new Random();
        this.id = id;
        this.buffer = b;
    }

    public void run() {

        while(true) {
            System.out.println("Client id:"+id+" waiting to add.....");
            this.buffer.add(generateDoc());
            System.out.println("Client id: "+id+" successfully added to the buffer!");
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {}

        }

    }

    private int generateDoc() {
        return this.random.nextInt();
    }

}
