package container;

import exception.*;
import java.util.Arrays;
import java.util.Random;
import java.util.NoSuchElementException;

/**
 * ArrayContainer.java This class implements the interface ContainerADT using an
 * array. a default constructor that creates a container for 100 elements and a
 * constructor that receives container capacity by parameter. When implementing
 * method remove, make sure to deal with the empty spots in the array
 *
 * @author Rena Zhang
 * @vision 1.6
 * @since 2017-02-06
 */
public class ArrayContainer<T> implements ContainerADT<T> {

    private int top = 0; //creates instance variable top and initializes to 0
    public T[] container; //create a generic array called container

    /**
     * Creates an empty generic array container and set array size to 100
     */
    public ArrayContainer() {
        T[] container = (T[]) new Object[100];
    }

    /**
     * Creates an empty container using the specified capacity.
     *
     * @param newCapacity the specified size of the array
     */
    public ArrayContainer(int newCapacity) {
        container = (T[]) (new Object[newCapacity]);
    }

    /**
     * Adds an element to the container, expanding the capacity of the container
     * when necessary
     *
     * @param element element to be added onto the container
     */
    @Override
    public void add(T element) {
        if (top == container.length) {
            expandCapacity(); //if the array is full, call expandCapacity method
        }
        container[top] = element;
        top++;
    }

    /**
     * Creates a new array to store the contents of this container with twice
     * the capacity of the old one.
     */
    private void expandCapacity() {
        container = Arrays.copyOf(container, container.length * 2);
    }

    /**
     * Removes a random element from the container. An EmptyContainerException
     * is thrown if the container is empty
     *
     * @return element from the bag
     * @throws EmptyContainerException throws when container is empty
     */
    @Override
    public T removeRandom() throws EmptyContainerException {
        Random random = new Random();
        if (isEmpty()) { //if array is empty, throw the exception
            throw new EmptyContainerException("Container is empty");
        } else {
            int e = random.nextInt(top); // int e equal to random number
            T result = container[e];
            container[e] = null; // make e element blank
            for (int i = e; i < top - 1; i++) {
                container[i] = container[i + 1];
            } //shift the array to make sure array no blank
            top--;
            return result;
        }
    }

    /**
     * Removes and returns an occurrence of the specified element from the
     * container
     *
     * @param element element to be removed from the container
     * @return element from container specified by the parameter
     * @throws EmptyContainerException throws when container is empty
     * @throws NoSuchElementException throws when an element can not be found
     */
    @Override
    public T remove(T element) throws EmptyContainerException, NoSuchElementException {
        T result = null;
        if (isEmpty()) { //if array is empty, throw the exception
            throw new EmptyContainerException("Container is empty");
        } else if (!contains(element)) {//if element can not found,  throw exception
            throw new NoSuchElementException("Element can not be found");
        } else {
            for (int i = 0; i < top; i++) {//use loop looking for element
                if (container[i].equals(element)) {
                    result = container[i];
                    container[i] = null;//set i element to blank
                    for (int m = i; m < top - 1; m++) {
                        container[m] = container[m + 1];
                    } //shift the array to make sure array no blank
                    top--;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Clears the contents of the container
     */
    @Override
    public void clear() {
        top = 0;
    }

    /**
     * Returns true if the container contains the parameter otherwise it returns
     * false
     *
     * @param tagert element
     * @return boolean to specify if the element already exists in the container
     */
    @Override
    public boolean contains(T target) {
        int i = 0;
        boolean done = false;
        while (!done && (i < container.length)) { //use loop looking for target
            if (container[i++].equals(target)) {
                done = true;
            }
        }
        return done;
    }

    /**
     * Returns true if this container contains no elements
     *
     * @return boolean value that indicates if container is empty or not
     */
    @Override
    public boolean isEmpty() {
        return (top == 0);
    }

    /**
     * Returns the maximum size of the container
     *
     * @return the size of the container
     */
    @Override
    public int maxSize() {
        int size = 0;
        for (int i = 0; i < container.length; i++) {
            size++;//int size track the size of the container
        }
        return size;
    }

    /**
     * Returns the number of elements in the container
     *
     * @return number of elements in the container
     */
    @Override
    public int size() {
        int size = top;
        return size;
    }

    /**
     * Returns a string representation of the container
     *
     * @return String
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < top; i++) {
            s = s + container[i] + "\n";
        }//use loop to know what the container contains 
        return s;
    }

}

