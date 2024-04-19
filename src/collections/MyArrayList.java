package collections;

import java.util.*;
/**
 * The MyArrayList class is a custom ArrayList implementation.
 * It is iterable and uses generics.
 *
 * @param <E> the type of elements in the list
 */
public class MyArrayList<E> implements Iterable<E> {
    /**
     *  Current size of the list
     */
    private int size;
    /**
     * Maximum size of the list
     */
    private int capacity;
    /**
     * Array to store the elements of the list
     */
    private E[] array;

    /**
     * Constructs an empty MyArrayList with an initial capacity of 10.
     */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = (E[]) new Object[capacity];
    }


    /**
     * Constructs a MyArrayList with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws RuntimeException if the capacity is less than 1
     */
    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("The capacity can`t be less then 1");
        }
        this.size = 0;
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getSize() {
        return size;
    }
    /**
     * Returns the current capacity of this list.
     *
     * @return the current capacity of this list
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Returns the array containing all the elements in this list in proper sequence.
     *
     * @return the array containing all the elements in this list
     */
    public E[] getArray() {
        return array;
    }

    /**
     * Ensures that the capacity of the underlying array is sufficient to accommodate additional elements.
     * If the array needs to be resized, it increases the capacity by 50%.
     */
    @SuppressWarnings("unchecked")
    private void checkCapacity() {
        boolean capacityIncreased = false;
        E[] biggerArray = null;
        while ((double) size > (double) capacity * 0.75) {
            capacity = (int) Math.ceil(capacity * 1.5);
            capacityIncreased = true;
        }
        if (capacityIncreased) {
            biggerArray = (E[]) new Object[(int) (capacity)];
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    biggerArray[i] = array[i];
                }
            }
            array = biggerArray;
        }
    }
    /**
     * Appends the specified element to the end of this list.
     *
     * @param object the element to be appended to this list
     * @return true
     */
    public boolean add(E object) {
        checkCapacity();
        array[size] = object;
        size++;
        return true;
    }
    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index  the index at which the specified element is to be inserted
     * @param object the element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
     */
    public void add(int index, E object) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can`t be less then 0");
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("Index can`t be bigger then size");
        }

        checkCapacity();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = object;
        size++;
    }
    /**
     * Inserts all the elements in the specified array into this list, starting at the specified position.
     *
     * @param index     the index at which to insert the first element from the specified array
     * @param arrayToAdd the array containing elements to be added to this list
     */
    public void addAllFromIndex(int index, E[] arrayToAdd) {
        int oldSize = size;
        size += arrayToAdd.length + index;
        checkCapacity();
        Integer[] arrayToPut = new Integer[size];
        for (int j = size - 1, i = oldSize - 1; i >= 0; i--, j--) {
            arrayToPut[j] = (Integer) array[i];
        }
        array = (E[]) arrayToPut;
        for (int i = index; i < arrayToAdd.length; ) {
            for (int j = 0; j < arrayToAdd.length; ) {
                array[i] = arrayToAdd[j];
                i++;
                j++;
            }
        }
    }
    /**
     * Removes all the elements from this list.
     * Set size to 0 and capacity to 10.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        capacity = 10;
    }
    /**
     * Returns true if this list contains the specified element.
     *
     * @param object the element whose presence in this list is to be tested
     * @return true if this list contains the specified element, false otherwise
     */
    public boolean contains(E object) {
        for (E e : array) {
            if (object == null && e == null) {
                return true;
            }
            if (e != null && e.equals(object)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E get(int index) {
        if (index < size) {
            return array[index];
        }
        throw new IndexOutOfBoundsException("Array is shorter then you suppose in index");
    }
    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param object the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     *          or -1 if this list does not contain the element
     */
    public int indexOf(E object) {
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].equals(object))
                return i;
        }
        return -1;
    }
    /**
     * Returns the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param object the element to search for
     * @return the index of the last occurrence of the specified element in this list,
     *          or -1 if this list does not contain the element
     */
    public int lastIndexOf(E object) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        for (E e : array) {
            if (e != null)
                return false;
        }
        return true;
    }
    /**
     * Removes the element at the specified position in this list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public E remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Array is shorter then you suppose in index");
        }
        E toReturn = array[index];
        for (int i = index; i < size; i++) {
            array[i] = null;
            if (i < size - 1) {
                array[i] = array[i + 1];
            }
        }
        size--;
        return toReturn;

    }
    /**
     * Removes all occurrences of the specified element from this list, if it is present.
     *
     * @param object the element to be removed from the list
     * @return the number of occurrences removed from the list
     */
    public int removeObject(E object) {
        int isRemoved = 0;
        for (int i = 0; i < size; ) {
            if (array[i] != null && array[i].equals(object)) {
                remove(i);
                isRemoved++;
            } else {
                i++;
            }
        }
        return isRemoved;
    }
    /**
     * Removes all occurrences of the elements in the specified array from this list, if they are present.
     *
     * @param arrayToRemove the array of elements to be removed from the list
     * @return the total number of occurrences removed from the list
     */
    public int removeAllGivenArraysElements(E[] arrayToRemove) {
        int isRemoved = 0;
        for (int i = 0; i <= size; ) {
            for (int j = 0; j < arrayToRemove.length; ) {
                if (array[i] != null && array[i].equals(arrayToRemove[j])) {
                    remove(i);
                    isRemoved++;
                    j = 0;
                } else {
                    j++;
                }
            }
            i++;
        }
        return isRemoved;
    }
    /**
     * Removes a range of elements from this list.
     *
     * @param fromIndex the index of the first element to be removed (inclusive)
     * @param toIndex   the index of the last element to be removed (exclusive)
     * @return true if the range of elements was successfully removed, false otherwise
     */
    public boolean removeRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size) {
            return false;
        }
        int quantity = toIndex - fromIndex + 1;
        for (int i = fromIndex; i < size; i++) {
            if (i + quantity < size) {
                array[i] = array[i + quantity];
            } else {
                array[i] = null;
            }
        }
        size -= quantity;
        return true;
    }
    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   the index of the element to be replaced
     * @param element the element to be stored at the specified position
     * @return true if the operation is successful, false otherwise
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
    public boolean set(int index, E element) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index can`t be less then 0");
        }
        if (index >= size) {
            throw new IndexOutOfBoundsException("Can`t set element with index >= size");
        }
        array[index] = element;
        return true;
    }
    /**
     * Sorts this list according to the order induced by the specified comparator.
     *
     * @param comparator the comparator to determine the order of the elements
     */
    public void sort(Comparator<? super E> comparator) {
        if (size > 1) {
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for (int i = 0; i < size - 1; i++) {
                    E elementLeft = array[i];
                    E elementRight = array[i + 1];

                    if (comparator.compare(elementLeft, elementRight) > 0) {
                        array[i] = elementRight;
                        array[i + 1] = elementLeft;
                        swapped = true;
                    }
                }
            }
        }
    }
    /**
     * Returns a view of the portion of this list between the specified index (fromIndex),
     * inclusive, and specified index (toIndex), exclusive.
     *
     * @param fromIndex the index of the first element (inclusive) in the sublist
     * @param toIndex   the index of the last element (exclusive) in the sublist
     * @return a sublist view of this list
     * @throws IndexOutOfBoundsException if the specified range is invalid
     */
    public MyArrayList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex == toIndex) {
            throw new IndexOutOfBoundsException("Something wrong with indexes");
        }
        int quantity = toIndex - fromIndex + 1;
        MyArrayList<E> listToReturn = new MyArrayList<>(quantity);
        for (int i = fromIndex; i < toIndex; ) {
            for (int j = 0; j < quantity; ) {
                listToReturn.add(j, array[i]);
                i++;
                j++;
            }
        }
        return listToReturn;
    }
    /**
     * Reduces the capacity of this list to its current size.
     * An application can use this operation to minimize the storage of the list.
     */
    public void trimToSize() {
        if (size == 0) {
            capacity = 1;
            return;
        }
        Object[] trimmedArray = new Object[size];
        System.arraycopy(array, 0, trimmedArray, 0, size);
        array = (E[]) trimmedArray;
        capacity = size;
    }
    /**
     * Removes all occurrences of null elements from this list.
     * Adjusts the size of the list accordingly.
     */
    public void removeNullElements() {
        for (int i = 0; i < size; ) {
            if (array[i] == null) {
                for (int j = i; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
            } else {
                i++;
            }
        }
        Object[] arrayWithoutNulls = new Object[size];
        System.arraycopy(array, 0, arrayWithoutNulls, 0, size);
        array = (E[]) arrayWithoutNulls;
    }
    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder arrayToPrint = new StringBuilder("MyArrayList: ");
        for (int i = 0; i < size; i++) {
            arrayToPrint.append(array[i]);
            if (i < size - 1) {
                arrayToPrint.append(", ");
            }
        }
        return arrayToPrint.toString();
    }
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public IteratorMAL iterator() {
        return new IteratorMAL();
    }
    /**
     * An iterator implementation for the MyArrayList class.
     * Allows iteration over the elements in the list.
     */
    public class IteratorMAL implements Iterator<E> {
        /** Index of the current element in the iteration. */
        private int currentIndex = 0;
        /** Last element returned by the iterator. */
        private E lastReturned = null;
        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (hasNext()) {
                E nextElement = array[currentIndex++];
                lastReturned = nextElement;
                return nextElement;
            }
            throw new NoSuchElementException("No more elements in the list");
        }
        /**
         * Removes from the underlying collection the last element returned by this iterator.
         * This method can be called only once per call to next.
         *
         * @throws IllegalStateException if the next method has not yet been called,
         *                               or the remove method has already been called
         *                               after the last call to the next method
         */
        @Override
        public void remove() {
            MyArrayList.this.removeObject(lastReturned);
            currentIndex--;
            lastReturned = null;
        }
    }
}


