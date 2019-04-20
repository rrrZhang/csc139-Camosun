
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Polymorphism extends JFrame implements ActionListener {

    private JButton go;
    private JPanel panel;

    public static void main(String[] args) {
        Polymorphism demo = new Polymorphism();
        demo.setSize(400, 200);
        demo.createGUI();
        demo.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 150));
        panel.setBackground(Color.white);
        window.add(panel);

        go = new JButton("go");
        window.add(go);
        go.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        Graphics g = panel.getGraphics();
    //we can assign animals from zoo array to a reference of the same class
        //or any of its superclasses
        Animal[] zoo = new Animal[4];
        zoo[0] = new Animal();
        zoo[1] = new Vertebrate();
        zoo[2] = new Mammal();
        zoo[3] = new Animal();

        int x = 10, y = 10;
    //version of method display that matches the actual object is selected
        //This is decided only when program is running -dynamic or late binding
        for (int i = 0; i < zoo.length; i++) {
            zoo[i].display(g, x, y);
            y += 10;
        }

        Animal c = new Mammal();
        //c.legs(2);   //doesn't compile

        ((Mammal) c).legs(2);

        Animal a = new Animal();
        Mammal m = new Mammal();

    //m=a;              //wrong: doesn't compile, doesn't make sense
        //a= (Mammal) a;   //compiles, but creates a run time error
        //runtime error: Animal cannot be cast to Mammal
        a = m;
        //m = a; 	compiler error:Explicit cast needed to convert Animal to Mammal.
        m = (Mammal) a;

    }
}

class Animal {

    public void display(Graphics g, int x, int y) {
        g.drawString(" I am animal", x, y);
    }
}

class Vertebrate extends Animal {

    @Override
    public void display(Graphics g, int x, int y) {
        g.drawString(" I am vertebrate animal", x, y);
    }
}

class Mammal extends Vertebrate {

    private int leg;

    @Override
    public void display(Graphics g, int x, int y) {
        g.drawString(" I am mammal vertebrate animal", x, y);
    }

    public int legs(int l) {
        leg = l;
        return leg;
    }
}

