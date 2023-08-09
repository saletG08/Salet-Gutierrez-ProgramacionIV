package TestPractica004;

import Practica004.BTree;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class BTreeAdd {
    @Test
    public void insert(){
        BTree<Integer> bTree = new BTree<>(3);
        assertTrue(bTree.add(3));
    }

    @Test
    public void insert_Size(){
        BTree<Integer> bTree = new BTree<>(3);
        assertEquals(0, bTree.getSizeNode());
        bTree.add(3);
        bTree.add(6);
        bTree.add(7);
        bTree.add(9);
        bTree.add(45);
        bTree.add(20);
        bTree.add(2);
        bTree.add(1);
        bTree.add(30);
        bTree.add(60);
        bTree.add(5);
        assertEquals(11, bTree.getSizeNode());
    }

    @Test
    public void insert_ThreeElementsOrder3() {
        BTree<Integer> bTree = new BTree<>(3);
        bTree.add(8);
        bTree.add(5);
        bTree.add(12);
        assertEquals(Optional.of(8), Optional.ofNullable(bTree.getRoot().getKey(0)));
        assertEquals(Optional.of(5), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(0)));
        assertEquals(Optional.of(12), Optional.ofNullable(bTree.getRoot().getChild(1).getKey(0)));
    }

    @Test
    public void insert_FiveElementsOrder3() {
        BTree<Integer> bTree = new BTree<>(3);
        bTree.add(3);
        bTree.add(2);
        bTree.add(6);
        bTree.add(7);
        bTree.add(1);
        assertEquals(Optional.of(3), Optional.ofNullable(bTree.getRoot().getKey(0)));
        assertEquals(Optional.of(1), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(0)));
        assertEquals(Optional.of(2), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(1)));
        assertEquals(Optional.of(6), Optional.ofNullable(bTree.getRoot().getChild(1).getKey(0)));
        assertEquals(Optional.of(7), Optional.ofNullable(bTree.getRoot().getChild(1).getKey(1)));
    }

    @Test
    public void insert_ThreeElementsOrder4() {
        BTree<Integer> bTree = new BTree<>(4);
        bTree.add(70);
        bTree.add(40);
        bTree.add(110);
        assertEquals(Optional.of(40), Optional.ofNullable(bTree.getRoot().getKey(0)));
        assertEquals(Optional.of(70), Optional.ofNullable(bTree.getRoot().getKey(1)));
        assertEquals(Optional.of(110), Optional.ofNullable(bTree.getRoot().getKey(2)));
    }

    @Test
    public void insert_SixElementsOrder5() {
        BTree<Integer> bTree = new BTree<>(5);
        bTree.add(50);
        bTree.add(20);
        bTree.add(90);
        bTree.add(100);
        bTree.add(10);
        bTree.add(30);
        assertEquals(Optional.of(50), Optional.ofNullable(bTree.getRoot().getKey(0)));
        assertEquals(Optional.of(10), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(0)));
        assertEquals(Optional.of(20), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(1)));
        assertEquals(Optional.of(30), Optional.ofNullable(bTree.getRoot().getChild(0).getKey(2)));
        assertEquals(Optional.of(90), Optional.ofNullable(bTree.getRoot().getChild(1).getKey(0)));
        assertEquals(Optional.of(100), Optional.ofNullable(bTree.getRoot().getChild(1).getKey(1)));
    }
}
