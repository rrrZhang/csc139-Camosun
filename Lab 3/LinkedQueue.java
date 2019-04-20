package collections;

import exceptions.EmptyQueueException;

/**
 * LinkedQueue.java This class implements the interface QueueADT using link.
 * There are two variables from SinglyLinkedNode class track the first element
 * of the queue and the last element of the queue. When implementing method
 * remove, make sure to deal with the empty spots in the array
 *
 * @author Rena Zhang
 * @vision 1.6
 * @since 2017-03-03
 */
public class LinkedQueue<T> implements QueueADT<T> {

    SinglyLinkedNode<T> head, tail;

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);//element = node

        if (isEmpty()) {//if queue is empty
            head = node;
        } else {//is queue is not empty
            tail.setNext(node);//set the node to the next elemnt of tail
        }
        tail = node;//set the tail reference to the node
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws EmptyQueueException if an empty collection exception occurs
     */
    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        } else {//if queue is not empty
            T result = head.getElement();//generic type's variable result = head
            head = head.getNext();//set head reference to the next element
            if (isEmpty()) {//check if the queue is empty
                tail = null;//if queue is empty, set tail reference to null
            }
            return result;//return the result
        }
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     * @throws EmptyQueueException if an empty collection exception occurs
     */
    @Override
    public T first() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        } else {//if queue is not empty
            T result = head.getElement();//generic type's variable result = head
            return result;//return the result
        }
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (head == null);//if head = null, then queue is empty, return true
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    @Override
    public int size() {
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();//create variable temp
        temp = head;//set temp = head
        int counter = 0;//create variable counter and initilize to 0
        while (temp != null) {//if temp not = to the null(next element of tail)
            counter++;
            temp = temp.getNext();//set temp to the next the element
        }
        return counter;//return counter
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString() {
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();//create variable temp
        temp = head;//set temp = head
        String s = "";//set string s to empty
        while (temp != null) {//if temp not = to the null(next element of tail)
            s = s + temp.getElement();
            temp = temp.getNext();//set temp to the next the element
        }
        return s;//retuen s
    }

}
