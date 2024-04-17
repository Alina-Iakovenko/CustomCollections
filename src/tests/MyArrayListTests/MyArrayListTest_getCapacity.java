package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_getCapacity {
    @Test
    public void testGetCapacity_EmptyList_Returns10() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(10, testList1.getCapacity());
    }
    @Test
    public void testGetCapacity_OneELement_Returns10() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(111);
        assertEquals(10, testList1.getCapacity());
    }
    @Test
    public void testGetCapacity_EnlargedCapacity_Returns15() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        testList1.add(4);
        testList1.add(5);
        testList1.add(6);
        testList1.add(7);
        testList1.add(8);
        testList1.add(9);
        assertEquals(15, testList1.getCapacity());
    }

    @Test
    public void testGetCapacity_EnlargedCapacityWithNullElements_Returns15() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        testList1.add(4);
        testList1.add(5);
        testList1.add(6);
        testList1.add(7);
        testList1.add(null);
        testList1.add(null);
        assertEquals(15, testList1.getCapacity());
    }
}
