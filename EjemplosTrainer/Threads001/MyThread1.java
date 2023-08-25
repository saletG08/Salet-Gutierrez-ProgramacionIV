package Threads001;

public class MyThread1 extends Thread{
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número: " + i);
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
