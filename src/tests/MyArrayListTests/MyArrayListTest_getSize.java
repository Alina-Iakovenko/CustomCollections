package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_getSize {
    @Test
    public void testGetSize_EmptyList_ReturnsZero() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        assertEquals(0, testList1.getSize());
    }
    @Test
    public void testGetSize_NotEmptyList_ReturnsSize() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        testList1.add(new MyTestClass("object1"));
        testList1.add(new MyTestClass("object2"));
        testList1.add(new MyTestClass("object3"));
        assertEquals(3, testList1.getSize());
    }
    @Test
    public void testGetSize_150SizeList_Returns150() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        for (int i = 0; i < 150; i++) {
            testList1.add(new MyTestClass("object" + i));
        }
        assertEquals(150, testList1.getSize());
    }
    @Test
    public void testGetSize_ListWithNullElement_Returns1() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        testList1.add(null);
        assertEquals(1, testList1.getSize());
    }
    @Test
    public void testGetSize_ListWithNullElements_Returns1() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(1);
        testList1.add(null);
        testList1.add(3);
        testList1.add(null);
        testList1.add(null);
        assertEquals(5, testList1.getSize());
    }
}
