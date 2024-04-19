package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A custom implementation of a linked list data structure.
 *
 * @param <E> the type of elements in this list
 */
public class MyLinkedList<E> implements Iterable<E> {
    /**
     * The first node of the linked list.
     */
    private Node<E> head;
    /**
     * The last node of the linked list.
     */
    private Node<E> tail;
    /**
     * Constructs an empty list.
     */
    public MyLinkedList() {
        Node<E> head = null;
        Node<E> tail = null;
    }
    /**
     * Returns the head node of the linked list.
     *
     * @return the head node of the linked list
     */
    public Node<E> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the linked list.
     *
     * @return the tail node of the linked list
     */
    public Node<E> getTail() {
        return tail;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param object the element to be added
     * @return {@code true} if this list changed as a result of the call
     */
    public boolean add(E object) {
        if (object == null) {
            return false;
        }
        if (head == null) {
            head = new Node<>(object, null, null);
            tail = head;
            return true;
        }
        if (head == tail) {
            tail = new Node<>(object, tail, null);
            tail.previous = head;
            head.next = tail;
            return true;
        }
        Node<E> oldTail = tail;
        tail = new Node<>(object, oldTail, null);
        oldTail.next = tail;
        return true;
    }
    /**
     * Adds the specified element to the beginning of this list.
     *
     * @param object the element to be added
     */
    public void addFirst(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Can`t add null object");
        } else if (head == null) {
            head = new Node<>(object, null, null);
            tail = head;
        } else if (head == tail) {
            head = new Node<>(object, null, tail);
            tail.previous = head;
        } else {
            Node<E> oldHead = head;
            head = new Node<>(object, null, oldHead);
            oldHead.previous = head;
        }
    }
    /**
     * Adds the specified element to the end of this list.
     *
     * @param object the element to be added
     */
    public void addLast(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Can`t add null object");
        } else if (head == null) {
            head = new Node<>(object, null, null);
            tail = head;
        } else if (head == tail) {
            tail = new Node<>(object, tail, null);
            tail.previous = head;
            head.next = tail;
        } else {
            Node<E> oldTail = tail;
            tail = new Node<>(object, oldTail, null);
            oldTail.next = tail;
        }
    }
    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param oldObject the element to be replaced
     * @param newObject the element to replace oldElement with
     * @throws IllegalArgumentException if oldElement or newElement is null
     * */
    public void set(E oldObject, E newObject) {
        if (oldObject == null || newObject == null) {
            throw new IllegalArgumentException("Can`t replace null element or to element");
        }
        Node<E> nodeToChange = getFirstOccurrence(oldObject);
        if (nodeToChange == null) {
            throw new IllegalArgumentException("The MyLinkedList doesn`t contain the object you want to replace");
        }
        nodeToChange.object = newObject;
    }
    /**
     * Find and returns the first occurrence of the specified element in this list,
     * or  null if this list does not contain the element.
     *
     * @param object the element to search for
     * @return the first occurrence of the specified element,
     *          or null if this list does not contain the element
     */
    protected Node<E> getFirstOccurrence(E object) {
        if (head == null) {
            return null;
        }
        if (head.getObject() == object) {
            return head;
        }
        Node<E> currentNode = head.getNext();
        do {
            if (currentNode.getObject().equals(object)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != null);
        return null;
    }
    /**
     * Checks if this list contains the specified element.
     *
     * @param object the element whose presence in this list is to be tested
     * @return true if this list contains the specified element or false otherwise
     */
    public boolean contains(E object) {
        return getFirstOccurrence(object) != null;
    }
    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     */
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return head.getObject();
    }
    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    public E getLast() {
        if (tail == null) {
            return null;
        }
        return tail.getObject();
    }
    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws IndexOutOfBoundsException if this list is empty
     */
    public Node<E> removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Can`t remove nothing from empty MyLinkedList");
        }
        if (head == tail) {
            Node<E> toReturn = head;
            head = null;
            tail = null;
            return toReturn;
        }
        Node<E> oldHead = head;
        head = oldHead.next;
        head.previous = null;
        return oldHead;
    }
    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws IndexOutOfBoundsException if this list is empty
     */
    public Node<E> removeLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Can`t remove nothing from empty MyLinkedList");
        }
        if (head == tail) {
            Node<E> toReturn = head;
            head = null;
            tail = null;
            return toReturn;
        }
        Node<E> oldTail = tail;
        tail = oldTail.previous;
        tail.next = null;
        return oldTail;
    }
    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param object the element to be removed from this list, if present
     * @throws IndexOutOfBoundsException if the list is empty
     * @throws IllegalArgumentException if the object to remove is null or the list does not contain it
     */
    public void remove(E object) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Can`t remove anything from the empty MyLinkedList");
        } else if (object == null) {
            throw new IllegalArgumentException("Can`t remove null element");
        }
        Node<E> nodeToRemove = getFirstOccurrence(object);
        if (nodeToRemove == null) {
            throw new IllegalArgumentException("No such element in MyLinkedList");
        } else if (nodeToRemove == head) {
            removeFirst();
        } else if (nodeToRemove == tail) {
            removeLast();
        } else {
            nodeToRemove.previous.next = nodeToRemove.next;
            nodeToRemove.next.previous = nodeToRemove.previous;
        }
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        int size = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
    /**
     * Returns an array containing all the elements in this list in proper sequence.
     *
     * @return an array containing all the elements in this list in proper sequence
     */
    public E[] toArray() {
        int size = size();
        IteratorMLL iterator = (IteratorMLL) iterator();
        E[] array = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = iterator.next();
        }
        return array;
    }
    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        IteratorMLL iterator = (IteratorMLL) iterator();
        StringBuilder toPrint = new StringBuilder("MyLinkedList: ");
        while (iterator.hasNext()) {
            toPrint.append(iterator.next());
            if (iterator.hasNext()) {
                toPrint.append(", ");
            }
        }
        return toPrint.toString();
    }
    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<E> iterator() {
        return new IteratorMLL();
    }
    /**
     * Represents a node in the linked list.
     *
     * @param <E> the type of element stored in the node
     */
    public static class Node<E> {
        /**
         * The object stored in the node.
         */
        private E object;
        /**
         * The previous node in the linked list.
         */
        private Node<E> previous;
        /**
         * The next node in the linked list.
         */
        private Node<E> next;
        /**
         * Constructs a new node with the specified object, previous, and next nodes.
         *
         * @param object   the object to be stored in the node
         * @param previous the previous node in the linked list
         * @param next     the next node in the linked list
         */
        public Node(E object, Node<E> previous, Node<E> next) {
            this.object = object;
            this.previous = previous;
            this.next = next;
        }
        /**
         * Returns the object stored in the node.
         *
         * @return the object stored in the node
         */
        public E getObject() {
            return object;
        }
        /**
         * Returns the previous node in the linked list.
         *
         * @return the previous node in the linked list
         */
        public Node<E> getPrevious() {
            return previous;
        }
        /**
         * Returns the next node in the linked list.
         *
         * @return the next node in the linked list
         */
        public Node<E> getNext() {
            return next;
        }

    }
    /**
     * Iterator implementation for MyLinkedList.
     */
    public class IteratorMLL implements Iterator<E> {
        /**
         * The current node pointed to by the iterator.
         */
        private Node<E> currentNode;
        /**
         * Indicates whether there is a next node.
         */
        private boolean hasNextNode = false;
        /**
         * Constructs a new iterator starting from the head of the linked list.
         */
        public IteratorMLL() {
            this.currentNode = head;
            this.hasNextNode = (currentNode != null);
        }
        /**
         * Checks if there are more elements in the iteration.
         *
         * @return true if the iteration has more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return hasNextNode;
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNextNode) {
                throw new NoSuchElementException("No more elements in the list");
            }
            E toReturn = currentNode.getObject();
            hasNextNode = (currentNode.next != null);
            currentNode = currentNode.getNext();
            return toReturn;
        }
    }
}

