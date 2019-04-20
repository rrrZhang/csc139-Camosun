package Collections139;

/**
 * BinarySearchTreeADT defines the interface to a binary search tree.
 * @param <T>
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {

  /**
   * Adds the specified element to the proper location in this tree.
   *
   * @param element the element to be added to this tree
   */
  public void add(T element);

  
  /**
   * Returns the smallest element in this tree without removing it.
   *
   * @return the smallest element in the tree
   */
  public T findMin();

  /**
   * Returns the largest element in this tree without removing it.
   *
   * @return the largest element in the tree
   */
  public T findMax();
}
