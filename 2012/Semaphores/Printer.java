import java.util.Random;

public class Printer extends Thread {

    private CircularBuffer buffer;

    public Printer(CircularBuffer b) {
        this.buffer = b;
    }

    public void run() {
        while(true) {
            System.out.println("Printer trying to print....");
            int i = this.buffer.remove();
            System.out.println("****************************\n\t Printed: "+i + "\n****************************");
            try {
                this.sleep(1500);
            } catch (InterruptedException e) {}

        }
    }

}
