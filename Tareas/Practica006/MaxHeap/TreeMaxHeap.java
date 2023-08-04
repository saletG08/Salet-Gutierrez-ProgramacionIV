package Practica006.MaxHeap;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxHeap {
    private int[] treeMaxHeap;
    private int size;

    public TreeMaxHeap(int capacity) {
        this.size = 0;
        this.treeMaxHeap = new int[capacity];

    }

    public int peekFist() {
        if (isEmpty()) {
            throw new IllegalStateException("The treeMaxHeap is empty");
        }
        return treeMaxHeap[0];
    }

    public int peekFinish() {
        if (isEmpty()) {
            throw new IllegalStateException("The treeMaxHeap is empty");
        }
        return treeMaxHeap[size - 1];
    }

    public boolean insert(int value) {
        if (size >= treeMaxHeap.length) {
            if (!resizeHeap()){
                return false;
            }
        }
        treeMaxHeap[size] = value;
        bubbleUp(size);
        size++;
        return true;
    }

    private boolean resizeHeap() {
        int[] newHeap = new int[treeMaxHeap.length * 2];
        for (int i = 0; i < treeMaxHeap.length; i++) {
            newHeap[i] = treeMaxHeap[i];
        }
        treeMaxHeap = newHeap;
        return true;
    }

    public boolean delete(int value) {
        int index = findIndex(value);

        if (index == -1) {
            return false;
        }

        removeValueAtIndex(index);
        adjustHeapAfterRemoval(index);

        return true;
    }

    private int findIndex(int value) {
        for (int i = 0; i < size; i++) {
            if (treeMaxHeap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void removeValueAtIndex(int index) {
        size--;
        treeMaxHeap[index] = treeMaxHeap[size];
        treeMaxHeap[size] = 0;
    }

    private void adjustHeapAfterRemoval(int index) {
        int parentIndex = getParentIndex(index);
        if (index > 0 && treeMaxHeap[index] > treeMaxHeap[parentIndex]) {
            bubbleUp(index);
        } else {
            bubbleDown(index);
        }
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            if (treeMaxHeap[parentIndex] < treeMaxHeap[index]) {
                swap(parentIndex, index);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown(int index) {
        while (index < size) {
            int leftChildIndex = getLeftIndex(index);
            int rightChildIndex = getRightIndex(index);
            int largest = findLargestChildIndex(index, leftChildIndex, rightChildIndex);

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private int findLargestChildIndex(int parentIndex, int leftChildIndex, int rightChildIndex) {
        int largest = parentIndex;

        if (leftChildIndex < size && treeMaxHeap[leftChildIndex] > treeMaxHeap[largest]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size && treeMaxHeap[rightChildIndex] > treeMaxHeap[largest]) {
            largest = rightChildIndex;
        }

        return largest;
    }

    public void swap (int fPos , int sPos) {
        int tmp;
        tmp = treeMaxHeap[fPos];
        treeMaxHeap[fPos] = treeMaxHeap[sPos];
        treeMaxHeap[sPos] = tmp;
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (treeMaxHeap[i] == value) {
                System.out.println("The value " + value + " is inside the tree");
                return true;
            }
        }
        System.out.println("The value " + value + " is not found inside the tree");
        return false;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftIndex(int i) {
        return (2 * i) + 1;
    }

    private int getRightIndex(int i) {
        return (2 * i) + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "TreeMaxHeap is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            StringBuilder levelSb = new StringBuilder();

            for (int i = 0; i < levelSize; i++) {
                int index = queue.poll();
                levelSb.append("[").append(treeMaxHeap[index]).append("]");

                int leftChildIndex = getLeftIndex(index);
                int rightChildIndex = getRightIndex(index);

                if (leftChildIndex < size) {
                    queue.offer(leftChildIndex);
                }

                if (rightChildIndex < size) {
                    queue.offer(rightChildIndex);
                }
            }

            sb.append(levelSb.toString().trim());
            sb.append("\n");
        }

        return sb.toString();
    }
}
