package Recuperatorio.Practica2;

import java.util.Arrays;
import java.util.concurrent.*;

public class Solution2 {

    public int[][] createMatrix(int n) {
        int[][] matrix = new int[n][2];
        int count = 1;
        for (int i = 0; i < n; i++) {
            matrix[i][0] = count++;
            matrix[i][1] = count++;
        }
        return matrix;
    }

    public void solveSequential(int[][] matrix) {
        System.out.println("Sequential solution:");
        long startTime = System.nanoTime();
        for (int[] ints : matrix) {
            int A = ints[0];
            int B = ints[1];
            String result = solution(A, B);
            System.out.println(ints[0] + ", " + ints[1] + ", " + result);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Sequential execution time: " + duration + " nanoseconds");
    }

    public void solveConcurrent(int[][] matrix) {
        System.out.println("Concurrent solution:");
        int n = matrix.length;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        FutureTask<String>[] futureTasks = new FutureTask[n];
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            int A = matrix[i][0];
            int B = matrix[i][1];
            Callable<String> callable = () -> solution(A, B);
            futureTasks[i] = new FutureTask<>(callable);
            executorService.submit(futureTasks[i]);
        }

        for (int i = 0; i < n; i++) {
            try {
                System.out.println(matrix[i][0] + ", " + matrix[i][1] + ", " + futureTasks[i].get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Concurrent execution time: " + duration + " nanoseconds");

        executorService.shutdown();
    }

    public String solution(int A, int B) {
        StringBuilder result = new StringBuilder();
        while (A > 0 || B > 0) {
            if (A > B) {
                if (result.length() >= 2 && result.charAt(result.length() - 1)
                        == 'a' && result.charAt(result.length() - 2) == 'a') {
                    result.append('b');
                    B--;
                } else {
                    result.append('a');
                    A--;
                }
            } else {
                if (result.length() >= 2 && result.charAt(result.length() - 1)
                        == 'b' && result.charAt(result.length() - 2) == 'b') {
                    result.append('a');
                    A--;
                } else {
                    result.append('b');
                    B--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int n = 4;
        int[][] matrix = s.createMatrix(n);
        System.out.println("Matrix: " + Arrays.deepToString(matrix));
        s.solveSequential(matrix);
        s.solveConcurrent(matrix);
    }
}
