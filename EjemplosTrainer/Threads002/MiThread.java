package Threads002;

public class MiThread extends Thread{

    private Counter counter;

    public MiThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increase();
        }
    }
}
