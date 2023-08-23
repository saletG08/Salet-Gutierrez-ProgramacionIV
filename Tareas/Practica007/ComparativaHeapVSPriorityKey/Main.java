package Practica007.ComparativaHeapVSPriorityKey;

import Practica006.MaxHeap.TreeMaxHeap;
import Practica006.MinHeap.TreeMinHeap;

import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void compareHeapAndPriorityQueue(int numberOfOperations) {
        TreeMaxHeap maxHeap = new TreeMaxHeap(numberOfOperations);
        TreeMinHeap minHeap = new TreeMinHeap(numberOfOperations);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Random random = new Random();

        long startTime, endTime;

        // Insertions
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            int value = random.nextInt(10000); // Change the range as needed
            maxHeap.insert(value);
        }
        endTime = System.nanoTime();
        long maxHeapInsertTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            int value = random.nextInt(10000); // Change the range as needed
            minHeap.insert(value);
        }
        endTime = System.nanoTime();
        long minHeapInsertTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            int value = random.nextInt(10000); // Change the range as needed
            priorityQueue.offer(value);
        }
        endTime = System.nanoTime();
        long priorityQueueInsertTime = endTime - startTime;

        // Removals
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            maxHeap.delete(i);
        }
        endTime = System.nanoTime();
        long maxHeapRemoveTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            minHeap.delete(i);
        }
        endTime = System.nanoTime();
        long minHeapRemoveTime = endTime - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            priorityQueue.poll();
        }
        endTime = System.nanoTime();
        long priorityQueueRemoveTime = endTime - startTime;

        // Print results
        System.out.println("Insert");
        System.out.println("Max Heap Insert Time: " + maxHeapInsertTime + " ns");
        System.out.println("Min Heap Insert Time: " + minHeapInsertTime + " ns");
        System.out.println("Priority Queue Insert Time: " + priorityQueueInsertTime + " ns");
        System.out.println("\nRemove");
        System.out.println("Max Heap Remove Time: " + maxHeapRemoveTime + " ns");
        System.out.println("Min Heap Remove Time: " + minHeapRemoveTime + " ns");
        System.out.println("Priority Queue Remove Time: " + priorityQueueRemoveTime + " ns");
    }

    public static void main(String[] args) {
        int numberOfOperations = 10000; // Number of insertions and removals
        compareHeapAndPriorityQueue(numberOfOperations);
    }
}
