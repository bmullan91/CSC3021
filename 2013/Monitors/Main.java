package Main;

public class Main {

    public static void main(String[] args) {

        //create monitor
        Monitor sharedMon = new Monitor();

        //create alonso
        Alonso alonso = new Alonso(sharedMon);

        //create bill & ben
        BillBen bill = new BillBen(sharedMon, "left");
        BillBen ben = new BillBen(sharedMon, "right");

        //Get them going..
        bill.start();
        ben.start();
        alonso.start();

    }
}