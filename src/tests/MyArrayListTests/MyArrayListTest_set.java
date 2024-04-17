package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_set {
    @Test
    public void testSet_Index0ToEmptyList_ReturnsNewIndexOutOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.set(0, null));
    }
    @Test
    public void testSet_IndexEqualsSize_ReturnsNewIndexOutOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.set(1, null));
    }
    @Test
    public void testSet_IndexBiggerThenSize_ReturnsNewIndexOutOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.set(2, null));
    }
    @Test
    public void testSet_NegativeIndex_ReturnsNewIndexOutOfBoundsException(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        assertThrows(IndexOutOfBoundsException.class, ()-> testList.set(-1, null));
    }
    @Test
    public void testSet_ChangeNullElementAtStart_ReturnsNewElement(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.set(0, 111);

        Integer[] arrayToCompare = new Integer[10];
        arrayToCompare[0] = 111;

        assertEquals(111, testList.get(0));
        assertTrue(testList.contains(111));
        assertArrayEquals(arrayToCompare, testList.getArray());
    }
    @Test
    public void testSet_ChangeLastElement_ReturnsNewElement(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.add(111);
        testList.set(1, 111);

        Integer[] arrayToCompare = new Integer[10];
        arrayToCompare[0] = null;
        arrayToCompare[1] = 111;

        assertEquals(111, testList.get(1));
        assertTrue(testList.contains(111));
        assertArrayEquals(arrayToCompare, testList.getArray());
    }
    @Test
    public void testSet_ChangeMiddleElement_ReturnsNewElement(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(null);
        testList.add(111);
        testList.add(222);
        testList.set(1, 333);

        Integer[] arrayToCompare = new Integer[10];
        arrayToCompare[0] = null;
        arrayToCompare[1] = 333;
        arrayToCompare[2] = 222;

        assertEquals(333, testList.get(1));
        assertTrue(testList.contains(333));
        assertFalse(testList.contains(111));
        assertArrayEquals(arrayToCompare, testList.getArray());

    }
}
