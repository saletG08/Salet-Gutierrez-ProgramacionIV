package Practica006;

import Practica006.MaxHeap.TreeMaxHeap;
import Practica006.MinHeap.TreeMinHeap;

public class Main {
    public static void main(String[] args) {
        TreeMaxHeap treeMaxHeap = new TreeMaxHeap(10);
        treeMaxHeap.insert(500);
        treeMaxHeap.insert(10);
        treeMaxHeap.insert(62);
        treeMaxHeap.insert(74);
        treeMaxHeap.insert(10);
        treeMaxHeap.insert(-6);
        treeMaxHeap.insert(9);
        treeMaxHeap.insert(-60);
        treeMaxHeap.insert(-80);
        treeMaxHeap.insert(8);
        System.out.println("Add TreeMaxHeap");
        System.out.println(treeMaxHeap);

        System.out.println("Peek Fist TreeMaxHeap");
        System.out.println(treeMaxHeap.peekFist());

        System.out.println("Peek Finish TreeMaxHeap");
        System.out.println(treeMaxHeap.peekFinish());

        System.out.println("Delete 1° TreeMaxHeap number 74");
        treeMaxHeap.delete(74);
        System.out.println(treeMaxHeap);

        System.out.println("Delete 2° TreeMaxHeap number -60");
        treeMaxHeap.delete(-60);
        System.out.println(treeMaxHeap);

        System.out.println("Delete 3° TreeMaxHeap number 500");
        treeMaxHeap.delete(500);
        System.out.println(treeMaxHeap);

        System.out.println("Search 8");
        treeMaxHeap.search(8);

        System.out.println("Search -60");
        treeMaxHeap.search(-60);


        TreeMinHeap treeMinHeap = new TreeMinHeap(10);
        treeMinHeap.insert(3);
        treeMinHeap.insert(1);
        treeMinHeap.insert(2);
        treeMinHeap.insert(80);
        treeMinHeap.insert(51);
        treeMinHeap.insert(70);
        treeMinHeap.insert(-10);
        treeMinHeap.insert(50);
        treeMinHeap.insert(4);


        System.out.println("Add TreeMinHeap");
        System.out.println(treeMinHeap);

        System.out.println("Peek Fist TreeMinHeap");
        System.out.println(treeMinHeap.peekFist());

        System.out.println("Peek Finish TreeMinHeap");
        System.out.println(treeMinHeap.peekFinish());

        System.out.println("Delete 1° TreeMinHeap number 80");
        treeMinHeap.delete(80);
        System.out.println(treeMinHeap);

        System.out.println("Delete 2° TreeMinHeap number 70");
        treeMinHeap.delete(70);
        System.out.println(treeMinHeap);

        System.out.println("Delete 3° TreeMinHeap number 50");
        treeMinHeap.delete(50);
        System.out.println(treeMinHeap);

        System.out.println("Search 51");
        treeMinHeap.search(51);

        System.out.println("Search 70");
        treeMinHeap.search(70);
    }
}
