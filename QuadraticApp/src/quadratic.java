import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// To create jar file, type the following in terminal
// jar --verbose --create --file jarexample.jar --main-class=keyboardmouse AnimationPanel.class keyboardmouse.class homer.png

public class quadratic implements ActionListener{
    // Properties
    JFrame theframe = new JFrame("Quadratic");
    AnimationPanel thepanel = new AnimationPanel();
    Timer thetimer = new Timer(1000/48, this);
    ImageIcon imgIcon = new ImageIcon("Images/mathicon.png");
	JMenuBar themenubar = new JMenuBar();
	JMenu mainmenu = new JMenu("Main");
	JMenu helpmenu = new JMenu("Help");
	JMenu aboutmenu = new JMenu("About");
	JLabel formulalabel;
    JButton apos1;
    JButton aneg1;
    JLabel hlabel;
    JLabel klabel;
    JSlider hslider;
    JSlider kslider;
    JButton butconfirm;

    // Methods
    public void actionPerformed(ActionEvent evt){
        
    }

    // Constructor
    public quadratic(){
        thepanel.setPreferredSize(new Dimension(960,540));
		thepanel.setLayout(null);
		
		// Change Icon of the app
		theframe.setIconImage(imgIcon.getImage()); 
		
		themenubar.add(mainmenu);
		themenubar.add(helpmenu);
		themenubar.add(aboutmenu);
		theframe.setJMenuBar(themenubar);

        formulalabel = new JLabel("<html> f(x) = a(x-h)<sup>2</sup> + k </html>");
        formulalabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        formulalabel.setSize(200,100);
        formulalabel.setLocation(650,5);
        thepanel.add(formulalabel);

        apos1 = new JButton("a = 1");
        apos1.setSize(100,30);
        apos1.setLocation(600, 120);
        thepanel.add(apos1);

        aneg1 = new JButton("a = -1");
        aneg1.setSize(100,30);
        aneg1.setLocation(800, 120);
        thepanel.add(aneg1);

        hlabel = new JLabel("h");
        hlabel.setSize(30,30);
        hlabel.setLocation(600, 180);
        thepanel.add(hlabel);

        hslider = new JSlider(-10,10,0);
        hslider.setSize(300,50);
        hslider.setLocation(600,200);
        thepanel.add(hslider);

        klabel = new JLabel("k");
        klabel.setSize(30,30);
        klabel.setLocation(600, 250);
        thepanel.add(klabel);

        kslider = new JSlider(-10,10,0);
        kslider.setSize(300,50);
        kslider.setLocation(600,270);
        thepanel.add(kslider);

        butconfirm = new JButton("Confirm & run animation");
        butconfirm.setSize(300,30);
        butconfirm.setLocation(600, 340);
        thepanel.add(butconfirm);

        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setResizable(false);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setVisible(true);
    }   

    // Main Program
    public static void main(String[] args){
        new quadratic();
    }
}
