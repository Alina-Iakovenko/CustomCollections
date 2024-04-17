package collections;

import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<E> implements Iterable<E> {
    private int size;
    private int capacity;
    private E[] array;


    @SuppressWarnings("unchecked")
    public MyArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.array = (E[]) new Object[capacity];
    }


    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity) {
        if (capacity < 1) {
            throw new RuntimeException("The capacity can`t be less then 1");
        }
        this.size = 0;
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public E[] getArray() {
        return array;
    }

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

    public boolean add(E object) {
        checkCapacity();
        array[size] = object;
        size++;
        return true;
    }

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

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        capacity = 10;
    }

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

    public E get(int index) {
        if (index < size) {
            return array[index];
        }
        throw new IndexOutOfBoundsException("Array is shorter then you suppose in index");
    }

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

    public boolean isEmpty() {
        for (E e : array) {
            if (e != null)
                return false;
        }
        return true;
    }

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
    @Override
    public IteratorMAL iterator() {
        return new IteratorMAL();
    }

    public class IteratorMAL implements Iterator<E> {
        private int currentIndex = 0;
        private E lastReturned = null;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E nextElement = array[currentIndex++];
                lastReturned = nextElement;
                return nextElement;
            }
            throw new NoSuchElementException("No more elements in the list");
        }
        @Override
        public void remove() {
            MyArrayList.this.removeObject(lastReturned);
            currentIndex--;
            lastReturned = null;
        }
    }
}


