package Practica011;

import java.util.Random;
import java.util.concurrent.*;

public class Solution {

    public int solution(int N) {
        int powerOfTwo = 0;

        while (N % 2 == 0) {
            N /= 2;
            powerOfTwo++;
        }

        return powerOfTwo;
    }

    public static void main(String[] args) throws InterruptedException {
        Solution solution = new Solution();
        int N = 10;

        int[] array1 = new int[N];
        int[] array2 = new int[N];

        for (int i = 0; i < N; i++) {
            array1[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(N);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < N; i++) {
            final int index = i;
            completionService.submit(() -> {
                int result = solution.solution(array1[index]);
                array2[index] = result;
                return result;
            });
        }

        Random random = new Random();
        int completedTasks = 0;

        while (completedTasks < N) {
            completedTasks++;

            int sleepTime = random.nextInt(5) + 1;
            Thread.sleep(sleepTime * 1000);

            double progress = (double) completedTasks / N * 100;
            System.out.println("Hilo: " + completedTasks +  " Progreso: " + progress + "%");
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.print("Resultado: [");
        for (int i = 0; i < N; i++) {
            System.out.print(array2[i]);
            if (i < N - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
