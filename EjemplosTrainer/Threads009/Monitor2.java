package Threads009;

public class Monitor2 {
    private boolean printA = true;

    public synchronized void printA() {
        for (int i = 0; i < 5; i++) {
            while (!printA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A ");
            printA = false;
            notify();
        }
    }

    public synchronized void printB() {
        for (int i = 0; i < 5; i++) {
            while (printA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B ");
            printA = true;
            notify();
        }
    }
}
