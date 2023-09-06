package Threads009;

public class MyRunnable implements Runnable {
    public static Monitor mon = new Monitor();
    public int id;

    public MyRunnable(int id) {
        this.id = id;
    }
    @Override
    public void run() {


        System.out.println( mon.inc());

        mon.order(this.id);
    }
}
