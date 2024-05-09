import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


// To create jar file, type the following in terminal
// jar --verbose --create --file jarexample.jar --main-class=keyboardmouse AnimationPanel.class keyboardmouse.class homer.png
// Create sub directory called "javadocs"
// javadoc ../AnimationPanel.java
// javadoc ../keyboardmouse.java
// javadoc ../*.java
// for every method and property, comment (before the actual method) with /** comments */
// setContentPane.validate 

public class quadratic implements ActionListener, ChangeListener{
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
    JTextField hvalue;
    JTextField kvalue;
    //JButton butconfirm;
    JLabel transformation1;
    JLabel transformation2;
    JLabel htrans;
    JLabel ktrans;
	public int intA = 1;
	public int intH = 0;
	public int intK = 0;

    // Methods
    public void actionPerformed(ActionEvent evt){
        /*
        if(evt.getSource() == butconfirm){
			System.out.println("Confirmed");
		*/
		//
		if(evt.getSource() == apos1){
			intA = 1;
			System.out.println(intA);
            thepanel.intA = this.intA;
			//printTransformation(intA, intH, intK);
			//transformation.setText("intA");
		}
		if(evt.getSource() == aneg1){
			intA = -1;
			System.out.println(intA);
            thepanel.intA = this.intA;
			//printTransformation(intA, intH, intK);
			//transformation.setText("intA");
		}
		//

		if(evt.getSource() == hvalue){
			try{
				intH = Integer.parseInt(hvalue.getText());
				hslider.setValue(intH);
				//System.out.println(intH);
				//System.out.println(intH);
				//transformation.setText("intA");
				//printTransformation(intA, intH, intK);
			}catch(NumberFormatException e){
				hvalue.setText("0");
				hslider.setValue(0);
			}
		}
		
		if(evt.getSource() == kvalue){
			try{
				intK = Integer.parseInt(kvalue.getText());
				kslider.setValue(intK);
				//System.out.println(intK);
				//transformation.setText("intA");
				//printTransformation(intA, intH, intK);
			}catch(NumberFormatException e){
				kvalue.setText("0");
				kslider.setValue(0);
			}
		}
		
		//}
    }

	public void stateChanged(ChangeEvent evt){
		if(evt.getSource() == hslider){
			hvalue.setText(hslider.getValue()+"");
			intH = hslider.getValue();
            thepanel.intH = this.intH;

            if(this.intH < 0){
                htrans.setText("+"+this.intH*-1);
            }else{
                htrans.setText("-"+this.intH);
            }
			// System.out.println(intH);
		}
		
		if(evt.getSource() == kslider){
			kvalue.setText(kslider.getValue()+"");
            intK = kslider.getValue();
            thepanel.intK = this.intK;

            if(this.intK >= 0){
                ktrans.setText("+"+this.intK);
            }else{
                ktrans.setText("-"+this.intK*-1);
            }
		}
	}

    // Constructor
    public quadratic(){
        thepanel.setPreferredSize(new Dimension(960,540));
		thepanel.setLayout(null);
		
		themenubar.add(mainmenu);
		themenubar.add(helpmenu);
		themenubar.add(aboutmenu);
		theframe.setJMenuBar(themenubar);

        formulalabel = new JLabel("<html> f(x) = a(x - h)<sup>2</sup> + k </html>");
        formulalabel.setFont(new Font("Calibri", Font.PLAIN, 24));
        formulalabel.setSize(200,100);
        formulalabel.setLocation(650,5);
        thepanel.add(formulalabel);

        apos1 = new JButton("a = 1");
        apos1.setSize(100,30);
        apos1.setLocation(600, 120);
        apos1.addActionListener(this);
        thepanel.add(apos1);

        aneg1 = new JButton("a = -1");
        aneg1.setSize(100,30);
        aneg1.setLocation(800, 120);
        aneg1.addActionListener(this);
        thepanel.add(aneg1);

        hlabel = new JLabel("h");
        hlabel.setSize(30,30);
        hlabel.setLocation(600, 180);
        thepanel.add(hlabel);

        hslider = new JSlider(-10,10,0);
        hslider.setSize(300,50);
        hslider.setLocation(600,200);
        hslider.addChangeListener(this);
        hslider.setSnapToTicks(true);
        hslider.setPaintLabels(true);
        thepanel.add(hslider);

        klabel = new JLabel("k");
        klabel.setSize(30,30);
        klabel.setLocation(600, 250);
        thepanel.add(klabel);

        kslider = new JSlider(-10,10,0);
        kslider.setSize(300,50);
        kslider.setLocation(600,270);
        kslider.addChangeListener(this);
        thepanel.add(kslider);

		hvalue = new JTextField("0");
		hvalue.setSize(30,20);
		hvalue.setLocation(650,180);
		hvalue.addActionListener(this);
		thepanel.add(hvalue);
		
		kvalue = new JTextField("0");
		kvalue.setSize(30,20);
		kvalue.setLocation(650,250);
		kvalue.addActionListener(this);
		thepanel.add(kvalue);
		
		/*
        butconfirm = new JButton("Confirm & run animation");
        butconfirm.setSize(300,30);
        butconfirm.setLocation(600, 340);
        butconfirm.addActionListener(this);
        thepanel.add(butconfirm);
        */
		
        transformation1 = new JLabel("f(x) = a(x   ");
        transformation1.setFont(new Font("Calibri", Font.PLAIN, 24));
		transformation1.setSize(300,200);
		transformation1.setLocation(600,250);
		thepanel.add(transformation1);
		
        transformation2 = new JLabel("<html> )<sup>2</sup></html>");
        transformation2.setFont(new Font("Calibri", Font.PLAIN, 24));
		transformation2.setSize(300,200);
		transformation2.setLocation(725,238);
		thepanel.add(transformation2);

        htrans = new JLabel("-h");
        htrans.setFont(new Font("Calibri", Font.PLAIN, 24));
		htrans.setSize(300,200);
		htrans.setLocation(690,250);
		thepanel.add(htrans);

        ktrans = new JLabel("+k");
        ktrans.setFont(new Font("Calibri", Font.PLAIN, 24));
		ktrans.setSize(300,200);
		ktrans.setLocation(745,250);
		thepanel.add(ktrans);

        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setResizable(false);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setIconImage(imgIcon.getImage());
        theframe.setLocationRelativeTo(null);
        theframe.setVisible(true);
        thetimer.start();
    }   

    // Main Program
    public static void main(String[] args){
        new quadratic();
    }
}
