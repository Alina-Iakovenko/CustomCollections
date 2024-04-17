package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_addWithoutIndex {
    @Test
    public void testAddWithoutIndex_AddThreeIntegersForCapacityTen_ReturnsListWithThreeIntegers() {
        Integer[] arrayToCheck1 = new Integer[10];
        arrayToCheck1[0] = 111;
        arrayToCheck1[1] = 222;
        arrayToCheck1[2] = 333;

        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(111);
        testList1.add(222);
        testList1.add(333);
        assertArrayEquals(arrayToCheck1, testList1.getArray());
    }
    @Test
    public void testAddWithoutIndex_AddMoreThenCapacityIntegers_ReturnsListWithThreeIntegers() {
        MyArrayList<Integer> testList2 =  new MyArrayList<>(3);
        testList2.add(111);
        testList2.add(-222);
        testList2.add(333);
        testList2.add(0);
        testList2.add(555);

        Integer[] arrayToCheck2 = new Integer[8];
        arrayToCheck2[0] = 111;
        arrayToCheck2[1] = -222;
        arrayToCheck2[2] = 333;
        arrayToCheck2[3] = 0;
        arrayToCheck2[4] = 555;
        assertArrayEquals(arrayToCheck2, testList2.getArray());
    }
}
