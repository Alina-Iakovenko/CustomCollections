package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_constructorWithSetCapacity {
    @Test
    public void testConstructorWithSetCapacity_ReturnsEmptyIntegerList() {
        MyArrayList<Integer> testList1 = new MyArrayList<Integer>(5);
        assertEquals(testList1.getSize(), 0);
        assertEquals(testList1.getCapacity(), 5);
        assertNotNull(testList1.getArray());

        Object[] testArrayFromList1 = testList1.getArray();
        assertEquals(5, testArrayFromList1.length);
        for (Object o : testArrayFromList1) {
            assertNull(o);
        }
    }
    @Test
    public void testConstructorWithSetCapacity_ReturnsEmptyStringList() {
        MyArrayList<String> testList2 = new MyArrayList<String>(15);
        assertEquals(testList2.getSize(), 0);
        assertEquals(testList2.getCapacity(), 15);
        assertNotNull(testList2.getArray());

        Object[] testArrayFromList2 = testList2.getArray();
        assertEquals(15, testArrayFromList2.length);
        for (Object o : testArrayFromList2) {
            assertNull(o);
        }
    }
    @Test
    public void testConstructorWithSetCapacity_ReturnsEmptyMyTestClassList() {
        MyArrayList<MyTestClass> testList3 = new MyArrayList<MyTestClass>(8975628);
        assertEquals(testList3.getSize(), 0);
        assertEquals(testList3.getCapacity(), 8975628);
        assertNotNull(testList3.getArray());

        Object[] testArrayFromList3 = testList3.getArray();
        assertEquals(8975628, testArrayFromList3.length);
        for (Object o : testArrayFromList3) {
            assertNull(o);
        }
    }
    @Test
    public void testConstructorWithSetCapacity_WithNegativeCapacity_ReturnsRuntimeException() {
        assertThrows(RuntimeException.class, () -> new MyArrayList<MyTestClass>(-1));
    }
    @Test
    public void testConstructorWithSetCapacity_WithZeroCapacity_ReturnsRuntimeException() {
        assertThrows(Exception.class, () -> new MyArrayList<MyTestClass>(0));
    }
}
