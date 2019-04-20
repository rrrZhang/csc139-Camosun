package collections;

/*
 * AnimalQueueFrame.java
 * @author Jadwiga Downarowicz
 * Created on May 11, 2012
 * A Swing frame for adding the information about an animal 
 * and storing the animal in the queue
 */
import animals.Animals;
import animals.*;
import exception.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.*;

public class AnimalGUI extends JFrame implements ActionListener {

    /**
     * GUI component for getting the name
     */
    private GetInputPanel namePanel = null;
    /**
     * GUI component for getting the weight
     */
    private GetInputPanel weightPanel = null;
    /**
     * GUI component for getting the age
     */
    private GetComboPanel agePanel = null;
    /**
     * GUI component for getting the number of legs
     */
    private GetComboPanel lengthPanel = null;
    /**
     * GUI component for getting the color
     */
    private GetInputPanel colorPanel = null;
    /**
     * Button for adding a reptile to the collection
     */
    private final JButton addReptileButton = new JButton("Add Reptile");
    /**
     * Button for adding a reptile to the collection
     */
    private final JButton addMammalButton = new JButton("Add Mammal");
    /**
     * Button for viewing the next animal in the queue
     */
    private final JButton sortByAgeButton = new JButton("Sort By Age");
    /**
     * Button for displaying animals in the collection
     */
    private final JButton displayAnimalsButton = new JButton("Display Animals");
    /**
     * A temporary GUI component for validating data
     */
    private final JTextArea verifyArea = new JTextArea(18, 25);
    /**
     * Button for removing an animal from the collection
     */
    private final JButton sortByKindButton = new JButton("Sort By Kind");

    private ArrayList<Animals> animalList = new ArrayList<Animals>();

    /**
     * Creates a new instance of AddAnimalFrame which is contains panels and
     * other GUI components
     */
    public AnimalGUI() {
        super("List of Animals");
        createGUI();
    }

    /**
     * main() instantiates an object
     *
     * @param argv
     */
    static public void main(String[] argv) {
        AnimalGUI animalFrame = new AnimalGUI();
        animalFrame.setSize(700, 800);
        animalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * A method to create GUI components
     */
    private void createGUI() {
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout(5, 5));

        JPanel inputPanel = new JPanel();   //contains GUI to input animals info
        inputPanel.setLayout(new GridLayout(5, 1));
        namePanel = new GetInputPanel(20, "     Animal's Name: ");
        inputPanel.add(namePanel);
        weightPanel = new GetInputPanel(6, "   Animal's Weight (lb): ");
        inputPanel.add(weightPanel);
        agePanel = new GetComboPanel("    Animal's Age (years):", 125);
        inputPanel.add(agePanel);
        lengthPanel = new GetComboPanel("Reptile's Length (cm)", 1000);
        inputPanel.add(lengthPanel);
        colorPanel = new GetInputPanel(20, "Mammal's skin/fur color");
        inputPanel.add(colorPanel);

        JPanel buttonPanel = new JPanel();  //contains buttons
        buttonPanel.setLayout(new GridLayout(1, 5, 5, 5));
        addReptileButton.setToolTipText("Press to add Reptile");
        addMammalButton.setToolTipText("Press to add Mammal");
        buttonPanel.add(addReptileButton);
        buttonPanel.add(addMammalButton);
        buttonPanel.add(sortByAgeButton);
        buttonPanel.add(sortByKindButton);
        buttonPanel.add(displayAnimalsButton);

        c.add(inputPanel, BorderLayout.NORTH);
        c.add(buttonPanel, BorderLayout.CENTER);
        //c.add(verifyArea, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(verifyArea);
        c.add(scrollPane, BorderLayout.SOUTH);

        addReptileButton.addActionListener(this);
        addMammalButton.addActionListener(this);
        displayAnimalsButton.addActionListener(this);
        sortByAgeButton.addActionListener(this);
        sortByKindButton.addActionListener(this);

        setVisible(true);
        pack();
    }

    /**
     * Responds to the "Display" and "Add" buttons
     *
     * @param ev The button press event
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        Object object = ev.getSource();
        if (object == addReptileButton) {//if buttom clicks the reptile button

            try {
                Reptile r = new Reptile(namePanel.getText(),
                        weightPanel.getValue(), agePanel.getValue(),
                        lengthPanel.getValue());//creat a object r of reptile class
                animalList.add(r);//enqueue the r to the queue

            } catch (InvalidNameException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on name 
            } catch (InvalidWeightException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on weight
            }
        } else if (object == addMammalButton) {//if buttom clicks the mammal button

            try {
                Mammal m = new Mammal(namePanel.getText(),
                        weightPanel.getValue(), agePanel.getValue(),
                        colorPanel.getText());//creat a object m of mammal class
                animalList.add(m);//enqueue the m to the queue

            } catch (InvalidNameException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on name 
            } catch (InvalidWeightException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on weight
            }
        } else if (object == sortByAgeButton) {//if buttom clicks sortByAge button

            Collections.sort(animalList);//sort animals by age ascending order

        } else if (object == sortByKindButton) {//if buttom clicks sortByKind button

            AnimalComparator animalComparator = new AnimalComparator();
            Collections.sort(animalList, animalComparator);//sort Mammal animals first

        } else {
            verifyArea.append("size: " + animalList.size() + "\n");//display size

            Iterator<Animals> ite = animalList.iterator();//create a iterator object
            while (ite.hasNext()) {//while ite object has next, go inside the loop
                Animals obj = ite.next();
                verifyArea.append(obj + "");//display all animals in the array 
            }
        }
    }

    /**
     * A panel prompting for String input. It contains a label and a text field.
     */
    class GetInputPanel extends JPanel {

        private final JTextField inputField;  //used for the user input

        /**
         * Constructor sets up a label and the text field
         *
         * @param size the size of the input text field
         * @param prompt the message specifying expected input
         */
        public GetInputPanel(int size, String prompt) {
            inputField = new JTextField(size);
            JLabel label = new JLabel(prompt);
            add(label);
            add(inputField);
        }

        /**
         * Gets the text from the text field
         *
         * @return Returns the text from the text field
         */
        public String getText() {
            return inputField.getText();
        }

        /**
         * Converts the text field value into a number and displays an error
         * message when inputed data contains non digit characters
         *
         * @return the integer represented by the user input
         */
        public double getValue() {
            double value = 0.0;
            try {
                value = Double.parseDouble(inputField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid characters in number",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            return value;
        }
    }

    /**
     * This panel represents a panel with a label and a combo box.
     */
    class GetComboPanel extends JPanel {

        JLabel label;   //explains the purpose of the combo box
        JComboBox ageCombo; //used for the user input

        /**
         * Constructor sets up a panel with a label and a combo box.
         *
         * @param message the text indicating the purpose of the combo box
         * @param numChoices the range of choices displayed in the combo box
         */
        public GetComboPanel(String message, int numChoices) {
            label = new JLabel(message);
            String[] age = new String[numChoices];

            for (int i = 0; i < age.length; i++) {
                age[i] = i + 1 + "";
            }
            ageCombo = new JComboBox(age);

            add(label);
            add(ageCombo);
        }

        /**
         * Gets the value from the combo box
         *
         * @return value selected from the combo box
         */
        public int getValue() {
            int a;
            a = Integer.parseInt((String) ageCombo.getSelectedItem());
            return a;
        }
    }

}
