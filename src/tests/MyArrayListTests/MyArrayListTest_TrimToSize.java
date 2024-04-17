package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_TrimToSize {
    @Test
    public void testTrimToSize_EmptyListWithoutSetByParameterCapacity_Returns1() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        testList1.trimToSize();
        assertEquals(1, testList1.getCapacity());
    }

    @Test
    public void testTrimToSize_EmptyListWithBigCapacity_Returns1() {
        MyArrayList<MyTestClass> testList2 = new MyArrayList<MyTestClass>(8975628);
        testList2.trimToSize();
        assertEquals(1, testList2.getCapacity());
    }
    @Test
    public void testTrimToSize_FullList_Returns10() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        testList.trimToSize();
        assertEquals(10, testList.getCapacity());
    }
    @Test
    public void testTrimToSize_FullListWithTheLatestNullElement_Returns10() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        testList.set(9, null);
        testList.trimToSize();
        assertEquals(10, testList.getCapacity());
    }

}
