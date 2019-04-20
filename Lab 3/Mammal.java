package animals;

import javax.swing.JTextArea;
import exceptions.*;

/**
 * Mammal.java This programs inheritances the animals class, and uses set and
 * get methods to let user input the hairColor variable.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class Mammal extends Animals {

    /**
     * Creates the variable String hairColor
     */
    private String hairColor;

    /**
     * Constructor inheritances the name, weight, age variables from the animals
     * class, initializes the hairColor variables and throws the exceptions
     *
     * @param name inheritances the name
     * @param weight inheritances the weight
     * @param age inheritances the age
     * @throws InvalidNameException Throws name input less than two characters
     * @throws InvalidWeightException Throws weight input less than 0
     */
    public Mammal(String name, double weight, int age, String hairColor) throws
            InvalidNameException, InvalidWeightException {
        super(name, weight, age);
        this.hairColor = hairColor;
    }

    /**
     * Sets the hairColor and from user input
     *
     * @param newHairColor set the hairColor to the user input
     */
    public void setHairColor(String newHairColor) {
        hairColor = newHairColor;
    }

    /**
     * Gets the hairColor from the user input
     *
     * @return Returns the user input hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * Inheritances the display method and adds hairColor to the display method
     *
     * @param output Displays the four variables on the text area
     */
    public void display(JTextArea output) {
        super.display(output);
        output.append("skin/fur color: " + hairColor + "\n");
    }

    /**
     * Creates the toString method and variable description to display a string
     *
     * @return describes the String of toString
     */
    public String toString() {
        String description = super.toString() + "skin/fur color: " + hairColor + "\n";
        return description;
    }
}
