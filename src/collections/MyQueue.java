package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * A queue implementation based on a linked list.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueue<E> implements Iterable<E> {
    /** The linked list representing the queue. */
    MyLinkedList<E> queue;
    /** Constructs an empty queue. */
    public MyQueue() {
        this.queue = new MyLinkedList<>();
    }

    /**
     * Adds an element to the end of the queue.
     *
     * @param object the element to be added to the queue
     */
    public void push(E object) {
        queue.addLast(object);
    }

    /**
     * Retrieves, but does not remove, the first element of the queue.
     *
     * @return the first element of the queue, or null if the queue is empty
     */
    public E peekFirst() {
        if (queue.getHead() != null) {
            return queue.getHead().getObject();
        } else {
            return null;
        }
    }
    /**
     * Retrieves, but does not remove, the last element of the queue.
     *
     * @return the last element of the queue, or null if the queue is empty
     */
    public E peekLast() {
        if (queue.getTail() != null) {
            return queue.getTail().getObject();
        } else {
            return null;
        }
    }
    /**
     * Checks if the queue contains the specified element.
     *
     * @param object the element to be checked for containment in the queue
     * @return true if the queue contains the specified element, false otherwise
     */
    public boolean contains(E object) {
        return queue.contains(object);
    }

    /**
     * Retrieves and removes the first element of the queue.
     *
     * @return the first element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E poll() {
        return queue.removeFirst().getObject();
    }
    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return queue.getHead() == null;
    }
    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return queue.size();
    }
    /**
     * Returns an array containing all the elements in the queue in proper sequence.
     *
     * @return an array containing all the elements in the queue
     */
    public E[] toArray() {
        IteratorForQueue iterator = iterator();
        E[] array = (E[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }
    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder("MyQueue: ");
        if (!isEmpty()) {
            for (E eNode : queue) {
                toPrint.append(eNode);
                toPrint.append(", ");
            }
            toPrint.deleteCharAt(toPrint.length() - 1);
            toPrint.deleteCharAt(toPrint.length() - 1);
        }
        return toPrint.toString();
    }

    /**
     * Returns an iterator over the elements in the queue.
     *
     * @return an iterator over the elements in the queue
     */
    @Override
    public IteratorForQueue iterator() {
        return new IteratorForQueue();
    }
    /**
     * Iterator implementation for MyQueue.
     */
    public class IteratorForQueue implements Iterator<E> {
        /** The current element pointed to by the iterator. */
        private MyLinkedList.Node<E> currentElement;
        /** Indicates whether there is a next element. */
        private boolean hasNextElement;
        /** Constructs a new iterator starting from the head of the queue. */
        public IteratorForQueue() {
            this.currentElement = queue.getHead();
            this.hasNextElement = (currentElement != null);
        }
        /**
         * Checks if there are more elements in the iteration.
         *
         * @return true if the iteration has more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return hasNextElement;
        }
        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNextElement) {
                throw new NoSuchElementException("No more elements in the list");
            }
            MyLinkedList.Node<E> nodeToReturn = currentElement;
            E toReturn = currentElement.getObject();
            hasNextElement = (nodeToReturn.getNext() != null);
            currentElement = currentElement.getNext();
            return toReturn;
        }
    }
}
