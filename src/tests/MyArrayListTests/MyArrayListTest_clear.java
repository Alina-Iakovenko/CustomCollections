package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_clear {
    @Test
    public void testClear_FullList_ReturnsEmptyListWithZeroSizeAnd10Capacity() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 998; i++) {
            testList1.add(i);
        }
        testList1.clear();
        Object[] testArrayFromList1 = testList1.getArray();
        for (Object object : testArrayFromList1) {
            assertNull(object);
        }
        assertEquals(0, testList1.getSize());
        assertEquals(10, testList1.getCapacity());
    }
    @Test
    public void testClear_EmptyList_ReturnsEmptyListWithZeroSizeAnd10Capacity() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.clear();
        Object[] testArrayFromList = testList.getArray();
        for (Object object : testArrayFromList) {
            assertNull(object);
        }
        assertEquals(0, testList.getSize());
        assertEquals(10, testList.getCapacity());
    }
    @Test
    public void testClear_ListWithOneElementAnd100Capacity_ReturnsEmptyListWithZeroSizeAnd10Capacity() {
        MyArrayList<Integer> testList = new MyArrayList<>(100);
        testList.add(0, 111);
        testList.clear();
        Object[] testArrayFromList = testList.getArray();
        for (Object object : testArrayFromList) {
            assertNull(object);
        }
        assertEquals(0, testList.getSize());
        assertEquals(10, testList.getCapacity());
    }
}
