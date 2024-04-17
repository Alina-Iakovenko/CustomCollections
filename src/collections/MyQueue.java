package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements Iterable<E> {
    MyLinkedList<E> queue;

    public MyQueue() {
        this.queue = new MyLinkedList<>();
    }

    // кладе addLast
    public void push(E object) {
        queue.addLast(object);
    }

    //повертає, але не видаляє == get
    public E peekFirst() {
        if (queue.getHead() != null) {
            return queue.getHead().getObject();
        } else {
            return null;
        }
    }

    public E peekLast() {
        if (queue.getTail() != null) {
            return queue.getTail().getObject();
        } else {
            return null;
        }
    }

    public boolean contains(E object) {
        return queue.contains(object) != null;
    }

    //Retrieves and removes first == removeHead
    public E poll() {
        return queue.removeFirst().getObject();
    }

    public boolean isEmpty() {
        return queue.getHead() == null;
    }

    public int size() {
        return queue.size();
    }

    public E[] toArray() {
        IteratorForQueue iterator = iterator();
        E[] array = (E[]) new Object[queue.size()];
        for (int i = 0; i < queue.size(); i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder toPrint = new StringBuilder("MyQueue: ");
        if (!isEmpty()) {
            for (MyLinkedList.Node<E> eNode : queue) {
                toPrint.append(eNode.getObject());
                toPrint.append(", ");
            }
            toPrint.deleteCharAt(toPrint.length() - 1);
            toPrint.deleteCharAt(toPrint.length() - 1);
        }
        return toPrint.toString();
    }


    @Override
    public IteratorForQueue iterator() {
        return new IteratorForQueue();
    }

    public class IteratorForQueue implements Iterator<E> {
        private MyLinkedList.Node<E> currentElement;
        private boolean hasNextElement;

        public IteratorForQueue() {
            this.currentElement = queue.getHead();
            this.hasNextElement = (currentElement != null);
        }

        @Override
        public boolean hasNext() {
            return hasNextElement;
        }

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
