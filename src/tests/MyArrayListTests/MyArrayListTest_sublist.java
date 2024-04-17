package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class MyArrayListTest_sublist {
    @Test
    public void testSublist_FromIndexOutOfRange_ReturnsIndexOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.subList(-1,5));
    }
    @Test
    public void testSublist_ToIndexOutOfRange_ReturnsIndexOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.subList(5,10));
    }
    @Test
    public void testSublist_FromIndexEqualsToIndex_ReturnsIndexOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.subList(5,5));
    }

    @Test
    public void testSublist_ValidIndexesInTheMiddleOfTheList_ReturnSublist(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 100; i < 110; i++) {
            testList.add(i);
        }
        MyArrayList<Integer> listToCheck = new MyArrayList<>(3);
        listToCheck.add(102);
        listToCheck.add(103);
        listToCheck.add(104);
        MyArrayList<Integer> sublistToCheck = testList.subList(2,4);

        assertNotNull(sublistToCheck);
        assertEquals(3, sublistToCheck.getSize());
        assertEquals(3, sublistToCheck.getCapacity());
        assertArrayEquals(listToCheck.getArray(), sublistToCheck.getArray());
    }

    @Test
    public void testSublist_ValidIndexesInTheMiddleForNullElement_ReturnSublistWithNullElement(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 100; i < 110; i++) {
            testList.add(i);
        }
        testList.set(3, null);
        MyArrayList<Integer> listToCheck = new MyArrayList<>(3);
        listToCheck.add(102);
        listToCheck.add(null);
        listToCheck.add(104);
        MyArrayList<Integer> sublistToCheck = testList.subList(2,4);

        assertNotNull(sublistToCheck);
        assertEquals(3, sublistToCheck.getSize());
        assertEquals(3, sublistToCheck.getCapacity());
        assertArrayEquals(listToCheck.getArray(), sublistToCheck.getArray());
    }

    @Test
    public void testSublist_ValidIndexesBetweenNullElements_ReturnSublist(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 100; i < 110; i++) {
            testList.add(i);
        }
        testList.set(1, null);
        testList.set(3, null);
        testList.set(5, null);

        MyArrayList<Integer> listToCheck = new MyArrayList<>(3);
        listToCheck.add(102);
        listToCheck.add(null);
        listToCheck.add(104);
        MyArrayList<Integer> sublistToCheck = testList.subList(2,4);

        assertNotNull(sublistToCheck);
        assertEquals(3, sublistToCheck.getSize());
        assertEquals(3, sublistToCheck.getCapacity());
        assertArrayEquals(listToCheck.getArray(), sublistToCheck.getArray());
    }

    @Test
    public void testSublist_ValidextremeIndexes_ReturnSublist(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 100; i < 103; i++) {
            testList.add(i);
        }
        MyArrayList<Integer> listToCheck = new MyArrayList<>(3);
        listToCheck.add(100);
        listToCheck.add(101);
        listToCheck.add(102);
        MyArrayList<Integer> sublistToCheck = testList.subList(0,2);

        assertNotNull(sublistToCheck);
        assertEquals(3, sublistToCheck.getSize());
        assertEquals(3, sublistToCheck.getCapacity());
        assertArrayEquals(listToCheck.getArray(), sublistToCheck.getArray());
    }
}
