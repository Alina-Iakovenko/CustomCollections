package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_contains {
    @Test
    public void testContains_EmptyListContainsNull_ReturnsTrue() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertTrue(testList1.contains(null));
    }
    @Test
    public void testContains_EmptyListContainsElement_ReturnsFalse() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertFalse(testList1.contains(5));
    }
    @Test
    public void testContains_ListWithCapacityNotSetAtStartContainsElements_ReturnsTrue() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 105; i++) {
            testList1.add(i);
        }
        assertTrue(testList1.contains(5));
        assertTrue(testList1.contains(104));
        assertTrue(testList1.contains(0));
        assertTrue(testList1.contains(Integer.parseInt("5")));
    }
    @Test
    public void testContains_ListWithCapacityNotSetAtStartContainsNull_ReturnsTrue() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 105; i++) {
            testList1.add(i);
        }
        assertTrue(testList1.contains(null));
    }
    @Test
    public void testContains_ListWithCapacityNotSetAtStartHaveNotElement_ReturnsTrue() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = 0; i < 105; i++) {
            testList1.add(i);
        }
        assertFalse(testList1.contains(105));
        assertFalse(testList1.contains(-5));
    }
    @Test
    public void testContains_ContainsString_ReturnsTrue() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        testList2.add("3");
        assertTrue(testList2.contains("abc"));
        assertTrue(testList2.contains("3"));
        assertTrue(testList2.contains(String.valueOf(3)));
    }
    @Test
    public void testContains_DoesNotContainString_ReturnsFalse() {
        MyArrayList<String> testList2 = new MyArrayList<>();
        testList2.add("abc");
        testList2.add("3");
        assertFalse(testList2.contains("30"));
        assertFalse(testList2.contains("def"));
        assertFalse(testList2.contains("Abc"));
    }
}
