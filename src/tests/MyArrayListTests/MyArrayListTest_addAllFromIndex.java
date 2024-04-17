package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_addAllFromIndex {
    @Test
    public void testAddAllFromIndex_ArrayWithNullToStart_ReturnsValidArray() {
        Integer[] arrayToAdd1 = new Integer[5];
        arrayToAdd1[0] = 111;
        arrayToAdd1[1] = 222;
        arrayToAdd1[4] = 333;
        arrayToAdd1[3] = 444;

        MyArrayList<Integer> testList1 = new MyArrayList<>();
        testList1.add(0, 11);
        testList1.add(1, 22);
        testList1.add(2, 33);
        testList1.add(3, 44);
        testList1.addAllFromIndex(0, arrayToAdd1);

        Integer[] arrayToCheck1 =
                new Integer[]{111, 222, null, 444, 333, 11, 22, 33, 44};
        assertArrayEquals(arrayToCheck1, testList1.getArray());
    }
    @Test
    public void testAddAllFromIndex_ArrayWithNullToMiddle_ReturnsValidArray() {
        Integer[] arrayToAdd1 = new Integer[5];
        arrayToAdd1[0] = 111;
        arrayToAdd1[1] = 222;
        arrayToAdd1[4] = 333;
        arrayToAdd1[3] = 444;

        MyArrayList<Integer> testList2 = new MyArrayList<>();
        testList2.addAllFromIndex(3, arrayToAdd1);
        Integer[] arrayToCheck2 =
                new Integer[]{null, null, null, 111, 222, null, 444, 333};
        assertArrayEquals(arrayToCheck2, testList2.getArray());
    }


    @Test
    public void testAddAllFromIndex__ArrayWithNullToEmptyList_ReturnsValidArray() throws Exception {
        Integer[] arrayToAdd1 = new Integer[5];
        arrayToAdd1[0] = 111;
        arrayToAdd1[1] = 222;
        arrayToAdd1[4] = 333;
        arrayToAdd1[3] = 444;

        MyArrayList<Integer> testList3 = null;
        testList3 = new MyArrayList<>(1);

        testList3.addAllFromIndex(3, arrayToAdd1);
        Integer[] arrayToCheck3 =
                new Integer[]{null, null, null, 111, 222, null, 444, 333};
        assertArrayEquals(arrayToCheck3, testList3.getArray());

    }

}
