package tests.MyQueueTests;

import collections.MyQueue;
import collections.MyTestClass;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest<E> {
    @Test
    public void testConstructor_ReturnsNotNullMyQueue() {
        MyQueue<MyTestClass> testQueue = new MyQueue();
        assertNotNull(testQueue);
    }

    // testPush
    @Test
    public void testPush_NullObject_ReturnsFalse() {
        MyQueue<Integer> testQueue = new MyQueue();
        assertThrows(IllegalArgumentException.class, ()->testQueue.push(null));
    }

    @Test
    public void testPush_ObjectToEmptyList_ReturnsTrueAndListWithHeadEqualsTail() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        assertEquals(111, testQueue.peekFirst());
        assertEquals(111, testQueue.peekLast());
    }

    @Test
    public void testPush_ObjectToListWithOneElement_ReturnsTrue() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        assertEquals(111, testQueue.peekFirst());
        assertEquals(222, testQueue.peekLast());
    }

    @Test
    public void testPush_Object_ReturnsTrue() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        assertEquals(111, testQueue.peekFirst());
        assertEquals(333, testQueue.peekLast());
        assertTrue(testQueue.contains(222));
    }



    // testPeekFirst
    @Test
    public void testPeekFirst_EmptyList_ReturnsNull() {
        MyQueue<Integer> testQueue = new MyQueue();
        assertNull(testQueue.peekFirst());
    }

    @Test
    public void testPeekFirst_Element_ReturnsTheFirstElement() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertEquals(111, testQueue.peekFirst());
    }



    // testGetLast
    @Test
    public void testPeekLast_EmptyList_ReturnsNull() {
        MyQueue<Integer> testQueue = new MyQueue();
        assertNull(testQueue.peekLast());
    }

    @Test
    public void testPeekLast_Element_ReturnsTheLatestElement() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertEquals(555, testQueue.peekLast());
    }


    // testContains
    @Test
    public void testContain_ElementInEmptyList_ReturnsNull() {
        MyQueue<Integer> testQueue = new MyQueue();
        assertFalse(testQueue.contains(111));
    }

    @Test
    public void testContain_NullElement_ReturnsNull() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertFalse(testQueue.contains(null));
    }

    @Test
    public void testContain_ElementEqualsHead_ReturnsElement() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertTrue(testQueue.contains(111));
    }

    @Test
    public void testContain_Element_ReturnsElement() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertTrue(testQueue.contains(333));
    }

    @Test
    public void testContain_ElementEqualsTail_ReturnsElement() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertTrue(testQueue.contains(555));
    }



    //testPoll
    @Test
    public void testRemoveFirst_EmptyList_ReturnsIndexOutOfBoundsException() {
        MyQueue<Integer> testQueue = new MyQueue();
        assertThrows(IndexOutOfBoundsException.class, testQueue::poll);
    }

    @Test
    public void testRemoveFirst_Element_ReturnsTheFirstElementAndShorterList() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertEquals(111, testQueue.poll());
        assertEquals(222, testQueue.peekFirst());
        assertEquals(555, testQueue.peekLast());
    }

    @Test
    public void testRemoveFirst_ElementFrom1ElementLongList_ReturnsTheFirstElementAndEmptyList() {
        MyQueue<Integer> testQueue = new MyQueue();
        testQueue.push(111);
        assertEquals(111, testQueue.poll());
        assertNull(testQueue.peekFirst());
        assertNull(testQueue.peekLast());
    }


    //testSize
    @Test
    public void testSize_EmptyList_ReturnZero() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        assertEquals(0, testQueue.size());
    }

    @Test
    public void testSize_1ElementLongList_ReturnOne() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.push(1);
        assertEquals(1, testQueue.size());
    }

    @Test
    public void testSize_1002LongList_ReturnZero() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        for (int i = 0; i < 1002; i++) {
            testQueue.push(i);
        }
        assertEquals(1002, testQueue.size());
    }

    //testToArray
    @Test
    public void testToArray_List_ReturnsValidArray() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        for (int i = 0; i < 1002; i++) {
            testQueue.push(i);
        }

        Integer[] checkingArray = new Integer[1002];
        for (int i = 0; i < 1002; i++) {
            checkingArray[i] = i;
        }
        assertArrayEquals(checkingArray, testQueue.toArray());
    }
    @Test
    public void testToArray_EmptyList_ReturnsEmptyArray() {
        MyQueue<Integer> testQueue = new MyQueue<>();

        Integer[] checkingArray = new Integer[0];

        assertArrayEquals(checkingArray, testQueue.toArray());
    }

    //testToString
    @Test
    public void testToString_EmptyList_ReturnsNoElements(){
        MyQueue<String> testQueue = new MyQueue<>();
        assertEquals("MyQueue: ", testQueue.toString());
    }
    @Test
    public void testToString_ListWith3Elements_ReturnsStringWith3Elements(){
        MyQueue<String> testQueue = new MyQueue<>();
        testQueue.push("test1");
        testQueue.push("test2");
        testQueue.push("test3");
        assertEquals("MyQueue: test1, test2, test3", testQueue.toString());
    }

    @Test
    public void testToString_ListWithCustomObject_ReturnsStringWithObject(){
        MyQueue<MyTestClass> testQueue = new MyQueue<>();
        testQueue.push(new MyTestClass("ObjectOfMyTestClass"));
        assertEquals("MyQueue: ObjectOfMyTestClass", testQueue.toString());
    }

    @Test
    public void testToString_ListWithCustomObjectWithoutString_ReturnsStringWithObject(){
        MyQueue<MyTestClass> testQueue = new MyQueue<>();
        testQueue.push(new MyTestClass());
        assertEquals("MyQueue: testClassObject", testQueue.toString());
    }

    //testIterator
    @Test
    public void testIterator_ReturnsNewIterator() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.push(111);
        testQueue.push(222);
        testQueue.push(333);
        testQueue.push(444);
        testQueue.push(555);
        assertNotNull(testQueue.iterator());
    }

    @Test
    public void testIterator_forEach() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.push(1);
        testQueue.push(2);
        testQueue.push(3);
        testQueue.push(4);

        int sum = 0;
        for (Integer element : testQueue) {
            sum += element;
        }
        assertEquals(10, sum);
    }

    @Test
    public <E> void testIteratorHasNext_EmptyList_ReturnsFalse() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        assertFalse(() -> testQueue.iterator().hasNext());
    }

    @Test
    public <E> void testIteratorNext_EmptyList_ReturnsNoSuchElementException() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        assertThrows(NoSuchElementException.class, () -> testQueue.iterator().next());
    }

    @Test
    public <E> void testIteratorNext_OneElementLongList_ReturnsElement() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.push(111);
        assertEquals(111, testQueue.iterator().next());
    }

    @Test
    public void testIteratorNext_TwoElementLongListDoubleCallIterator_ReturnsElements() {
        MyQueue<Integer> testQueue = new MyQueue<>();
        testQueue.push(111);
        testQueue.push(222);
        MyQueue<Integer>.IteratorForQueue iterator = testQueue.iterator();
        assertEquals(111, iterator.next());
        assertEquals(222, iterator.next());
    }
}
