package Main;

public class Alonso extends Thread {

    private Monitor m;

    public Alonso(Monitor mon) {
        this.m = mon;
    }

    public void run() {
        while(true) {
            drive();
            m.enterPits();
        }
    }

    private void drive() {
        try {
            System.out.println("\nDriving.......\n");
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

    }


}
