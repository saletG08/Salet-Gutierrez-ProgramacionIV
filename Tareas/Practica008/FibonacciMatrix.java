package Practica008;

import java.util.Scanner;
import java.util.Random;

public class FibonacciMatrix {

    public int[][] generateRandomMatrix(int rows, int cols, int minValue, int maxValue, int numThreads) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        Thread[] threads = new Thread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            int startRow = (rows * t) / numThreads;
            int endRow = (rows * (t + 1)) / numThreads;

            threads[t] = new Thread(() -> {
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < cols; j++) {
                        int randomValue = random.nextInt(maxValue - minValue + 1) + minValue;
                        matrix[i][j] = randomValue;
                    }
                }
            });

            threads[t].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public void calculateFibonacciMatrixSequential(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = calculateFibonacci(matrix[i][j]);
            }
        }
    }

    public void calculateFibonacciMatrix(int[][] matrix, int numThreads) {
        Thread[] threads = new Thread[numThreads];

        for (int t = 0; t < numThreads; t++) {
            int startRow = (matrix.length * t) / numThreads;
            int endRow = (matrix.length * (t + 1)) / numThreads;

            threads[t] = new Thread(() -> {
                for (int i = startRow; i < endRow; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = calculateFibonacci(matrix[i][j]);
                    }
                }
            });

            threads[t].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int calculateFibonacci(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int threadsIsEmpty(String numberThreads){
        int numThreads;
        if (numberThreads.trim().isEmpty()) {
            numThreads = Runtime.getRuntime().availableProcessors();
        } else {
            numThreads = Integer.parseInt(numberThreads);
        }
        return numThreads;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FibonacciMatrix fibonacciMatrix = new FibonacciMatrix();

        System.out.print("Filas de la Matriz: ");
        int numberRow = scanner.nextInt();
        System.out.print("Columnas de la matriz: ");
        int numberColumns = scanner.nextInt();
        System.out.print("Numero de cores: ");
        String threads = scanner.next();
        int numberThreads = fibonacciMatrix.threadsIsEmpty(threads);
        System.out.print("Rango de valores aleatorios min: ");
        int minRandom = scanner.nextInt();
        System.out.print("Rango de valores aleatorios max: ");
        int maxRandom = scanner.nextInt();

        int[][] matrix = fibonacciMatrix.generateRandomMatrix(numberRow, numberColumns, minRandom, maxRandom, numberThreads);

        System.out.println("Matriz Aleatoria:");
        fibonacciMatrix.printMatrix(matrix);
        // Calcular la matriz resultante utilizando concurrencia
        long startTimeConcurrent = System.currentTimeMillis();
        fibonacciMatrix.calculateFibonacciMatrix(matrix, numberThreads);

        System.out.println("Matriz Resultante:");
        fibonacciMatrix.printMatrix(matrix);

        // Calcular la matriz resultante utilizando concurrencia
        long endTimeConcurrent = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución concurrente: " + (endTimeConcurrent - startTimeConcurrent) + " ms");

        // Calcular la matriz resultante secuencialmente
        int[][] sequentialMatrix = fibonacciMatrix.generateRandomMatrix(numberRow, numberColumns, minRandom, maxRandom, 1);
        long startTimeSequential = System.currentTimeMillis();
        fibonacciMatrix.calculateFibonacciMatrixSequential(sequentialMatrix);
        long endTimeSequential = System.currentTimeMillis();

        System.out.println("Tiempo de ejecución secuencial: " + (endTimeSequential - startTimeSequential) + " ms");
    }
}
