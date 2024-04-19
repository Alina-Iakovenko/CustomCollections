package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * A stack implementation based on a linked list.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStack<E> implements Iterable<E> {
    /** The linked list representing the stack. */
    MyLinkedList<E> stack;
    /** Constructs an empty stack. */
    public MyStack() {
        this.stack = new MyLinkedList<>();
    }
    /**
     * Pushes an element onto the top of the stack.
     *
     * @param object the element to be pushed onto the stack
     */
    public void push(E object){stack.addLast(object);}
    /**
     * Retrieves, but does not remove, the first element of the stack.
     *
     * @return the first element of the stack, or null if the stack is empty
     */
    //повертає, але не видаляє == get
    public E peekFirst() {
        if (stack.getHead() != null) {
            return stack.getHead().getObject();
        } else {
            return null;
        }
    }
    /**
     * Retrieves, but does not remove, the last element of the stack.
     *
     * @return the last element of the stack, or null if the stack is empty
     */
    public E peekLast() {
        if (stack.getTail() != null) {
            return stack.getTail().getObject();
        } else {
            return null;
        }
    }
    /**
     * Checks if the stack contains the specified element.
     *
     * @param object the element to be checked for containment in the stack
     * @return true if the stack contains the specified element, false otherwise
     */
    public boolean contains(E object){
        return stack.contains(object);
    }
    /**
     * Retrieves and removes the last element of the stack.
     *
     * @return the last element of the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public E pop(){
        return stack.removeLast().getObject();
    }
    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack.getHead() == null;
    }
    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size() {
        return stack.size();
    }
    /**
     * Returns an array containing all the elements in the stack in proper sequence.
     *
     * @return an array containing all of the elements in the stack
     */
    public E[] toArray() {
        IteratorForStack iterator = iterator();
        E[] array = (E[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    /**
     * Returns a string representation of the stack.
     *
     * @return a string representation of the stack
     */
    public String toString(){
        StringBuilder toPrint = new StringBuilder("MyStack: ");
        if (!isEmpty()) {
            for (E eNode : stack) {
                toPrint.append(eNode);
                toPrint.append(", ");
            }
            toPrint.deleteCharAt(toPrint.length() - 1);
            toPrint.deleteCharAt(toPrint.length() - 1);
        }
        return toPrint.toString();
    }
    /**
     * Returns an iterator over the elements in the stack.
     *
     * @return an iterator over the elements in the stack
     */
    @Override
    public IteratorForStack iterator() {
        return new IteratorForStack();
    }
    /**
     * Iterator implementation for MyStack.
     */
    public class IteratorForStack implements Iterator<E> {
        /** The current element pointed to by the iterator. */
        private MyLinkedList.Node<E> currentElement;
        /** Indicates whether there is a next element. */
        private boolean hasNextElement;
        /** Constructs a new iterator starting from the head of the stack. */
        public IteratorForStack() {
            this.currentElement = stack.getHead();
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
