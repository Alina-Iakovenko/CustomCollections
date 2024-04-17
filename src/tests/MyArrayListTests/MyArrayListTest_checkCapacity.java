package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class MyArrayListTest_checkCapacity {

    @Test
    public void testCheckCapacity_EmptyListAfterConstructorWithoutParameters_ReturnsTen() {
        MyArrayList<Integer> testList1 = new MyArrayList<>();
        assertEquals(10, testList1.getCapacity());
    }
    @Test
    public void testCheckCapacity_EmptyListAfterConstructorWithParameter_ReturnsFive() {
        MyArrayList<Integer> testList4 = new MyArrayList<Integer>(5);
        assertEquals(5, testList4.getCapacity());
    }
    @Test
    public void testCheckCapacity_EmptyListAfterConstructorWithParameter_Returns8975628() {
        MyArrayList<String> testList5 = new MyArrayList<String>(8975628);
        assertEquals(8975628, testList5.getCapacity());
    }

    @Test
    public void testCheckCapacity_EnlargedCapacity_Returns15() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        assertEquals(15, testList.getCapacity());
    }
    @Test
    public void testCheckCapacity_EnlargedCapacityAfterNullElements_Returns15() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(null);
        }
        assertEquals(15, testList.getCapacity());
    }
}
