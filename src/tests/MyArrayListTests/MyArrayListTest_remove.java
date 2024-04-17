package tests.MyArrayListTests;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_remove {
    @Test
    public void testRemove_ElementInMiddle_ReturnElement() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(1, 333);
        assertEquals(333, testList.remove(1));
    }
    @Test
    public void testRemove_TheLatestElement_ReturnElement() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(333);

        assertEquals(333,  testList.remove(2));
    }
    @Test
    public void testRemove_NullElement_ReturnNull() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(0,null);

        assertNull(testList.remove(0));
    }

    @Test
    public void testRemove_NullElementInMiddle_ReturnNull() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(1, null);
        assertNull(testList.remove(1));
    }
    @Test
    public void testRemove_TheLatestNullElement_ReturnNull() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(null);
        assertNull(testList.remove(2));
    }
    @Test
    public void testRemove_TheFirstNullElement_ReturnNullAndArrayWithoutNulls() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(111);
        testList.add(0, 222);
        testList.add(0,null);

        assertNull(testList.remove(0));
    }
    @Test
    public void testRemove_NegativeIndex_ReturnIndexOutOfBoundsException() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.add(0, null);
        testList.add(0,null);
        assertThrows(IndexOutOfBoundsException.class,() -> testList.remove(-1));
    }
    @Test
    public void testRemove_IndexOutOfRange_ReturnIndexOutOfBoundsException() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.add(0, null);
        testList.add(0,null);
        assertThrows(IndexOutOfBoundsException.class,() -> testList.remove(4));
    }
}
