package TestPractica006;

import Practica006.MaxHeap.TreeMaxHeap;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTreeMaxHeap {
    @Test
    public void insert(){
        TreeMaxHeap treeMaxHeap = new TreeMaxHeap(10);
        assertTrue(treeMaxHeap.insert(500));
        assertTrue(treeMaxHeap.insert(10));
        assertTrue(treeMaxHeap.insert(62));
        assertTrue(treeMaxHeap.insert(74));
    }

    @Test
    public void insert_Size(){
        TreeMaxHeap treeMaxHeap = new TreeMaxHeap(10);
        assertEquals(0, treeMaxHeap.getSize());
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
        assertEquals(10, treeMaxHeap.getSize());
    }

    @Test
    public void peekFistTreeMaxHeap(){
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
        assertEquals(500, treeMaxHeap.peekFist());
    }

    @Test
    public void peekFinishTreeMaxHeap(){
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
        assertEquals(8, treeMaxHeap.peekFinish());
    }

    @Test
    public void deleteTreeMaxHeap(){
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
        assertTrue(treeMaxHeap.delete(74));
        String firstValueRemoved = "[500]\n" +
                "[10][62]\n" +
                "[8][10][-6][9]\n" +
                "[-60][-80]\n";
        assertEquals(firstValueRemoved, treeMaxHeap.toString());
        assertTrue(treeMaxHeap.delete(-60));
        String secondValueRemoved = "[500]\n" +
                "[10][62]\n" +
                "[8][10][-6][9]\n" +
                "[-80]\n";
        assertEquals(secondValueRemoved, treeMaxHeap.toString());
        assertTrue(treeMaxHeap.delete(500));
        String thirdValueRemoved = "[62]\n" +
                "[10][9]\n" +
                "[8][10][-6][-80]\n";
        assertEquals(thirdValueRemoved, treeMaxHeap.toString());
    }

    @Test
    public void searchTreeMaxHeap(){
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
        assertTrue(treeMaxHeap.search(74));
        assertFalse(treeMaxHeap.search(100));
    }
}
