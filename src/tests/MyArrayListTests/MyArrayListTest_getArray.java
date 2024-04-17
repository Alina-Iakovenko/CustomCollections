package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MyArrayListTest_getArray {
    @Test
    public void testGetArray_EmptyIntegerArray_ReturnsEmptyArray() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        Object[] testArrayFromList1 = testList1.getArray();
        assertNotNull(testArrayFromList1);
        assertEquals(10, testArrayFromList1.length);
        for (Object object : testArrayFromList1) {
            assertNull(object);
        }
    }

    @Test
    public void testGetArray_IntegerArrayWithOneNullElement_ReturnsIntegerArrayWithOneNullElement() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(null);
        Object[] testArrayFromList1 = testList1.getArray();

        assertNotNull(testArrayFromList1);
        assertEquals(10, testArrayFromList1.length);
        assertNull(testArrayFromList1[0]);
    }

    @Test
    public void testGetArray_StringArrayWithOneNullElement_ReturnsStringArrayWithOneNullElement() {
        MyArrayList<String> testList2 = new MyArrayList<String>();
        testList2.add(null);
        assertNotNull(testList2.getArray());
        Object[] testArrayFromList2 = testList2.getArray();
        assertEquals(10, testArrayFromList2.length);
        for (Object object : testArrayFromList2) {
            assertNull(object);
        }
    }

    @Test
    public void testGetArray_MyTestClassArrayWithOneNullElement_ReturnsMyTestClassArrayWithOneNullElement() {
        MyArrayList<MyTestClass> testList3 = new MyArrayList<MyTestClass>();
        testList3.add(null);
        assertNotNull(testList3.getArray());
        Object[] testArrayFromList3 = testList3.getArray();
        assertEquals(10, testArrayFromList3.length);
        for (Object o : testArrayFromList3) {
            assertNull(o);
        }
    }
    @Test
    public void testGetArray_IntegerArray_ReturnsIntegerArray() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        Integer[] arrayToCheck = new Integer[15];
        for (int i = 0; i < 10; i++) {
            arrayToCheck[i] = i;
        }
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
    @Test
    public void testGetArray_IntegerArrayWithNullElements_ReturnsIntegerArrayWithNullElements() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        testList.set(0, null);
        testList.set(4, null);
        testList.set(9, null);
        Integer[] arrayToCheck = new Integer[15];
        for (int i = 0; i < 10; i++) {
            arrayToCheck[i] = i;
        }
        arrayToCheck[0] = null;
        arrayToCheck[4] = null;
        arrayToCheck[9] = null;
        assertArrayEquals(arrayToCheck, testList.getArray());
    }
}
