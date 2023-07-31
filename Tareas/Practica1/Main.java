package Practica1;

public class Main {
    public static void main(String[] args) {
        BTree b = new BTree(5);

        b.add(1);
        b.add(7);
        b.add(9);
        b.add(5);
        b.add(21);
        b.add(70);
        b.add(3);
        b.add(8);
        b.add(2);
        b.add(4);
        System.out.println(b);
    }
}
