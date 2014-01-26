import java.util.Random;

public class Printer extends Thread {

    private CircularBuffer buffer;

    public Printer(CircularBuffer b) {
        this.buffer = b;
    }

    public void run() {
        while(true) {
            System.out.println("Printer trying to print....");
            printPage(buffer.remove());
            try {
                this.sleep(1500);
            } catch (InterruptedException e) {}

        }
    }

    private void printPage(int p) {
        System.out.println("****************************\n\t Printed: "+p + "\n****************************");
    }

}
