package collections;

import exception.*;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/*
 * LinkedList.java This class implements the interface ListADT using link.
 * There are fours variables. Two from the SinglyLinkedNode class, onr for 
 * tracking the first the element, one for tracking the last element. And 
 * another two variables, one for count how many elements, and one for count 
 * hoe many time the list been modified.
 * @author Rena Zhang
 * @vision 1.6
 * Created on March 17, 2017
 *
 */
public class LinkedList<T> implements ListADT<T>, Iterable<T> {

    protected int count;
    protected SinglyLinkedNode<T> head, tail;
    protected int modCount;

    public LinkedList() {
        count = 0;
        head = tail = null;
        modCount = 0;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            T result = head.getElement();
            head = head.getNext();
            if (head ==null)
                tail = null;
            count--;
            modCount++;
            return result;
        }
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            SinglyLinkedNode<T> previous = null;
            SinglyLinkedNode<T> current = head;
            while (!current.equals(tail)) {
                previous = current;
                current = current.getNext();
            }
            if (tail==head) {
                tail = head = null;
            } else {
                tail = previous;
                tail.setNext(null);
            }
            count--;
            modCount++;
            return current.getElement();
        }

    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            boolean found = false;
            SinglyLinkedNode<T> previous = null;
            SinglyLinkedNode<T> current = head;

            while (current != null && !found) {
                if (element.equals(current.getElement())) {
                    found = true;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            if (!found) {
                throw new ElementNotFoundException("There is no such element");
            }
            if (size() == 1) {
                head = tail = null;
            } else if (current.equals(head)) {
                head = current.getNext();
            } else if (current.equals(tail)) {
                tail = previous;
                tail.setNext(null);
            } else {// element is in the middle
                previous.setNext(current.getNext());
            }
            count--;
            modCount++;
            return current.getElement();
        }
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            return head.getElement();
        }
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     */
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            return tail.getElement();
        }
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("List is empty");
        } else {
            boolean found = false;
            SinglyLinkedNode<T> current = head;
            while (!found && current != null) {
                if (target.equals(current.getElement())) {
                    found = true;
                }
                current = current.getNext();
            }
            return found;
        }
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the integer representation of number of elements in this list
     */
    @Override
    public int size() {
        int size = count;
        return size;
    }

    /**
     * Returns an iterator for the elements in this list.
     *
     * @return an iterator over the elements in this list
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        SinglyLinkedNode<T> current = head;
        String s = "";
        while (current != null) {
            s = s + current.getElement();
            current = current.getNext();
        }
        return s;
    }

    /**
     * MyIterator represents and iterator for a linked list of linear nodes.
     *
     */
    private class MyIterator implements Iterator<T> {

        private int iteratorModCount;// the number of element in the collection
        private SinglyLinkedNode<T> current;//the current position

        /**
         * Set up this iterator using the specified items
         *
         * @param collection the collection the iterator will move over
         * @param size the integer size of the collection
         */
        public MyIterator() {
            current = head;
            iteratorModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element to
         * deliver in the iterator
         *
         * @return true if this iterator has at least one more element to
         * deliver in the iterator
         * @throws ConcurrentModificationException if the collect has changed
         * while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (current != null);
        }

        /**
         * Returns the next element in the iteration. If there are no more
         * elements in this iteration, a NoSuchElementException is thrown
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException is the iterator is empty
         */
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new ElementNotFoundException("There is no next element");
            } else {
                T result = current.getElement();
                current = current.getNext();
                return result;
            }
        }

        /**
         * The remove operation is not supported
         *
         * @throws UnsupportedOperationException if the remove operation is
         * called
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
