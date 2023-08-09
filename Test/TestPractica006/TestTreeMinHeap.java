package TestPractica006;

import Practica006.MaxHeap.TreeMaxHeap;
import Practica006.MinHeap.TreeMinHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTreeMinHeap {

    @Test
    public void insert(){
        TreeMinHeap treeMinHeap = new TreeMinHeap(10);
        assertTrue(treeMinHeap.insert(3));
        assertTrue(treeMinHeap.insert(1));
        assertTrue(treeMinHeap.insert(2));
        assertTrue(treeMinHeap.insert(80));
        assertTrue(treeMinHeap.insert(51));
        assertTrue(treeMinHeap.insert(70));
        assertTrue(treeMinHeap.insert(-10));
        assertTrue(treeMinHeap.insert(50));
        assertTrue(treeMinHeap.insert(4));
    }

    @Test
    public void insert_Size(){
        TreeMinHeap treeMinHeap = new TreeMinHeap(10);
        assertEquals(0, treeMinHeap.getSize());
        treeMinHeap.insert(3);
        treeMinHeap.insert(1);
        treeMinHeap.insert(2);
        treeMinHeap.insert(80);
        treeMinHeap.insert(51);
        treeMinHeap.insert(70);
        treeMinHeap.insert(-10);
        treeMinHeap.insert(50);
        treeMinHeap.insert(4);
        assertEquals(9, treeMinHeap.getSize());
    }

    @Test
    public void peekFistTreeMinHeap(){
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
        assertEquals(-10, treeMinHeap.peekFist());
    }

    @Test
    public void peekFinishTreeMinHeap(){
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
        assertEquals(50, treeMinHeap.peekFinish());
    }

    @Test
    public void deleteTreeMaxHeap(){
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

        assertTrue(treeMinHeap.delete(80));
        String firstValueRemoved = "[-10]\n" +
                "[3][1]\n" +
                "[4][51][70][2]\n" +
                "[50]\n";
        assertEquals(firstValueRemoved, treeMinHeap.toString());

        assertTrue(treeMinHeap.delete(70));
        String secondValueRemoved = "[-10]\n" +
                "[3][1]\n" +
                "[4][51][50][2]\n";
        assertEquals(secondValueRemoved, treeMinHeap.toString());

        assertTrue(treeMinHeap.delete(50));
        String thirdValueRemoved = "[-10]\n" +
                "[3][1]\n" +
                "[4][51][2]\n";
        assertEquals(thirdValueRemoved, treeMinHeap.toString());
    }

    @Test
    public void searchTreeMaxHeap(){
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
        assertTrue(treeMinHeap.search(50));
        assertFalse(treeMinHeap.search(30));
    }
}
