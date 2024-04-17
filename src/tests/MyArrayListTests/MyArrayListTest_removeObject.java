package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_removeObject {
    @Test
    public void testRemoveObject_DublicatedElements_ReturnsQuantityOfRemovedObjects() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(222);
        testList1.add(0, 222);
        assertEquals(2, testList1.removeObject(222));
    }
    @Test
    public void testRemoveObject_ValidObject_ReturnsOne() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -150; i < 150; i++) {
            testList1.add(i);
        }
        assertEquals(1, testList1.removeObject(-150));
    }
    @Test
    public void testRemoveObject_NotValidObject_ReturnsZero() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        for (int i = -150; i < 150; i++) {
            testList1.add(i);
        }
        assertEquals(0, testList1.removeObject(150));
    }
}
