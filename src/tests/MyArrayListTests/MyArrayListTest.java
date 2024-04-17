package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

    @Test
    public void testEndToEnd() {
        MyArrayList<MyTestClass> testList1 = new MyArrayList<>();
        assertEquals(0, testList1.getSize());
        MyTestClass object1 = new MyTestClass("object1");
        MyTestClass object2 = new MyTestClass("object2");

        testList1.add(object1);
        testList1.add(object2);
        testList1.add(new MyTestClass("object3"));
        assertEquals(3, testList1.getSize());

        MyArrayList<MyTestClass>.IteratorMAL iterator = testList1.new IteratorMAL();
        while (iterator.hasNext()) {
            if (iterator.next().equals(object1)) {
                iterator.remove();
            }
        }
        assertFalse(testList1.contains(object1));
        assertTrue(testList1.contains(object2));

        testList1.set(0, object1);
        assertTrue(testList1.contains(object1));

        for (int i = 0; i < 150; i++) {
            testList1.add(new MyTestClass("object" + i));
        }
        assertEquals(152, testList1.getSize());

        testList1.add(5, new MyTestClass("objectAddedWithIndex"));
        assertEquals(153, testList1.getSize());

        testList1.set(152, new MyTestClass("objectSet"));
        assertEquals(153, testList1.getSize());

        MyTestClass objectToRemove = new MyTestClass();
        testList1.add(15, objectToRemove);
        assertEquals(154, testList1.getSize());

        testList1.removeObject(objectToRemove);
        assertEquals(153, testList1.getSize());

        assertTrue(testList1.removeRange(1, 152));
        assertEquals(1, testList1.getSize());// indexes 0-9

        MyTestClass objectToRemoveWithAll = new MyTestClass("testObjectToRemove");
        testList1.add(objectToRemoveWithAll); // size 11
        assertEquals(2, testList1.getSize());

        MyTestClass[] arrayToCheck = new MyTestClass[3];
        arrayToCheck[0] = objectToRemove; // isn`t in testList1
        arrayToCheck[1] = objectToRemoveWithAll; // size 10
        arrayToCheck[2] = new MyTestClass("object1"); // isn`t in testList1
        testList1.removeAllGivenArraysElements(arrayToCheck);
        assertEquals(1, testList1.getSize());

        testList1.removeAllGivenArraysElements(arrayToCheck);
        assertEquals(1, testList1.getSize());

        testList1.add(0, objectToRemove);
        testList1.add(null);
        assertEquals(3, testList1.getSize());

        testList1.removeNullElements();
        assertEquals(2, testList1.getSize());

        testList1.clear();
        assertEquals(0, testList1.getSize());
//
//        testList1.add(new MyTestClass("object1"));
//        testList1.add(new MyTestClass("object2"));
//        testList1.add(new MyTestClass("object3"));
//
//        MyArrayList<MyTestClass>.IteratorMAL iterator = testList1.new IteratorMAL();
//        if(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}
