package Application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Animals.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Exceptions.*;

/**
 * SimpleGUI.java This program uses variety of GUI objects and it allows the
 * user to interact with the objects.
 *
 * @author Xiaoqing Zhang
 * @vision 1.6
 * @since 2017-01-23
 */
public class SimpleGUI extends JFrame implements ActionListener {

    /**
     * GUI component for getting the name
     */
    private GetInputPanel namePanel;
    /**
     * GUI component for getting the weight
     */
    private GetInputPanel weightPanel;
    /**
     * GUI component for getting the age
     */
    private GetComboPanel agePanel;
    /**
     * GUI component for getting the color
     */
    private GetInputPanel colorPanel;
    /**
     * GUI component for getting the length
     */
    private GetComboPanel lengthPanel;
    /**
     * Button for adding a reptile to the collection
     */
    private JButton addReptileButton;
    /**
     * Button for adding a mammal to the collection
     */
    private JButton addMammalButton;
    /**
     * Button for displaying animals in the collection
     */
    private JButton displayAnimalsButton;
    /**
     * A temporary GUI component for validating data
     */
    private JTextArea verifyArea;
    /**
     * Array for storing the animals from the input
     */
    private Animals[] array = new Animals[10];
    /**
     * create the variable counter
     */
    private int counter = 0;

    /**
     * Main method launching the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        SimpleGUI frame = new SimpleGUI();
        frame.setSize(650, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Constructor creates the SimpleGUI frame with a title
     */
    public SimpleGUI() {
        super("Animal GUI Components");
        createGUI();
    }

    /**
     * method createGUI creates GUI objects and adds them to the frame
     */
    private void createGUI() {
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout(3, 5)); // 5 pixels hor and vert gap

        JPanel inputPanel = new JPanel();     //contains various input panels
        inputPanel.setLayout(new GridLayout(5, 1));
        namePanel = new GetInputPanel(20, "     Animal's Name: ");
        inputPanel.add(namePanel);
        weightPanel = new GetInputPanel(6, "   Animal's Weight (lb): ");
        inputPanel.add(weightPanel);
        agePanel = new GetComboPanel("Animal's Age (years)", 125);
        inputPanel.add(agePanel);
        lengthPanel = new GetComboPanel("Animal's Length (cm)", 1000);
        inputPanel.add(lengthPanel);
        colorPanel = new GetInputPanel(25, "    Animal's skin/fur color: ");
        inputPanel.add(colorPanel);

        JPanel buttonPanel = new JPanel();  //contains buttons
        buttonPanel.setLayout(new GridLayout(1, 3, 5, 5));

        addReptileButton = new JButton("Add Reptile");
        addMammalButton = new JButton("Add Mammal");
        displayAnimalsButton = new JButton("Display Animals");

        addReptileButton.setToolTipText("Press to add Reptile");
        addMammalButton.setToolTipText("Press to add Mammal");

        buttonPanel.add(addReptileButton);
        buttonPanel.add(addMammalButton);
        buttonPanel.add(displayAnimalsButton);

        verifyArea = new JTextArea(20, 35);
        JScrollPane p = new JScrollPane(verifyArea);

        c.add(inputPanel, BorderLayout.NORTH);
        c.add(buttonPanel, BorderLayout.CENTER);
        c.add(p, BorderLayout.SOUTH);

        addReptileButton.addActionListener(this);
        addMammalButton.addActionListener(this);
        displayAnimalsButton.addActionListener(this);
        setVisible(true);
    }
    
    
    
    

    /**
     * Responds to the "Display" and "Add" buttons
     *
     * @param ev Returns the command string associated with this action.
     */
    @Override
    public void actionPerformed(ActionEvent ev) {
        Object object = ev.getSource();
        verifyArea.setText("");//erase the content in Textarea when adding the animals

        if (object == addReptileButton) {//if buttom clicks the reptile button

            try {
                Reptile r = new Reptile(namePanel.getText(),
                        weightPanel.getValue(), agePanel.getValue(),
                        lengthPanel.getValue());//creat a object r of reptile class
                if (counter >= 10) {//if variable counter is >= ten(array is full)
                    JOptionPane.showMessageDialog(null, "Array "
                            + "list is full");//show error message if array is full
                } else {//if variable counter is < ten(array is not full)
                    array[counter] = r;//store r in the array
                    counter++;//after store r, variable counter plus 1
                }
            } catch (InvalidNameException | InvalidWeightException ex) {
                JOptionPane.showMessageDialog(null, "Input name is too short or "
                        + "Invalid characters in the number ", "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on name and weight
            }
        } else if (object == addMammalButton) {//if buttom clicks the mammal button

            try {
                Mammal m = new Mammal(namePanel.getText(),
                        weightPanel.getValue(), agePanel.getValue(),
                        colorPanel.getText());//creat a object m of mammal class

                if (counter >= 10) {//if variable counter is >= ten(array is full)
                    JOptionPane.showMessageDialog(null, "Array "
                            + "list is full");//show error message if array is full
                } else {//if variable counter is < ten(array is not full)
                    array[counter] = m;//store m in the array
                    counter++;//after store m, variable counter plus 1
                }
            } catch (InvalidNameException | InvalidWeightException ex) {
                JOptionPane.showMessageDialog(null, "Input name is too short or "
                        + "Invalid characters in the number ", "Input Error",
                        JOptionPane.ERROR_MESSAGE);//try_catch exception on name and weight
            }
        } else if (object == displayAnimalsButton) {//if buttom clicks the display button
            for (int i = 0; i < counter; i++) {//use loop display
                array[i].display(verifyArea);//display animals in the array that been stored
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
            add(new JLabel(prompt));
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
                JOptionPane.showMessageDialog(null, "Invalid characters in the "
                        + "number", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
            return value;
        }
    }

    /**
     * This panel represents a panel with a label and a combo box.
     */
    class GetComboPanel extends JPanel {

        private final JComboBox combo; //used for the user input

        /**
         * Constructor sets up a panel with a label and a combo box.
         *
         * @param message the text indicating the purpose of the combo box
         * @param numChoices the range of choices displayed in the combo box
         */
        public GetComboPanel(String message, int numChoices) {
            String[] data = new String[numChoices];
            for (int i = 0; i < data.length; i++) {
                data[i] = i + 1 + "";
            }
            combo = new JComboBox(data);
            add(new JLabel(message)); //explains the purpose of the combo box
            add(combo);
        }

        /**
         * Gets the value from the combo box
         *
         * @return value selected from the combo box
         */
        public int getValue() {
            int a;
            a = Integer.parseInt((String) combo.getSelectedItem());
            return a;
        }
    }
}
