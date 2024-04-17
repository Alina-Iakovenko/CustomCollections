package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_removeNullElements {
    @Test
    public void testRemoveNullElements_NullElementInMiddle_ReturnArrayWithoutNulls() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(1, null);
        testList.removeNullElements();

        Integer[] arrayToCheck = new Integer[]{222, 111};
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
    @Test
    public void testRemoveNullElements_TheLatesNullElement_ReturnArrayWithoutNulls() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(null);
        testList.removeNullElements();

        Integer[] arrayToCheck = new Integer[]{222, 111};
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
    @Test
    public void testRemoveNullElements_TheFirstNullElement_ReturnArrayWithoutNulls() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(0,null);
        testList.removeNullElements();

        Integer[] arrayToCheck = new Integer[]{222, 111};
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
    @Test
    public void testRemoveNullElements_AllNullElement_ReturnArrayWithoutNulls() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.add(0, null);
        testList.add(0,null);
        testList.removeNullElements();

        Integer[] arrayToCheck = new Integer[]{};
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
}
