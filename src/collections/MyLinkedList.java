package collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class MyLinkedList<E> implements Iterable<MyLinkedList.Node<E>> {
    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
        Node<E> head = null;
        Node<E> tail = null;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    // == addLast
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

    public void addFirst() {
        addFirst(null);
    }

    public void addFirst(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Can`t add null object");
        }
        if (head == null) {
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

    public void addLast(E object) {
        if (object == null) {
            throw new IllegalArgumentException("Can`t add null object");
        }
        if (head == null) {
            head = new Node<>(object, null, null);
            tail = head;
            return;
        }
        if (head == tail) {
            tail = new Node<>(object, tail, null);
            tail.previous = head;
            head.next = tail;
            return;
        }
        Node<E> oldTail = tail;
        tail = new Node<>(object, oldTail, null);
        oldTail.next = tail;
        return;
    }

    public void set(E oldObject, E newObject) {
        if (oldObject == null || newObject == null) {
            throw new IllegalArgumentException("Can`t replace null element or to element");
        }
        if (contains(oldObject) == null) {
            throw new IllegalArgumentException("The MyLinkedList doesn`t contain the object you want to replace");
        }
        contains(oldObject).object = newObject;
    }

    public Node<E> contains(E object) {
        if (head == null){
            return null;
        }
        if (tail.object.equals(object)) {
            return tail;
        }
        IteratorMLL iterator = (IteratorMLL) iterator();
        while (iterator.hasNext()) {
            Node<E> nodeToCheck = iterator.next();
            if (nodeToCheck.getObject().equals(object)) {
                return nodeToCheck;
            }
        }
        return null;
    }

    public Node<E> getFirst() {
        return head;
    }

    public Node<E> getLast() {
        return tail;
    }

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

    public void remove(E object) {
        if (head == null) {
            throw new IndexOutOfBoundsException("Can`t remove anything from the empty MyLinkedList");
        }
        if (object == null) {
            throw new IllegalArgumentException("Can`t remove null element");
        }
        if (contains(object) == null) {
            throw new IllegalArgumentException("No such element in MyLinkedList");
        }
        if (contains(object) == head) {
            removeFirst();
            return;
        }
        if (contains(object) == tail) {
            removeLast();
            return;
        }
        Node<E> nodeToRemove = contains(object);
        nodeToRemove.previous.next = nodeToRemove.next;
        nodeToRemove.next.previous = nodeToRemove.previous;
    }

    public int size() {
        int size = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public E[] toArray() {
        IteratorMLL iterator = (IteratorMLL) iterator();
        E[] array = (E[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = iterator.next().getObject();
        }
        return array;
    }


    @Override
    public String toString() {
        IteratorMLL iterator = (IteratorMLL) iterator();
        StringBuilder toPrint = new StringBuilder("MyLinkedList: ");
        while (iterator.hasNext()){
            toPrint.append(iterator.next().getObject());
            toPrint.append(", ");
            if (!iterator.hasNext()){
                toPrint.deleteCharAt(toPrint.length() - 1);
                toPrint.deleteCharAt(toPrint.length() - 1);
            }
        }
        return toPrint.toString();
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new IteratorMLL();
    }

    public static class Node<E> {
        E object;
        Node<E> previous;
        Node<E> next;

        public E getObject() {
            return object;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node(E object, Node<E> previous, Node<E> next) {
            this.object = object;
            this.previous = previous;
            this.next = next;
        }
    }

    public class IteratorMLL implements Iterator<Node<E>> {
        private Node<E> currentNode;
        private boolean hasNextNode = false;

        public IteratorMLL() {
            this.currentNode = head;
            this.hasNextNode = (currentNode != null);
        }

        @Override
        public boolean hasNext() {
            return hasNextNode;
        }

        @Override
        public Node<E> next() {
            if (!hasNextNode) {
                throw new NoSuchElementException("No more elements in the list");
            }
            Node<E> nodeToReturn = currentNode;
            hasNextNode = (nodeToReturn.next != null);
            currentNode = currentNode.getNext();
            return nodeToReturn;
        }
    }
}

