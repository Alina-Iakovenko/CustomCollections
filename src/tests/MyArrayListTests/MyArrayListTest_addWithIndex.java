package tests.MyArrayListTests;
import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest_addWithIndex {
    @Test
    public void testAddWithIndex_AddWithNextAndPreviousIndex_ValidList() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(0, 111);
        testList1.add(1, 222);
        testList1.add(2, 333);
        testList1.add(1, 444);

        Integer[] arrayToCheck1 = new Integer[10];
        arrayToCheck1[0] = 111;
        arrayToCheck1[1] = 444;
        arrayToCheck1[2] = 222;
        arrayToCheck1[3] = 333;

        assertArrayEquals(arrayToCheck1, testList1.getArray());
    }
    @Test
    public void testAddWithIndex_NegativeIndex_ThrowsIndexOutOfBoundsException(){
        MyArrayList<Integer> testList2 = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> testList2.add(-1, 111));
    }
    @Test
    public void testAddWithIndex_BeyondCurrentSize_ReturnIndexOfBoundException() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(0, 11);
        testList1.add(1, 22);
        assertThrows(IndexOutOfBoundsException.class, () -> testList1.add(9, 33));
    }
    @Test
    public void testAddWithIndex_AddWithIndexBiggerThenSetCapacity_ValidList() {
        MyArrayList<Integer> testList3 =  new MyArrayList<>(3);
        testList3.add(0, 111);
        testList3.add(1, -222);
        testList3.add(2, 333);
        testList3.add(3, 0);
        testList3.add(4, 555);

        Integer[] arrayToCheck3 = new Integer[8];
        arrayToCheck3[0] = 111;
        arrayToCheck3[1] = -222;
        arrayToCheck3[2] = 333;
        arrayToCheck3[3] = 0;
        arrayToCheck3[4] = 555;
        assertArrayEquals(arrayToCheck3, testList3.getArray());
    }
    @Test
    public void testAddWithIndex_AddTheFirstElementByIndex_ValidList() {
        MyArrayList<Integer> testList4 = new MyArrayList<>();
        testList4.add(0, Integer.valueOf("1"));
        Integer[] arrayToCheck4 = new Integer[10];
        arrayToCheck4[0] = 1;
        assertArrayEquals(arrayToCheck4, testList4.getArray());
    }
}
