package collections;

/**
 * LinkedOrderedList.java This program implements OrderedListADT and extends
 * LinkedList class. Method add in the LinkedOrderdList adds animals to the list
 * in the order specified by the method compareTo in the Animal class. There are
 * four cases to add, if list is empty, add to the head, add to the tail and add
 * to the middle. every time add, count and modCount both plus one.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-03-17
 */
public class LinkedOrderedList<T extends Comparable<T>> extends LinkedList<T>
        implements OrderedListADT<T> {

    @Override
    public void add(T element) {

        SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(element);
        SinglyLinkedNode<T> current = head;
        SinglyLinkedNode<T> previous = null;

        if (isEmpty()) {//if the list is empty
            head = tail = node;
        } else if (head.getElement().compareTo(element) >= 0) {//add to the head
            node.setNext(head);
            head = node;
        } else if (tail.getElement().compareTo(element) <= 0) {//add to the tail
            tail.setNext(node);
            tail = node;
        } else {//add to the middle
            while (current != null && current.getElement().compareTo(element) <= 0) {
                previous = current;
                current = current.getNext();
            }
            node.setNext(current);
            //no need: previous.setNext(node);
            previous = node;
        }
        count++;
        modCount++;
    }
}
