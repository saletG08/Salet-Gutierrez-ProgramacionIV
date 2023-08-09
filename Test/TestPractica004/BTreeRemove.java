package TestPractica004;

import Practica004.BTree;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class BTreeRemove {
    @Test
    public void remove(){
        BTree<Integer> bTree = new BTree<>(3);
        bTree.add(1);
        bTree.add(2);
        bTree.add(3);
        bTree.add(4);
        bTree.add(5);
        bTree.add(6);
        bTree.add(7);
        bTree.add(8);
        bTree.add(9);
        bTree.add(10);
        assertEquals(Optional.of(1), Optional.ofNullable(bTree.remove(1)));
        assertEquals(9, bTree.getSizeNode());
    }

    @Test
    public void remove_ThreeElementsOrder3() {
        BTree<Integer> bTree = new BTree<>(3);
        bTree.add(8);
        bTree.add(5);
        bTree.add(12);
        assertEquals(Optional.of(8), Optional.ofNullable(bTree.getRoot().removeKey(0)));
        assertEquals(Optional.of(5), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(12), Optional.ofNullable(bTree.getRoot().getChild(1).removeKey(0)));
    }

    @Test
    public void remove_FiveElementsOrder3() {
        BTree<Integer> bTree = new BTree<>(3);
        bTree.add(3);
        bTree.add(2);
        bTree.add(6);
        bTree.add(7);
        bTree.add(1);
        assertEquals(Optional.of(3), Optional.ofNullable(bTree.getRoot().removeKey(0)));
        assertEquals(Optional.of(1), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(2), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(6), Optional.ofNullable(bTree.getRoot().getChild(1).removeKey(0)));
        assertEquals(Optional.of(7), Optional.ofNullable(bTree.getRoot().getChild(1).removeKey(0)));
    }

    @Test
    public void remove_ThreeElementsOrder4() {
        BTree<Integer> bTree = new BTree<>(4);
        bTree.add(70);
        bTree.add(40);
        bTree.add(110);
        assertEquals(Optional.of(40), Optional.ofNullable(bTree.getRoot().removeKey(0)));
        assertEquals(Optional.of(70), Optional.ofNullable(bTree.getRoot().removeKey(0)));
        assertEquals(Optional.of(110), Optional.ofNullable(bTree.getRoot().removeKey(0)));
    }

    @Test
    public void remove_SixElementsOrder5() {
        BTree<Integer> bTree = new BTree<>(5);
        bTree.add(50);
        bTree.add(20);
        bTree.add(90);
        bTree.add(100);
        bTree.add(10);
        bTree.add(30);
        assertEquals(Optional.of(50), Optional.ofNullable(bTree.getRoot().removeKey(0)));
        assertEquals(Optional.of(10), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(20), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(30), Optional.ofNullable(bTree.getRoot().getChild(0).removeKey(0)));
        assertEquals(Optional.of(90), Optional.ofNullable(bTree.getRoot().getChild(1).removeKey(0)));
        assertEquals(Optional.of(100), Optional.ofNullable(bTree.getRoot().getChild(1).removeKey(0)));
    }
}
