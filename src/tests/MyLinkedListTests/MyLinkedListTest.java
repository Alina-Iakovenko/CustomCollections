package tests.MyLinkedListTests;

import collections.MyArrayList;
import collections.MyLinkedList;
import collections.MyLinkedList.IteratorMLL;
import collections.MyLinkedList.Node;
import collections.MyTestClass;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest<E> {
    @Test
    public void testConstructor_ReturnsNotNullMyLinkedList() {
        MyLinkedList<MyTestClass> testList = new MyLinkedList();
        assertNotNull(testList);
    }

    // testAdd
    @Test
    public void testAdd_NullObject_ReturnsFalse() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertFalse(testList.add(null));
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    @Test
    public void testAdd_ObjectToEmptyList_ReturnsTrueAndListWithHeadEqualsTail() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertTrue(testList.add(111));
        assertEquals(111, testList.getHead().getObject());

        assertEquals(testList.getHead(), testList.getTail());

        assertNull(testList.getHead().getNext());
        assertNull(testList.getHead().getPrevious());

        assertNull(testList.getTail().getNext());
        assertNull(testList.getTail().getPrevious());
    }

    @Test
    public void testAdd_ObjectToListWithOneElement_ReturnsTrue() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        assertTrue(testList.add(222));

        assertEquals(111, testList.getHead().getObject());
        assertEquals(222, testList.getTail().getObject());

        assertEquals(testList.getHead().getNext(), testList.getTail());
        assertNull(testList.getHead().getPrevious());

        assertEquals(testList.getTail().getPrevious(), testList.getHead());
        assertNull(testList.getTail().getNext());
    }

    @Test
    public void testAdd_Object_ReturnsTrue() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);

        //test added Node, her previous and next
        assertTrue(testList.add(333));
        assertEquals(333, testList.getTail().getObject());
        assertEquals(222, testList.getTail().getPrevious().getObject());
        assertNull(testList.getTail().getNext());

        // test the first node, her previous and next
        assertEquals(111, testList.getHead().getObject());
        assertEquals(222, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());

        // test the middle node (that was the tail), her previous and next
        assertEquals(222, testList.getHead().getNext().getObject());
        assertEquals(111, testList.getHead().getNext().getPrevious().getObject());
        assertEquals(333, testList.getHead().getNext().getNext().getObject());
    }

    // testAddFirst
    @Test
    public void testAddFirst_AddNullElement_ReturnsIllegalArgumentException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> testList.addFirst(null));
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    @Test
    public void testAddFirst_ObjectToEmptyList_ReturnsListWithHeadEqualsTail() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.addFirst(111);
        assertEquals(111, testList.getHead().getObject());

        assertEquals(testList.getHead(), testList.getTail());

        assertNull(testList.getHead().getNext());
        assertNull(testList.getHead().getPrevious());

        assertNull(testList.getTail().getNext());
        assertNull(testList.getTail().getPrevious());
    }

    @Test
    public void testAddFirst_ObjectToListWithOneElement_ReturnsValidList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.addFirst(222);

        assertEquals(222, testList.getHead().getObject());
        assertEquals(111, testList.getTail().getObject());

        assertEquals(testList.getHead().getNext(), testList.getTail());
        assertNull(testList.getHead().getPrevious());

        assertEquals(testList.getTail().getPrevious(), testList.getHead());
        assertNull(testList.getTail().getNext());
    }

    @Test
    public void testAddFirst_Object_ReturnsValidList() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);

        //test added Node, her previous and next
        testList.addFirst(333);
        assertEquals(333, testList.getHead().getObject());
        assertEquals(222, testList.getTail().getObject());
        assertEquals(111, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());

        // test the second node (was the first, her previous and next
        assertEquals(111, testList.getHead().getNext().getObject());
        assertEquals(333, testList.getHead().getNext().getPrevious().getObject());
        assertEquals(222, testList.getHead().getNext().getNext().getObject());

        // test the latest node, her previous and next
        assertEquals(222, testList.getTail().getObject());
        assertEquals(111, testList.getTail().getPrevious().getObject());
        assertNull(testList.getTail().getNext());
    }

    // testAddLast
    @Test
    public void testAddLast_NullObject_ReturnsIllegalArgumentException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertThrows(IllegalArgumentException.class, () -> testList.addLast(null));
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    @Test
    public void testAddLast_ObjectToEmptyList_ReturnsTrueAndListWithHeadEqualsTail() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.addLast(111);
        assertEquals(111, testList.getHead().getObject());

        assertEquals(testList.getHead(), testList.getTail());

        assertNull(testList.getHead().getNext());
        assertNull(testList.getHead().getPrevious());

        assertNull(testList.getTail().getNext());
        assertNull(testList.getTail().getPrevious());
    }

    @Test
    public void testAddLast_ObjectToListWithOneElement_ReturnsTrue() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.addLast(222);

        assertEquals(111, testList.getHead().getObject());
        assertEquals(222, testList.getTail().getObject());

        assertEquals(testList.getHead().getNext(), testList.getTail());
        assertNull(testList.getHead().getPrevious());

        assertEquals(testList.getTail().getPrevious(), testList.getHead());
        assertNull(testList.getTail().getNext());
    }

    @Test
    public void testAddLast_Object_ReturnsTrue() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);

        //test added Node, her previous and next
        testList.addLast(333);
        assertEquals(333, testList.getTail().getObject());
        assertEquals(222, testList.getTail().getPrevious().getObject());
        assertNull(testList.getTail().getNext());

        // test the first node, her previous and next
        assertEquals(111, testList.getHead().getObject());
        assertEquals(222, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());

        // test the middle node (that was the tail), her previous and next
        assertEquals(222, testList.getHead().getNext().getObject());
        assertEquals(111, testList.getHead().getNext().getPrevious().getObject());
        assertEquals(333, testList.getHead().getNext().getNext().getObject());
    }

    // testSet
    @Test
    public void testSet_ReplaceNullElement_ReturnsIllegalArgumentException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertThrows(IllegalArgumentException.class, () -> testList.set(null, 111));
    }

    @Test
    public void testSet_ReplaceToNullElement_ReturnsIllegalArgumentException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertThrows(IllegalArgumentException.class, () -> testList.set(111, null));
    }

    @Test
    public void testSet_ReplaceNotValidlElement_ReturnsIllegalArgumentException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertThrows(IllegalArgumentException.class, () -> testList.set(666, 777));
    }

    @Test
    public void testSet_ReplaceTheFirstElement_ReturnsListWithNewValueOfTheFirstElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.set(111, 101);

        assertEquals(101, testList.getHead().getObject());
        assertEquals(222, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());
        assertEquals(101, testList.getHead().getNext().getPrevious().getObject());
    }

    @Test
    public void testSet_ReplaceTheSecondElement_ReturnsListWithNewValueOfTheSecondElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.set(222, 202);

        assertEquals(111, testList.getHead().getObject());
        assertEquals(202, testList.getHead().getNext().getObject());
        assertEquals(111, testList.getHead().getNext().getPrevious().getObject());
        assertEquals(333, testList.getHead().getNext().getNext().getObject());
    }

    @Test
    public void testSet_ReplaceTheLatestElement_ReturnsListWithNewValueOfThLatestElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.set(555, 505);

        assertEquals(505, testList.getTail().getObject());
        assertNull(testList.getTail().getNext());
        assertEquals(444, testList.getTail().getPrevious().getObject());
        assertEquals(505, testList.getTail().getPrevious().getNext().getObject());
    }

    // testContain
    @Test
    public void testContain_ElementInEmptyList_ReturnsNull() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertNull(testList.contains(111));
    }

    @Test
    public void testContain_NullElement_ReturnsNull() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertNull(testList.contains(null));
    }

    @Test
    public void testContain_ElementEqualsHead_ReturnsElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(111, testList.contains(111).getObject());
    }

    @Test
    public void testContain_Element_ReturnsElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(333, testList.contains(333).getObject());
    }

    @Test
    public void testContain_ElementEqualsTail_ReturnsElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(555, testList.contains(555).getObject());
    }

    // testGetFirst
    @Test
    public void testGetFirst_EmptyList_ReturnsNull() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertNull(testList.getFirst());
    }

    @Test
    public void testGetFirst_Element_ReturnsTheFirstElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(111, testList.getFirst().getObject());
    }

    // testGetLast
    @Test
    public void testGetLast_EmptyList_ReturnsNull() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertNull(testList.getFirst());
    }

    @Test
    public void testGetLast_Element_ReturnsTheLatestElement() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(555, testList.getLast().getObject());
    }

    //testRemoveFirst
    @Test
    public void testRemoveFirst_EmptyList_ReturnsIndexOutOfBoundsException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, testList::removeFirst);
    }

    @Test
    public void testRemoveFirst_Element_ReturnsTheFirstElementAndShorterList() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(111, testList.removeFirst().getObject());
        assertEquals(222, testList.getHead().getObject());
        assertEquals(333, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());
    }

    @Test
    public void testRemoveFirst_ElementFrom1ElementLongList_ReturnsTheFirstElementAndEmptyList() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        assertEquals(111, testList.removeFirst().getObject());
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    //testRemoveLast
    @Test
    public void testRemoveLast_EmptyList_ReturnsIndexOutOfBoundsException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, testList::removeLast);
    }

    @Test
    public void testRemoveLast_Element_ReturnsTheLastElementAndShorterList() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertEquals(555, testList.removeLast().getObject());
        assertEquals(444, testList.getTail().getObject());
        assertEquals(333, testList.getTail().getPrevious().getObject());
        assertNull(testList.getTail().getNext());
    }

    @Test
    public void testRemoveLast_ElementFrom1ElementLongList_ReturnsTheLastElementAndEmptyList() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        assertEquals(111, testList.removeLast().getObject());
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    //testRemove
    @Test
    public void testRemove_EmptyList_ReturnsIndexOutOfBoundsException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(111));
    }

    @Test
    public void testRemove_NullElement_ReturnsIndexOutOfBoundsException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        assertThrows(IllegalArgumentException.class, () -> testList.remove(null));
    }

    @Test
    public void testRemove_NotValidElement_ReturnsIndexOutOfBoundsException() {
        MyLinkedList<Integer> testList = new MyLinkedList();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertThrows(IllegalArgumentException.class, () -> testList.remove(1));
    }

    @Test
    public void testRemove_TheFirstElement_ReturnsShorterMyLinkedList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.remove(111);
        assertEquals(222, testList.getHead().getObject());
        assertEquals(333, testList.getHead().getNext().getObject());
        assertNull(testList.getHead().getPrevious());
    }

    @Test
    public void testRemove_ElementFrom1ElementLongList_ReturnsTheLastElementAndEmptyList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.remove(111);
        assertNull(testList.getHead());
        assertNull(testList.getTail());
    }

    @Test
    public void testRemove_TheElement_ReturnsShorterMyLinkedList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.remove(222);
        assertEquals(111, testList.getHead().getObject());
        assertEquals(333, testList.getHead().getNext().getObject());
        assertEquals(111, testList.getHead().getNext().getPrevious().getObject());
        assertNull(testList.getHead().getPrevious());
    }

    @Test
    public void testRemove_TheLatestElement_ReturnsShorterMyLinkedList() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);

        testList.remove(555);
        assertEquals(444, testList.getTail().getObject());
        assertNull(testList.getTail().getNext());
        assertEquals(333, testList.getTail().getPrevious().getObject());
        assertEquals(444, testList.getTail().getPrevious().getNext().getObject());
    }

    //testSize
    @Test
    public void testSize_EmptyList_ReturnZero() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        assertEquals(0, testList.size());
    }

    @Test
    public void testSize_1ElementLongList_ReturnOne() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        assertEquals(1, testList.size());
    }

    @Test
    public void testSize_1002LongList_ReturnZero() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i = 0; i < 1002; i++) {
            testList.add(i);
        }
        assertEquals(1002, testList.size());
    }

    //testToArray
    @Test
    public void testToArray_List_ReturnsValidArray() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        for (int i = 0; i < 1002; i++) {
            testList.add(i);
        }

        Integer[] checkingArray = new Integer[1002];
        for (int i = 0; i < 1002; i++) {
            checkingArray[i] = i;
        }
        assertArrayEquals(checkingArray, testList.toArray());
    }
    @Test
    public void testToArray_EmptyList_ReturnsEmptyArray() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();

        Integer[] checkingArray = new Integer[0];

        assertArrayEquals(checkingArray, testList.toArray());
    }

    //testToString
    @Test
    public void testToString_EmptyList_ReturnsNoElements(){
        MyLinkedList<String> testList = new MyLinkedList<>();
        assertEquals("MyLinkedList: ", testList.toString());
    }
    @Test
    public void testToString_ListWith3Elements_ReturnsStringWith3Elements(){
        MyLinkedList<String> testList = new MyLinkedList<>();
        testList.add("test1");
        testList.add("test2");
        testList.add("test3");
        assertEquals("MyLinkedList: test1, test2, test3", testList.toString());
    }

    @Test
    public void testToString_ListWithCustomObject_ReturnsStringWithObject(){
        MyLinkedList<MyTestClass> testList = new MyLinkedList<>();
        testList.add(new MyTestClass("ObjectOfMyTestClass"));
        assertEquals("MyLinkedList: ObjectOfMyTestClass", testList.toString());
    }

    @Test
    public void testToString_ListWithCustomObjectWithoutString_ReturnsStringWithObject(){
        MyLinkedList<MyTestClass> testList = new MyLinkedList<>();
        testList.add(new MyTestClass());
        assertEquals("MyLinkedList: testClassObject", testList.toString());
    }

    //testIterator
    @Test
    public void testIterator_ReturnsNewIterator() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.add(222);
        testList.add(333);
        testList.add(444);
        testList.add(555);
        assertNotNull(testList.iterator());
    }

    @Test
    public <E> void testIterator_forEach() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        int sum = 0;

        for (Node<Integer> integerNode : testList) {
            sum += integerNode.getObject();
        }
        assertEquals(10, sum);
    }

    @Test
    public <E> void testIteratorHasNext_EmptyList_ReturnsFalse() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        assertFalse(() -> testList.iterator().hasNext());
    }

    @Test
    public <E> void testIteratorNext_EmptyList_ReturnsNoSuchElementException() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> testList.iterator().next());
    }

    @Test
    public <E> void testIteratorNext_OneElementLongList_ReturnsElement() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        assertEquals(111, testList.iterator().next().getObject());
    }

    @Test
    public <E> void testIteratorNext_TwoElementLongListDoubleCallIterator_ReturnsElements() {
        MyLinkedList<Integer> testList = new MyLinkedList<>();
        testList.add(111);
        testList.add(222);
        IteratorMLL iterator = (IteratorMLL) testList.iterator();
        assertEquals(111, iterator.next().getObject());
        assertEquals(222, iterator.next().getObject());
    }
}
