package Practica009;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Parte2 {
    public static void main(String[] args) {
        int n = 20000;
        int[][] matriz = new int[n][n];

        ExecutorService threadPool = Executors.newFixedThreadPool(n);

        long startTime = System.nanoTime();

        for (int i = 0; i < n; i++) {
            final int row = i;
            threadPool.execute(new MyRunnable(row, matriz));
        }

        threadPool.shutdown();
        while (!threadPool.isTerminated()) {
            // Esperar a que todos los hilos terminen
        }

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        System.out.println("Execution time = " + executionTime + " nano seconds");
    }
}
