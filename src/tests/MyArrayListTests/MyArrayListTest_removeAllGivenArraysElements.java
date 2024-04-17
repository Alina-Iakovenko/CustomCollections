package tests.MyArrayListTests;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_removeAllGivenArraysElements {
    @Test
    public void testRemoveAllGivenArraysElements_ValidInput_ReturnsListWithoutGivenElements() {
        Integer[] arrayToRemove =
                new Integer[]{1, 10, 20, 30, 40, 50, -1, -10, -20, -30, -40, -50, 0, -150, 150};// size = 15

        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -150; i < 151; i++) {
            testList1.add(i);
        }
        assertEquals(15, testList1.removeAllGivenArraysElements(arrayToRemove));
        assertFalse(testList1.contains(0));
        assertFalse(testList1.contains(-150));
    }
    @Test
    public void testRemoveAllGivenArraysElements_DuplicatedElementsInStartList_ReturnsListWithoutGivenElements() {
        Integer[] arrayToRemove =
                new Integer[]{1, 10, 20, 30, 40, 50, -1, -10, -20, -30, -40, -50, 0, -150, 150};// size = 15

        MyArrayList<Integer> testList1 = new MyArrayList<>();

        testList1.add(0, -150);
        testList1.add(1, -150);
        testList1.add(2, 333);
        testList1.add(3, -150);
        assertEquals(3, testList1.removeAllGivenArraysElements(arrayToRemove));
        assertFalse(testList1.contains(-150));
    }
    @Test
    public void testRemoveAllGivenArraysElements_RemoveFromEmptyList_ReturnsZero() {
        Integer[] arrayToRemove =
                new Integer[]{1, 10, 20, 30, 40, 50, -1, -10, -20, -30, -40, -50, 0, -150, 150};// size = 15

        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(0, testList1.removeAllGivenArraysElements(arrayToRemove));
    }
    @Test
    public void testRemoveAllGivenArraysElements_RemoveFromListWithoutGivenElements_ReturnsZero() {
        Integer[] arrayToRemove =
                new Integer[]{1, 10, 20, 30, 40, 50, -1, -10, -20, -30, -40, -50, 0, -150, 150};// size = 15

        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 200; i < 900; i++) {
            testList1.add(i);
        }
        assertEquals(0, testList1.removeAllGivenArraysElements(arrayToRemove));
    }
}
