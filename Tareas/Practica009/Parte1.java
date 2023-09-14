package Practica009;

public class Parte1 {
    public static void main(String[] args) {
        int n = 20000;
        int[][] matriz = new int[n][n];

        Thread[] threads = new Thread[n];

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            final int row = i;
            threads[i] = new Thread(new MyRunnable(row, matriz));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution time = " + executionTime + " nano seconds");
    }
}

