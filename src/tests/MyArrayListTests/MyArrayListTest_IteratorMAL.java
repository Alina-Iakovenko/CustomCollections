package tests.MyArrayListTests;

import collections.MyArrayList;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest_IteratorMAL {

    @Test
    public void testIterator_forEach_ReturnsSumOfIntegers() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 1; i < 5; i++) {
            list.add(i);
        }
        int sum = 0;
        for (Object element : list) {
            sum += (int)element;
        }
        assertEquals(10, sum);
    }

    @Test
    public void testHasNext_FullList_ReturnsTrue() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MyArrayList<Integer>.IteratorMAL iterator = list.new IteratorMAL();
        assertTrue(iterator.hasNext());
    }

    @Test
    public void testHasNext_Remove_ReturnsListWithoutRemovedElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        MyArrayList<Integer>.IteratorMAL iterator = list.new IteratorMAL();
        while (iterator.hasNext()) {
            if (iterator.next() == 3) {
                iterator.remove();
            }
        }
    }

    @Test
    public void testHasNext_ReturnsFalse() {
        MyArrayList<Integer> list = new MyArrayList<>();
        MyArrayList<Integer>.IteratorMAL iterator = list.new IteratorMAL();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNext_ReturnsNextElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        MyArrayList<Integer>.IteratorMAL iterator = list.new IteratorMAL();

        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
    }

    @Test
    public void testNext_ThrowsNoSuchElementException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        MyArrayList<Integer>.IteratorMAL iterator = list.new IteratorMAL();

        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
