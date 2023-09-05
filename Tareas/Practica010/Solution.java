package Practica010;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
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
        int n = 10;

        int[] inputArray = new int[n];
        int[] outputArray = new int[n];

        for (int i = 0; i < n; i++) {
            inputArray[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++) {
            final int index = i;
            executor.submit(() -> {
                int result = solution.solution(inputArray[index]);
                outputArray[index] = result;
            });
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.print("Resultado: [");
        for (int i = 0; i < n; i++) {
            System.out.print(outputArray[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
