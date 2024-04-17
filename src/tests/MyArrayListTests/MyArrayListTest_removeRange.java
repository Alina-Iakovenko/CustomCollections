package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_removeRange {
    @Test
    public void testRemoveRange_IndexesOutOfRange_ReturnsFalse() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertFalse(testList1.removeRange(140, 155));
    }
    @Test
    public void testRemoveRange_NegativeIndexes_ReturnsFalse() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertFalse(testList1.removeRange(-5, 5));
    }
    @Test
    public void testRemoveRange_ValidIndexesFromZero_ReturnsTrueAndArrayDoesNotContainsRemovedElements() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -10; i < 10; i++) {
            testList1.add(i);
        }
        assertTrue(testList1.removeRange(0, 3));

        testList1.trimToSize();
        Integer[] arrayToCheck = new Integer[]{-6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(arrayToCheck, testList1.getArray());
    }
    @Test
    public void testRemoveRange_ValidIndexesTillTheLatest_ReturnsTrueAndArrayDoesNotContainsRemovedElements() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -6; i < 10; i++) {
            testList1.add(i);
        }
        assertTrue(testList1.removeRange(10, 15));
        Integer[] arrayToCheck2 = new Integer[]{-6, -5, -4, -3, -2, -1, 0, 1, 2, 3};
        testList1.trimToSize();
        assertArrayEquals(arrayToCheck2, testList1.getArray());

    }
    @Test
    public void testRemoveRange_ExtremeIndexes_ReturnsTrueAndEmptyArrayWithCapacityOfStartList() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -6; i < 4; i++) {
            testList1.add(i);
        }
        assertTrue(testList1.removeRange(0, 9));
        Integer[] arrayToCheck3 = new Integer[15];
        assertArrayEquals(arrayToCheck3, testList1.getArray());
    }
}
