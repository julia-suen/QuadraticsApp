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

// zip the folder that contains source file, images, jar file, javadocs to submit

public class quadratic implements ActionListener, ChangeListener, MenuListener{
    // Properties
    JFrame theframe = new JFrame("Quadratic");
    AnimationPanel thepanel = new AnimationPanel();
    JPanel quizpanel = new JPanel();
    JPanel helppanel = new JPanel();
    JPanel aboutpanel = new JPanel();
    Timer thetimer = new Timer(1000/48, this);
    ImageIcon imgIcon = new ImageIcon("Images/mathicon.png");
	JMenuBar themenubar = new JMenuBar();
	JMenu mainmenu = new JMenu("Main");
    JMenu quizmenu = new JMenu("Quiz");
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
    JLabel transformation1;
    JLabel transformation2;
    JLabel transformation3;
    JLabel atrans;
    JLabel htrans;
    JLabel ktrans;
	public int intA = 1;
	public int intH = 0;
	public int intK = 0;


    // Quiz Panel JComponents
    JLabel Q1Label;
    



    // Methods
    public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == apos1){
			intA = 1;
			//System.out.println(intA);
            thepanel.intA = this.intA;
            atrans.setText("");
		}

		if(evt.getSource() == aneg1){
			intA = -1;
			//System.out.println(intA);
            thepanel.intA = this.intA;
            atrans.setText("-");
		}

		if(evt.getSource() == hvalue){
			try{
				intH = Integer.parseInt(hvalue.getText());
				hslider.setValue(intH);
				//System.out.println(intH);
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
			}catch(NumberFormatException e){
				kvalue.setText("0");
				kslider.setValue(0);
			}
		}

        if(evt.getSource() == thetimer){

        }
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
			//System.out.println(intH);
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

    public void menuCanceled(MenuEvent evt){
		
	}
	
	public void menuDeselected(MenuEvent evt){
		
	}
	
	public void menuSelected(MenuEvent evt){
		if(evt.getSource() == mainmenu){
			theframe.setContentPane(thepanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == helpmenu){
			theframe.setContentPane(helppanel);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == quizmenu){
			theframe.setContentPane(quizpanel);
			theframe.pack();
			theframe.repaint();
		}
	}

    // Constructor
    public quadratic(){
        // Main Panel
        thepanel.setPreferredSize(new Dimension(960,540));
		thepanel.setLayout(null);
		
		themenubar.add(mainmenu);
        themenubar.add(quizmenu);
		themenubar.add(helpmenu);
		themenubar.add(aboutmenu);
		theframe.setJMenuBar(themenubar);

        mainmenu.addMenuListener(this);
		helpmenu.addMenuListener(this);
		quizmenu.addMenuListener(this);
		aboutmenu.addMenuListener(this);

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
		
		
        transformation1 = new JLabel("f(x) = ");
        transformation1.setFont(new Font("Calibri", Font.PLAIN, 24));
		transformation1.setSize(300,200);
		transformation1.setLocation(600,250);
		thepanel.add(transformation1);
		
        transformation2 = new JLabel("<html> )<sup>2</sup></html>");
        transformation2.setFont(new Font("Calibri", Font.PLAIN, 24));
		transformation2.setSize(300,200);
		transformation2.setLocation(725,238);
		thepanel.add(transformation2);
        
        transformation3 = new JLabel("(x");
        transformation3.setFont(new Font("Calibri", Font.PLAIN, 24));
		transformation3.setSize(300,200);
		transformation3.setLocation(670,250);
		thepanel.add(transformation3);

        atrans = new JLabel("a");
        atrans.setFont(new Font("Calibri", Font.PLAIN, 24));
		atrans.setSize(300,200);
		atrans.setLocation(655,250);
		thepanel.add(atrans);

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

        // Quiz Panel
        quizpanel.setPreferredSize(new Dimension(960,540));
		quizpanel.setLayout(null);
		
        Q1Label = new JLabel("Question 1");
        Q1Label.setSize(300,200);
        Q1Label.setLocation(30,20);
        quizpanel.add(Q1Label);
        
		// Help Panel
		helppanel.setPreferredSize(new Dimension(960,540));
        helppanel.setLayout(null);

		// About Panel
        aboutpanel.setPreferredSize(new Dimension(960,540));
        aboutpanel.setLayout(null);

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
