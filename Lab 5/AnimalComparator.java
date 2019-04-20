package collections;

import java.util.Comparator;
import animals.*;

/**
 * AnimalsComparator.java This program implements the Comparator interface. 
 * Implement method compare so it compares animals by kind (Mammals should be 
 * listed before Reptiles).
 * 
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-03-29
 */
public class AnimalComparator<T> implements Comparator<T> {

    @Override
    public int compare(T obj1, T obj2) {//compare two generic objects
        if (obj1 instanceof Mammal && obj2 instanceof Mammal
                || obj1 instanceof Reptile && obj2 instanceof Reptile) {
            return 0;//if ob1=ob2=Mammal or ob1=ob2=Reptile, no need change, return 0
        } else if (obj1 instanceof Mammal && obj2 instanceof Reptile) {
            return -1;//if ob1=Mammal and ob2=Reptile, no need to change, return negative value
        } else {//if ob1=Reptile and ob2=Mammal, need to change the order 
            return 1;//return positive value
        }
    }
}
