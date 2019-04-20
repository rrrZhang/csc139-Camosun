package Collections139;

import java.util.Arrays;
import java.util.Iterator;
import exceptions.*;
import java.util.ArrayList;

/**
 * ArrayBinaryTree.java This program implements BinaryTreeADT and
 * BinarySearchTreeADT interfaces using a computational array strategy. In
 * computational strategy, for any element stored in position n of the array,
 * that element's left child will be stored in position ( (2 * n ) + 1) and that
 * element’s right child will be stored in position ( (2 * n) + 2). There are
 * two constructors. One that creates an empty tree and one that creates a tree
 * with a specified element (received by parameter) as its root.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-04-07
 */
public class ArrayBinaryTree<T> implements BinaryTreeADT<T>,
        BinarySearchTreeADT<T> {

    public T[] tree;//create a generic type array called tree

    public ArrayBinaryTree() {
        tree = (T[]) new Object[100];//create a empty tree, set array length is 100
    }

    public ArrayBinaryTree(T element, int newCapacity) {
        tree[0] = element;//creates a tree with a specified element as its root
        tree = (T[]) (new Object[newCapacity]);//if length is over, expand
    }

    private void expandCapacity() {
        tree = Arrays.copyOf(tree, tree.length * 2);//expand the length
    }

    /**
     * Returns a reference to the root element
     *
     * @return a reference to the root
     */
    @Override
    public T getRootElement() {
        return tree[0];
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return tree[0] == null;
    }

    /**
     * Returns the number of elements in this binary tree.
     *
     * @return the number of elements in the tree
     */
    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < tree.length; i++) {//use loop go through the array
            if (tree[i] != null) {//if array element spot is not empty, size++
                size++;
            }
        }
        return size;
    }

    /**
     * Returns true if the binary tree contains an element that matches the
     * specified element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    @Override
    public boolean contains(T targetElement) {
        boolean found = false;
        for (int i = 0; i < tree.length; i++) {
            if (targetElement.equals(tree[i])) {
                found = true;
            }
        }
        return found;
    }

    /**
     * Returns a reference to the specified element if it is found in this
     * binary tree. Throws an exception if the specified element is not found.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     * @throws NoSuchElementException if the specified element is not found.
     */
    @Override
    public T find(T targetElement) throws NoSuchElementException {
        boolean found = false;
        T result = null;

        for (int i = 0; i < tree.length && !found; i++) {
            if (targetElement.equals(tree[i])) {
                found = true;
                result = tree[i];
            }
        }
        if (!found) {
            throw new NoSuchElementException("Can not find element");
        }
        return result;
    }

    /**
     * Returns an iterator over the elements of this tree. Return an inOrder
     * iterator.
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iterator() {
        return this.iteratorInOrder();
    }

    /**
     * Returns an iterator that represents an inOrder traversal on this binary
     * tree. Starts with root.
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        inOrder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive inOrder traversal
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list fro use in this traversal
     */
    protected void inOrder(int node, ArrayList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                inOrder(node * 2 + 1, tempList);
                tempList.add(tree[node]);
                inOrder(node * 2 + 2, tempList);
            }
        }
    }

    /**
     * Returns an iterator that represents a preOrder traversal on this binary
     * tree. Starts with root.
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        preOrder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive preOrder traversal
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list fro use in this traversal
     */
    protected void preOrder(int node, ArrayList<T> tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                tempList.add(tree[node]);
                preOrder(node * 2 + 1, tempList);
                preOrder(node * 2 + 2, tempList);
            }
        }

    }

    /**
     * Returns an iterator that represents a postorder traversal on this binary
     * tree. Starts with root.
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        postOrder(0, tempList);

        return tempList.iterator();
    }

    /**
     * Performs a recursive postOrder traversal
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list fro use in this traversal
     */
    protected void postOrder(int node, ArrayList tempList) {
        if (node < tree.length) {
            if (tree[node] != null) {
                postOrder(node * 2 + 1, tempList);
                postOrder(node * 2 + 2, tempList);
                tempList.add(tree[node]);
            }
        }
    }

    /**
     * Returns an iterator that represents a levelOrder traversal on the binary
     * tree. Starts with root.
     *
     * @return an iterator over the elements of this binary tree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() {
        ArrayList<T> tempList = new ArrayList<T>();
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                tempList.add(tree[i]);
            }
        }
        return tempList.iterator();
    }

    /**
     * Adds the specified element to the proper location in this tree.
     *
     * @param element the element to be added to this tree
     */
    @Override
    public void add(T element) {
        int node = 0;
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty()) {//is array is empty, add to the root
            tree[0] = element;
        } else {
            if (comparableElement.compareTo(tree[0]) < 0) {//element < root, add to left
                if (tree[node * 2 + 1] == null) {//if left child is empty, add to there
                    tree[node * 2 + 1] = element;
                } else {//if left child is not empty, go to left again, resursive call
                    add(element, node * 2 + 1);
                }
            } else {//element > root, add to right
                if (tree[node * 2 + 2] == null) {//if right child is empty, add to there
                    tree[node * 2 + 2] = element;
                } else {//if right child is not empty, go to right again, resursive call
                    add(element, node * 2 + 2);
                }
            }
        }
    }

    /**
     * Performs a recursive add element for go to left child or right child
     *
     * @param element the element to be added to the array
     * @param index the spot of the left child or right child gonna be checked
     */
    private void add(T element, int index) {
        if (tree.length < (index * 2 + 2)) {
            expandCapacity();
        }
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (comparableElement.compareTo(tree[index]) < 0) {
            if (tree[index * 2 + 1] == null) {
                tree[index * 2 + 1] = element;
            } else {
                add(element, index * 2 + 1);
            }
        } else {
            if (tree[index * 2 + 2] == null) {
                tree[index * 2 + 2] = element;
            } else {
                add(element, index * 2 + 2);
            }
        }
    }

    /**
     * Returns the smallest element in this tree without removing it.
     *
     * @return the smallest element in the tree
     */
    @Override
    public T findMin() {
        int node = 0;
        while ((node * 2 + 1 <= tree.length) && (tree[node * 2 + 1] != null)) {
            node = node * 2 + 1;
        }
        return tree[node];
    }

    /**
     * Returns the largest element in this tree without removing it.
     *
     * @return the largest element in the tree
     */
    @Override
    public T findMax() {
        int node = 0;
        while ((node * 2 + 2 <= tree.length) && (tree[node * 2 + 2] != null)) {
            node = node * 2 + 2;
        }
        return tree[node];
    }

    /**
     * Returns the string representation of this binary tree.
     *
     * @return a string representation of the binary tree
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                s = s + tree[i];
            }
        }
        return s;
    }
}
