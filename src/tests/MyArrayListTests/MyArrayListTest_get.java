package tests.MyArrayListTests;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_get {
    @Test
    public void testGet_ElementFromEmptyList_ReturnsIndexOfBoundsException() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> testList1.get(0));
    }
    @Test
    public void testGet_ValidIndex_ReturnsElement() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 189; i++) {
            testList1.add(i);
        }
        assertEquals(0, testList1.get(0));
        assertEquals(20, testList1.get(20));
        assertEquals(188, testList1.get(188));
    }
    @Test
    public void testGet_IndexOutOfRange_ReturnsIndexOutOfBoundsException() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 189; i++) {
            testList1.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> testList1.get(189));
    }
    @Test
    public void testGet_ValidIndexForStringList_ReturnsString() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        assertEquals("abc", testList2.get(0));
    }

}
