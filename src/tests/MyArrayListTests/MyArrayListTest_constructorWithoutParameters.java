package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_constructorWithoutParameters {
    @Test
    public void testConstructorWithoutParameter_ReturnsEmptyIntegerList() {
        MyArrayList<Integer> testList1 = new MyArrayList();
        assertEquals(testList1.getSize(), 0);
        assertEquals(testList1.getCapacity(), 10);
        assertNotNull(testList1.getArray());

        Object[] testArrayFromList1 = testList1.getArray();
        assertEquals(10, testArrayFromList1.length);
        for (Object object : testArrayFromList1) {
            assertNull(object);
        }
    }
    @Test
    public void testConstructorWithoutParameter_ReturnsEmptyStringList() {
        MyArrayList<String> testList2 = new MyArrayList<String>();
        assertEquals(testList2.getSize(), 0);
        assertEquals(testList2.getCapacity(), 10);
        assertNotNull(testList2.getArray());

        Object[] testArrayFromList2 = testList2.getArray();
        assertEquals(10, testArrayFromList2.length);
        for (Object object : testArrayFromList2) {
            assertNull(object);
        }
    }

    @Test
    public void testConstructorWithoutParameter_ReturnsEmptyMyTestClassList() {
        MyArrayList<MyTestClass> testList3 = new MyArrayList<MyTestClass>();
        assertEquals(testList3.getSize(), 0);
        assertEquals(testList3.getCapacity(), 10);
        assertNotNull(testList3.getArray());

        Object[] testArrayFromList3 = testList3.getArray();
        assertEquals(10, testArrayFromList3.length);
        for (Object o : testArrayFromList3) {
            assertNull(o);
        }
    }
}
