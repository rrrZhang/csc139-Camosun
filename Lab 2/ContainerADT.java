package container;

import exception.*;
import java.util.NoSuchElementException;

/**
 * ContainerADT.java Define the interface to a container collection
 *
 * @author Rena Zhang
 * @vision 1.6
 * @since 2017-02-06
 */
public interface ContainerADT<T> {

    /**
     * Adds an element to the container, expanding the capacity of the container
     * when necessary
     *
     * @param element element to be added onto the container
     */
    public void add(T element);

    /**
     * Removes a random element from the container. An EmptyContainerException
     * is thrown if the container is empty
     *
     * @return element from the bag
     * @throws EmptyContainerException throws when container is empty
     */
    public T removeRandom() throws EmptyContainerException;

    /**
     * Removes and returns an occurrence of the specified element from the
     * container
     *
     * @param element element to be removed from the container
     * @return element from container specified by the parameter
     * @throws EmptyContainerException throws when container is empty
     * @throws NoSuchElementException throws when an element can not be found
     */
    public T remove(T element) throws EmptyContainerException, NoSuchElementException;

    /**
     * Clears the contents of the container
     */
    public void clear();

    /**
     * Returns true if the container contains the parameter otherwise it returns
     * false
     *
     * @param tagert element
     * @return boolean to specify if the element already exists in the container
     */
    public boolean contains(T target);

    /**
     * Returns true if this container contains no elements
     *
     * @return boolean value that indicates if container is empty or not
     */
    public boolean isEmpty();

    /**
     * Returns the maximum size of the container
     *
     * @return the size of the container
     */
    public int maxSize();

    /**
     * Returns the number of elements in the container
     *
     * @return number of elements in the container
     */
    public int size();

    /**
     * Returns a string representation of the container
     *
     * @return String
     */
    public String toString();

}


