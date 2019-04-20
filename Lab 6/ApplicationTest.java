package Collections139;

import exceptions.*;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * ApplicationTest.java This program tests all the method from ArrayBinaryTree
 * class. Creates a object aTree of ArrayBinaryTree of Integer type. Use loop to
 * test the all iterator method, and use try-catch test the find method.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-04-07
 */
public class ApplicationTest<T> {

    static public void main(String[] argv) {
        ArrayBinaryTree<Integer> aTree = new ArrayBinaryTree();

        aTree.add(4);//add element 4, which is root
        aTree.add(2);//add element 2
        aTree.add(6);//add element 6
        aTree.add(1);//add element 1
        aTree.add(3);//add element 3
        aTree.add(5);//add element 5
        aTree.add(7);//add element 7

        try {// test can find element 9 or not
            aTree.find(9);
            System.out.println("We can find the element 9");//if can find, return message
        } catch (NoSuchElementException ex) {//if can not find, throw exception
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "element",
                    JOptionPane.ERROR_MESSAGE);
        }

        try {// test can find element 4 or not
            aTree.find(4);
            System.out.println("We can find the element 4");//if can find, return message
        } catch (NoSuchElementException ex) {//if can not find, throw exception
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "element",
                    JOptionPane.ERROR_MESSAGE);
        }

        Iterator<Integer> ite = aTree.iterator();//test iterator method
        String s = "Tree Inorder(try iterator method): ";
        while (ite.hasNext()) {
            Integer obj = ite.next();
            s = s + obj;
        }
        System.out.println(s);//display tree in inorder

        Iterator<Integer> iter = aTree.iteratorInOrder();//test iteratorInorder method
        String st = "Tree Inorder: ";
        while (iter.hasNext()) {
            Integer obj = iter.next();
            st = st + obj;
        }
        System.out.println(st);//display tree in inorder

        Iterator<Integer> itera = aTree.iteratorPreOrder();//test iteratorPreOrder method
        String sta = "Tree PreOrder: ";
        while (itera.hasNext()) {
            Integer obj = itera.next();
            sta = sta + obj;
        }
        System.out.println(sta);//display tree in preorder

        Iterator<Integer> iterat = aTree.iteratorPostOrder();//test iteratorPostOrder method
        String stat = "Tree PostOrder: ";
        while (iterat.hasNext()) {
            Integer obj = iterat.next();
            stat = stat + obj;
        }
        System.out.println(stat);//display tree in postorder

        Iterator<Integer> iterato = aTree.iteratorLevelOrder();
        String v = "Tree LevelOrder: ";
        while (iterato.hasNext()) {
            Integer obj = iterato.next();
            v = v + obj;
        }
        System.out.println(v);//display tree in levelorder

        System.out.println(
                "ToString: " + aTree.toString() + "\n"//test toString method
                + "root: " + aTree.getRootElement() + "\n"//test getRootElement method
                + "Is tree empty?  Answer: " + aTree.isEmpty() + "\n"//test isEmpty method
                + "Does tree contain 3?  Answer: " + aTree.contains(3) + "\n"//test contains method
                + "Does tree contain 9?  Answer: " + aTree.contains(9) + "\n"//test contains method
                + "size: " + aTree.size() + "\n"//test size method
                + "max: " + aTree.findMax() + "\n"//test findMax method
                + "min: " + aTree.findMin());//test findMin method
    }
}
