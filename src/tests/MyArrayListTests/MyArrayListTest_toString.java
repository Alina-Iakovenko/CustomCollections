package tests.MyArrayListTests;

import collections.MyArrayList;
import collections.MyTestClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_toString {
    @Test
    public void testToString_EmptyList_ReturnsNoElements(){
        MyArrayList<String> testList = new MyArrayList<>();
        assertEquals("MyArrayList: ", testList.toString());
    }
    @Test
    public void testToString_EmptyListWithSettedCapacity_ReturnsNoElements(){
        MyArrayList<String> testList = new MyArrayList<>(5);
        assertEquals("MyArrayList: ", testList.toString());
    }
    @Test
    public void testToString_ListWith3Elements_ReturnsStringWith3Elements(){
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add("test3");
        assertEquals("MyArrayList: test1, test2, test3", testList.toString());
    }
    @Test
    public void testToString_ListWithTheFirstNull_ReturnsStringWithNullAnd2Elements(){
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add(null);
        testList.add("test2");
        testList.add("test3");
        assertEquals("MyArrayList: null, test2, test3", testList.toString());
    }
    @Test
    public void testToString_ListWithTheLatestNull_ReturnsStringWith2ElementsAndNull(){
        MyArrayList<String> testList = new MyArrayList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add(null);
        assertEquals("MyArrayList: test1, test2, null", testList.toString());
    }
    @Test
    public void testToString_ListWithCustomObject_ReturnsStringWithObject(){
        MyArrayList<MyTestClass> testList = new MyArrayList<>();
        testList.add(new MyTestClass("ObjectOfMyTestClass"));
        assertEquals("MyArrayList: ObjectOfMyTestClass", testList.toString());
    }

    @Test
    public void testToString_ListWithCustomObjectWithoutString_ReturnsStringWithObject(){
        MyArrayList<MyTestClass> testList = new MyArrayList<>();
        testList.add(new MyTestClass());
        assertEquals("MyArrayList: testClassObject", testList.toString());
    }
}
