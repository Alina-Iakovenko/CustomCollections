package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_isEmpty {

    @Test
    public void testIsEmpty_NotEmptyList_ReturnsFalse() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(111);
        assertFalse(testList1.isEmpty());
    }
    @Test
    public void testIsEmpty_EmptyList_ReturnsTrue() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertTrue(testList1.isEmpty());
    }
}
