package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_sort {
    @Test
    public void testSort_IntegersInAscendingOrder_ReturnsMyArrayListWithIntegersInAscendingOrder(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(6);
        testList.add(8);
        testList.add(3);
        testList.add(0);
        testList.add(10);

        MyArrayList<Integer> testListToCompare = new MyArrayList<>();
        testListToCompare.add(0);
        testListToCompare.add(3);
        testListToCompare.add(6);
        testListToCompare.add(8);
        testListToCompare.add(10);

        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        testList.sort(integerComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(),testList.getArray());
    }
    @Test
    public void testSort_IntegersInDescendingOrder_ReturnsMyArrayListWithIntegersInDescendingOrder(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(6);
        testList.add(8);
        testList.add(3);
        testList.add(0);
        testList.add(10);

        MyArrayList<Integer> testListToCompare = new MyArrayList<>();
        testListToCompare.add(10);
        testListToCompare.add(8);
        testListToCompare.add(6);
        testListToCompare.add(3);
        testListToCompare.add(0);

        Comparator<Integer> integerComparator = (o1, o2) -> o2 - o1; // == Comparator.reverseOrder()
        testList.sort(integerComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(),testList.getArray());
    }

    @Test
    public void testSort_NullsFirst_ReturnsMyArrayListWithNullsFirstAndThenIntegersInAscendingOrder(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(6);
        testList.add(8);
        testList.add(null);
        testList.add(3);
        testList.add(0);
        testList.add(10);

        MyArrayList<Integer> testListToCompare = new MyArrayList<>();
        testListToCompare.add(null);
        testListToCompare.add(0);
        testListToCompare.add(3);
        testListToCompare.add(6);
        testListToCompare.add(8);
        testListToCompare.add(10);

        Comparator<Integer> integerComparator = Comparator.nullsFirst(Comparator.naturalOrder());
        testList.sort(integerComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(),testList.getArray());
    }
    @Test
    public void testSort_NullsLast_ReturnsMyArrayListWithNullsLastAndThenIntegersInAscendingOrder(){
        MyArrayList<Integer> testList = new MyArrayList<>();
        testList.add(6);
        testList.add(8);
        testList.add(null);
        testList.add(3);
        testList.add(0);
        testList.add(10);

        MyArrayList<Integer> testListToCompare = new MyArrayList<>();
        testListToCompare.add(0);
        testListToCompare.add(3);
        testListToCompare.add(6);
        testListToCompare.add(8);
        testListToCompare.add(10);
        testListToCompare.add(null);

        Comparator<Integer> integerComparator = Comparator.nullsLast(Comparator.naturalOrder());
        testList.sort(integerComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(),testList.getArray());
    }
    @Test
    public void testSort_StringInAscendingOrderWithNull_ReturnsMyArrayListWithIStringInAscendingOrderWithNullAtTheEnd(){
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("Alina");
        testList.add(null);
        testList.add("Daryna");
        testList.add("Daryna");
        testList.add("Andriy");

        MyArrayList<String> testListToCompare = new MyArrayList<>();
        testListToCompare.add("Alina");
        testListToCompare.add("Andriy");
        testListToCompare.add("Daryna");
        testListToCompare.add("Daryna");
        testListToCompare.add(null);

        Comparator<String> stringComparator = Comparator.nullsLast(Comparator.naturalOrder());
        testList.sort(stringComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(),testList.getArray());
    }
    @Test
    public void testSort_MyTestClassInAscendingOrder_ReturnsMyArrayListWithIMyTestClassInAscendingOrder(){
        MyTestClass obj1 = new MyTestClass("test9");
        MyTestClass obj2 = new MyTestClass("test3");
        MyTestClass obj3 = new MyTestClass("test0");
        MyTestClass obj4 = new MyTestClass("test001");

        MyArrayList<MyTestClass> testList = new MyArrayList<>();
        testList.add(obj1);
        testList.add(obj2);
        testList.add(obj3);
        testList.add(obj4);

        MyArrayList<MyTestClass> testListToCompare = new MyArrayList<>();
        testListToCompare.add(obj3);
        testListToCompare.add(obj4);
        testListToCompare.add(obj2);
        testListToCompare.add(obj1);
        Comparator<MyTestClass> myTestClassComparator = new Comparator<MyTestClass>() {
            @Override
            public int compare(MyTestClass o1, MyTestClass o2) {
                return o1.compareTo(o2);
            }
        };
        testList.sort(myTestClassComparator);

        assertEquals(testListToCompare.getSize(), testList.getSize());
        assertEquals(testListToCompare.getCapacity(), testList.getCapacity());
        assertArrayEquals(testListToCompare.getArray(), testList.getArray());
    }

}
