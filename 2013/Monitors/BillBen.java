package Main;

public class BillBen extends Thread {

    private Monitor m;
    public String side;
    private boolean jobToDo;

    public BillBen(Monitor mon, String side) {
        this.m = mon;
        this.side = side;
    }

    public void run() {

            while(true) {

                m.checkForAlonso();
                m.changeTyres(this);
                m.checkTyres(this);

            }

    }
}
