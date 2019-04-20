package animals;

import javax.swing.JTextArea;
import exceptions.*;

/**
 * Animals.java This program creates three variables, and uses set and get
 * methods to let user input the different values of the variables, and creates
 * the method display and toString
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class Animals {

    /**
     * Creates the variable integer age
     */
    private int age;
    /**
     * Creates the variable string name
     */
    private String name;
    /**
     * creates the variables double weight
     */
    private double weight;

    /**
     * Constructor initializes the three variables and throws the exceptions
     *
     * @param name initializes the name
     * @param weight initializes the weight
     * @param age initializes the age
     * @throws InvalidNameException Throws name input less than two characters
     * @throws InvalidWeightException Throws weight input less than 0
     */
    public Animals(String name, double weight, int age) throws
            InvalidNameException, InvalidWeightException {

        if (name.length() >= 2) {
            this.name = name;
        } else {
            throw new InvalidNameException("Name must be at least 2 characters");
        }
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new InvalidWeightException("Weight must be greater than zero");
        }
        this.age = age;
    }

    /**
     * Sets the name and from user input
     *
     * @param newName sets the name to the user input
     * @throws InvalidNameException Throws name input less than two characters
     */
    public void setName(String newName) throws InvalidNameException {
        if (newName.length() >= 2) {
            name = newName;
        } else {
            throw new InvalidNameException("Name must be at least 2 characters");
        }

    }

    /**
     * Gets the name from the user input
     *
     * @return Returns the user input name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the weight and from user input
     *
     * @param newWeight sets the weight to the user input
     * @throws InvalidWeightException Throws weight input less than 0
     */
    public void setWeight(double newWeight) throws InvalidWeightException {
        if (weight > 0) {
            weight = newWeight;
        } else {
            throw new InvalidWeightException("Weight must be greater than zero");
        }
    }

    /**
     * Gets the weight from the user input
     *
     * @return Returns the user input weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the age and from user input
     *
     * @param newAge set the age to the user input
     */
    public void setAge(int newAge) {
        age = newAge;
    }

    /**
     * Gets the age from the user input
     *
     * @return Returns the user input age
     */
    public int getAge() {
        return age;
    }

    /**
     * Displays the three variables on the text area
     *
     * @param output Displays the three variables on the text area
     */
    public void display(JTextArea output) {
        output.append("name: " + name + "\t"
                + "age: " + age + "\t"
                + "weight: " + weight + "\t");
    }

    /**
     * Creates the toString method and variable description to display a string
     *
     * @return describes the String of toString
     */
    public String toString() {
        String description = "name: " + name + "\t"
                + "age: " + age + "\t"
                + "weight: " + weight + "\t";
        return description;
    }

}
