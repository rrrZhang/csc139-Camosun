package animals;

import animals.Animals;
import exception.*;
import javax.swing.JTextArea;

/**
 * Reptile.java This programs inheritances the animals class, and uses set and
 * get methods to let user input the length variable.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class Reptile extends Animals {

    /**
     * Creates the variable integer length
     */
    private int length;

    /**
     * Constructor inheritances the name, weight, age variables from the animals
     * class, initializes the length variables and throws the exceptions
     *
     * @param name inheritances the name
     * @param weight inheritances the weight
     * @param age inheritances the age
     * @throws InvalidNameException Throws name input less than two characters
     * @throws InvalidWeightException Throws weight input less than 0
     */
    public Reptile(String name, double weight, int age, int length) throws
            InvalidNameException, InvalidWeightException {
        super(name, weight, age);
        this.length = length;
    }

    /**
     * Sets the length and from user input
     *
     * @param newLength set the length to the user input
     */
    public void setLength(int newLength) {
        length = newLength;
    }

    /**
     * Gets the length from the user input
     *
     * @return length Returns the user input length
     */
    public int getLength() {
        return length;
    }

    /**
     * Inheritances the display method and adds length to the display method
     *
     * @param output Displays the four variables on the text area
     */
    @Override
    public void display(JTextArea output) {
        super.display(output);
        output.append("length: " + length + "\n");
    }

    /**
     * Creates the toString method and variable description to display a string
     *
     * @return description describes the String of toString
     */
    @Override
    public String toString() {
        String description = super.toString() + "length: " + length + "\n";
        return description;
    }
}
