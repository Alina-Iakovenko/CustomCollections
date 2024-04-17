package tests.MyArrayListTests;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_indexOf {
    @Test
    public void testIndexOf_EmptyList_ReturnsMinusOne() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(-1, testList1.indexOf(0));
    }    @Test
    public void testIndexOf_ListWithNullElements_ReturnsIndex() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(null);
        testList1.add(null);
        testList1.add(111);

        assertEquals(2, testList1.indexOf(111));
    }
    @Test
    public void testIndexOf_ValidElement_ReturnsIndex() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 189; i++) {
            testList1.add(i);
        }
        assertEquals(188, testList1.indexOf(188));
    }
    @Test
    public void testIndexOf_NotValidElement_ReturnsMinusOne() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 189; i++) {
            testList1.add(i);
        }
        assertEquals(-1, testList1.indexOf(189));
    }
    @Test
    public void testIndexOf_EmptyStringList_ReturnsMinusOne() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        assertEquals(-1, testList2.indexOf("abc"));
    }
    @Test
    public void testIndexOf_ValidString_ReturnsIndex() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        testList2.add("def");
        assertEquals(0, testList2.indexOf("abc"));
        assertEquals(1, testList2.indexOf("def"));
    }
    @Test
    public void testIndexOf_NotValidString_ReturnsMinusOne() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        testList2.add("def");
        assertEquals(-1, testList2.indexOf("aBc"));
    }
}
