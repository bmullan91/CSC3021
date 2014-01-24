package Main;

public class Monitor {

    private boolean inThePit = false;
    private boolean leftTyresChanged;
    private boolean rightTyresChanged;

    public Monitor() {}

    private boolean finished() {
        return (this.rightTyresChanged && this.leftTyresChanged);
    }

    private void reset() {
        this.leftTyresChanged = false;
        this.rightTyresChanged = false;
        this.inThePit = true;
    }

    public synchronized void enterPits() {

        try {
            System.out.println("Entering pit!");
            reset();
            notify();
            while(!finished()) {
                System.out.println("Waiting on bill and ben...");
                wait();
            }
            System.out.println("Leaving the pits");
            this.inThePit = false;

        } catch (InterruptedException e) {}

    }

    public synchronized void changeTyres(BillBen obj) {

        //using the toolbox...

        if(obj.side == "left") {
            System.out.println("Bill has changed the left!");
            this.leftTyresChanged = true;
        } else if(obj.side == "right") {
            System.out.println("Ben has changed the right!");
            this.rightTyresChanged = true;
        }

    }

    public synchronized void checkForAlonso() {
        try {
            while(!inThePit) {
                wait();
            }
            //Go go go
            notifyAll();

        } catch (InterruptedException e) {}

    }

    public synchronized void checkTyres(BillBen obj) {

        try {
            if((obj.side == "left" && this.leftTyresChanged) ||
               (obj.side == "right" && this.rightTyresChanged)) {
                //Someones finished, waiting for the other
                wait();
            }

            //are we there yet?
            if(finished()) {
                notifyAll();
            }

    } catch (InterruptedException e) {}

    }


}