import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class quadratic implements ActionListener{
    // Properties
    JFrame theframe = new JFrame("Quadratic");
    AnimationPanel thepanel = new AnimationPanel();
    Timer thetimer = new Timer(1000/48, this);
    //JSlider theslider;

    // Methods
    public void actionPerformed(ActionEvent evt){
        
    }

    //public void stateChanged(ChangeEvent evt){  
    //}
    
    // Constructor
    public quadratic(){
        thepanel.setPreferredSize(new Dimension(960,540));
        thepanel.setLayout(null);
        
        /*
        theslider = new JSlider(-10, 10, 0);
        theslider.setSize(200,50);
        theslider.setLocation(0,100);
        theslider.addChangeListener(this);
        thepanel.add(theslider);
        */
        
        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setResizable(false);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setVisible(true);

    }   

    // Main Program
    public static void main(String[] args){
        // System.out.println("Hello world");
        new quadratic();
    }
}
