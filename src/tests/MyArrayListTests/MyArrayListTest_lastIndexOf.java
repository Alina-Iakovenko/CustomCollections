package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_lastIndexOf {
    @Test
    public void testLastIndexOf_EmptyList_ReturnsMinusOne() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(-1, testList1.lastIndexOf(0));
    }

    @Test
    public void testLastIndexOf_ValidElement_ReturnsIndex() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 189; i++) {
            testList1.add(i);
        }
        assertEquals(0, testList1.lastIndexOf(0));
        assertEquals(20, testList1.lastIndexOf(20));
        assertEquals(188, testList1.lastIndexOf(188));
    }

    @Test
    public void testLastIndexOf_NotValidElement_ReturnsMinusOne() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(-1, testList1.lastIndexOf(189));

    }

    @Test
    public void testIndexOf_EmptyStringList_ReturnsMinusOne() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        assertEquals(-1, testList2.lastIndexOf("abc"));
    }

    @Test
    public void testLastIndexOf_ValidString_ReturnsIndex() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        testList2.add("def");
        testList2.add("abc");
        testList2.add("def");
        testList2.add("def");
        testList2.add(3, null);
        testList2.add("def");
        assertEquals(2, testList2.lastIndexOf("abc"));
        assertEquals(6, testList2.lastIndexOf("def"));
    }

}
