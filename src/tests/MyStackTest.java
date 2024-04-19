package tests;

import collections.MyStack;
import collections.MyTestClass;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest<E> {
    @Test
    public void testConstructor_ReturnsNotNullMyStack() {
        MyStack<MyTestClass> testStack = new MyStack();
        assertNotNull(testStack);
    }

    // testPush
    @Test
    public void testPush_NullObject_ReturnsFalse() {
        MyStack<Integer> testStack = new MyStack();
        assertThrows(IllegalArgumentException.class, ()->testStack.push(null));
    }

    @Test
    public void testPush_ObjectToEmptyList_ReturnsTrueAndListWithHeadEqualsTail() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        assertEquals(111, testStack.peekFirst());
        assertEquals(111, testStack.peekLast());
    }

    @Test
    public void testPush_ObjectToListWithOneElement_ReturnsTrue() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        assertEquals(111, testStack.peekFirst());
        assertEquals(222, testStack.peekLast());
    }

    @Test
    public void testPush_Object_ReturnsTrue() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        assertEquals(111, testStack.peekFirst());
        assertEquals(333, testStack.peekLast());
        assertTrue(testStack.contains(222));
    }



    // testPeekFirst
    @Test
    public void testPeekFirst_EmptyList_ReturnsNull() {
        MyStack<Integer> testStack = new MyStack();
        assertNull(testStack.peekFirst());
    }

    @Test
    public void testPeekFirst_Element_ReturnsTheFirstElement() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertEquals(111, testStack.peekFirst());
    }



    // testGetLast
    @Test
    public void testPeekLast_EmptyList_ReturnsNull() {
        MyStack<Integer> testStack = new MyStack();
        assertNull(testStack.peekLast());
    }

    @Test
    public void testPeekLast_Element_ReturnsTheLatestElement() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertEquals(555, testStack.peekLast());
    }


    // testContains
    @Test
    public void testContain_ElementInEmptyList_ReturnsNull() {
        MyStack<Integer> testStack = new MyStack();
        assertFalse(testStack.contains(111));
    }

    @Test
    public void testContain_NullElement_ReturnsNull() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertFalse(testStack.contains(null));
    }

    @Test
    public void testContain_ElementEqualsHead_ReturnsElement() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertTrue(testStack.contains(111));
    }

    @Test
    public void testContain_Element_ReturnsElement() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertTrue(testStack.contains(333));
    }

    @Test
    public void testContain_ElementEqualsTail_ReturnsElement() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertTrue(testStack.contains(555));
    }



    //testPop
    @Test
    public void testPop_EmptyList_ReturnsIndexOutOfBoundsException() {
        MyStack<Integer> testStack = new MyStack();
        assertThrows(IndexOutOfBoundsException.class, testStack::pop);
    }

    @Test
    public void testRemoveFirst_Element_ReturnsTheFirstElementAndShorterList() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertEquals(555, testStack.pop());
        assertEquals(111, testStack.peekFirst());
        assertEquals(444, testStack.peekLast());
    }

    @Test
    public void testPop_ElementFrom1ElementLongList_ReturnsTheFirstElementAndEmptyList() {
        MyStack<Integer> testStack = new MyStack();
        testStack.push(111);
        assertEquals(111, testStack.pop());
        assertNull(testStack.peekFirst());
        assertNull(testStack.peekLast());
    }


    //testSize
    @Test
    public void testSize_EmptyList_ReturnZero() {
        MyStack<Integer> testStack = new MyStack<>();
        assertEquals(0, testStack.size());
    }

    @Test
    public void testSize_1ElementLongList_ReturnOne() {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(1);
        assertEquals(1, testStack.size());
    }

    @Test
    public void testSize_1002LongList_ReturnZero() {
        MyStack<Integer> testStack = new MyStack<>();
        for (int i = 0; i < 1002; i++) {
            testStack.push(i);
        }
        assertEquals(1002, testStack.size());
    }

    //testToArray
    @Test
    public void testToArray_List_ReturnsValidArray() {
        MyStack<Integer> testStack = new MyStack<>();
        for (int i = 0; i < 1002; i++) {
            testStack.push(i);
        }

        Integer[] checkingArray = new Integer[1002];
        for (int i = 0; i < 1002; i++) {
            checkingArray[i] = i;
        }
        assertArrayEquals(checkingArray, testStack.toArray());
    }
    @Test
    public void testToArray_EmptyList_ReturnsEmptyArray() {
        MyStack<Integer> testStack = new MyStack<>();

        Integer[] checkingArray = new Integer[0];

        assertArrayEquals(checkingArray, testStack.toArray());
    }

    //testToString
    @Test
    public void testToString_EmptyList_ReturnsNoElements(){
        MyStack<String> testStack = new MyStack<>();
        assertEquals("MyStack: ", testStack.toString());
    }
    @Test
    public void testToString_ListWith3Elements_ReturnsStringWith3Elements(){
        MyStack<String> testStack = new MyStack<>();
        testStack.push("test1");
        testStack.push("test2");
        testStack.push("test3");
        assertEquals("MyStack: test1, test2, test3", testStack.toString());
    }

    @Test
    public void testToString_ListWithCustomObject_ReturnsStringWithObject(){
        MyStack<MyTestClass> testStack = new MyStack<>();
        testStack.push(new MyTestClass("ObjectOfMyTestClass"));
        assertEquals("MyStack: ObjectOfMyTestClass", testStack.toString());
    }

    @Test
    public void testToString_ListWithCustomObjectWithoutString_ReturnsStringWithObject(){
        MyStack<MyTestClass> testStack = new MyStack<>();
        testStack.push(new MyTestClass());
        assertEquals("MyStack: testClassObject", testStack.toString());
    }

    //testIterator
    @Test
    public void testIterator_ReturnsNewIterator() {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(111);
        testStack.push(222);
        testStack.push(333);
        testStack.push(444);
        testStack.push(555);
        assertNotNull(testStack.iterator());
    }

    @Test
    public void testIterator_forEach() {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(4);

        int sum = 0;
        for (Integer element : testStack) {
            sum += element;
        }
        assertEquals(10, sum);
    }

    @Test
    public <E> void testIteratorHasNext_EmptyList_ReturnsFalse() {
        MyStack<Integer> testStack = new MyStack<>();
        assertFalse(() -> testStack.iterator().hasNext());
    }

    @Test
    public <E> void testIteratorNext_EmptyList_ReturnsNoSuchElementException() {
        MyStack<Integer> testStack = new MyStack<>();
        assertThrows(NoSuchElementException.class, () -> testStack.iterator().next());
    }

    @Test
    public <E> void testIteratorNext_OneElementLongList_ReturnsElement() {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(111);
        assertEquals(111, testStack.iterator().next());
    }

    @Test
    public void testIteratorNext_TwoElementLongListDoubleCallIterator_ReturnsElements() {
        MyStack<Integer> testStack = new MyStack<>();
        testStack.push(111);
        testStack.push(222);
        MyStack<Integer>.IteratorForStack iterator = testStack.iterator();
        assertEquals(111, iterator.next());
        assertEquals(222, iterator.next());
    }
}
