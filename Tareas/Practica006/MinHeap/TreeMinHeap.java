package Practica006.MinHeap;

import java.util.LinkedList;
import java.util.Queue;

public class TreeMinHeap{
    private int[] treeMinHeap;
    private int size;

    public TreeMinHeap(int capacity) {
        this.size = 0;
        this.treeMinHeap = new int[capacity];
    }

    public int peekFist() {
        if (isEmpty()) {
            throw new IllegalStateException("The treeMaxHeap is empty");
        }
        return treeMinHeap[0];
    }

    public int peekFinish() {
        if (isEmpty()) {
            throw new IllegalStateException("The treeMaxHeap is empty");
        }
        return treeMinHeap[size - 1];
    }

    public boolean insert(int value) {
        if (size >= treeMinHeap.length) {
            if (!resizeHeap()){
                return false;
            }
        }
        treeMinHeap[size] = value;
        bubbleUp(size);
        size++;
        return true;
    }

    private boolean resizeHeap() {
        int[] newHeap = new int[treeMinHeap.length * 2];
        for (int i = 0; i < treeMinHeap.length; i++) {
            newHeap[i] = treeMinHeap[i];
        }
        treeMinHeap = newHeap;
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
            if (treeMinHeap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void removeValueAtIndex(int index) {
        size--;
        treeMinHeap[index] = treeMinHeap[size];
        treeMinHeap[size] = 0;
    }

    private void adjustHeapAfterRemoval(int index) {
        int parentIndex = getParentIndex(index);
        if (index > 0 && treeMinHeap[index] < treeMinHeap[parentIndex]) {
            bubbleUp(index);
        } else {
            bubbleDown(index);
        }
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            if (treeMinHeap[parentIndex] > treeMinHeap[index]) {
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
            int smallest = findSmallChildIndex(index, leftChildIndex, rightChildIndex);

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private int findSmallChildIndex(int parentIndex, int leftChildIndex, int rightChildIndex){
        int smallest = parentIndex;
        if (leftChildIndex  < size && treeMinHeap[leftChildIndex] < treeMinHeap[smallest]) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < size && treeMinHeap[rightChildIndex] < treeMinHeap[smallest]) {
            smallest = rightChildIndex;
        }

        return smallest;
    }

    public void swap (int fPos , int sPos) {
        int tmp;
        tmp = treeMinHeap[fPos];
        treeMinHeap[fPos] = treeMinHeap[sPos];
        treeMinHeap[sPos] = tmp;
    }

    public boolean search(int value) {
        for (int i = 0; i < size; i++) {
            if (treeMinHeap[i] == value) {
                System.out.println("The value " + value + " is inside the tree");
                return true;
            }
        }
        System.out.println("The value " + value + " is not found inside the tree");
        return false;
    }

    private int getParentIndex(int i) {
        return (i - 1)/ 2;
    }

    private int getLeftIndex(int i) {
        return (i * 2) + 1;
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
            return "TreeMinHeap is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            StringBuilder levelSb = new StringBuilder();

            for (int i = 0; i < levelSize; i++) {
                int index = queue.poll();
                levelSb.append("[").append(treeMinHeap[index]).append("]");

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
