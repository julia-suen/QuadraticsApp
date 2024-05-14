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
    /** main  */
    JFrame theframe = new JFrame("Quadratic in Vertex Form");
    AnimationPanel thepanel = new AnimationPanel();
    JPanel quiz1panel = new JPanel();
    JPanel quiz2panel = new JPanel();
    JPanel quiz3panel = new JPanel();
    //JPanel helppanel = new JPanel();
    helppanel help = new helppanel();
    aboutpanel about = new aboutpanel();
    Timer thetimer = new Timer(1000/48, this);
	JMenuBar themenubar = new JMenuBar();
	JMenu mainmenu = new JMenu("Main");
    JMenu quizmenu = new JMenu("Quiz");
	JMenu helpmenu = new JMenu("Help");
	JMenu aboutmenu = new JMenu("About");
	JLabel formulalabel;
    //JButton apos1;
    //JButton aneg1;
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
	//public int intA = 1;
	public int intH = 0;
	public int intK = 0;


    // Quiz Panel JComponents
    JLabel Q1Label;
    JLabel Q1ALabel;
    JLabel Q1BLabel;
    JLabel Q1CLabel;
    JRadioButton Q1AButton;
    JRadioButton Q1BButton;
    JRadioButton Q1CButton;
    ButtonGroup Q1Group;

    JLabel Q2Label;
    JLabel Q2ALabel;
    JLabel Q2BLabel;
    JLabel Q2CLabel;
    JRadioButton Q2AButton;
    JRadioButton Q2BButton;
    JRadioButton Q2CButton;
    ButtonGroup Q2Group;

    JLabel Q3Label;
    JLabel Q3ALabel;
    JLabel Q3BLabel;
    JLabel Q3CLabel;
    JRadioButton Q3AButton;
    JRadioButton Q3BButton;
    JRadioButton Q3CButton;
    ButtonGroup Q3Group;

    JButton Next2Button;
    JButton Next3Button;
    JLabel CorrectLabel;
    JLabel CorrectLabel2;
    JLabel CorrectLabel3;
    JLabel WrongLabel1;
    JLabel WrongLabel2;
    JLabel WrongLabel3;

    // Methods
    public void actionPerformed(ActionEvent evt){
		/* 
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
        */

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
			if(thepanel.intX < thepanel.intLimitX){
				thepanel.intX = thepanel.intX + thepanel.intDeltaX;
			}else if(thepanel.intX > thepanel.intLimitX){
				thepanel.intX = thepanel.intX - thepanel.intDeltaX;
			}
			if(thepanel.intY > thepanel.intLimitY){
				thepanel.intY = thepanel.intY - thepanel.intDeltaY;
			}else if(thepanel.intY < thepanel.intLimitY){
				thepanel.intY = thepanel.intY + thepanel.intDeltaY;
			}
			thepanel.repaint();
        }

        // Quiz Panel buttons
        
        if(evt.getSource() == Q1AButton){
            // System.out.println("A");
            CorrectLabel.setVisible(false);
            WrongLabel1.setVisible(true);
            Next2Button.setVisible(true);
        }else if(evt.getSource() == Q1BButton){
            CorrectLabel.setVisible(false);
            WrongLabel1.setVisible(true);
            Next2Button.setVisible(true);
        }else if(evt.getSource() == Q1CButton){
            // Correct
            WrongLabel1.setVisible(false);
            CorrectLabel.setVisible(true);
            Next2Button.setVisible(true);
        }

        if(evt.getSource() == Next2Button){
            theframe.setContentPane(quiz2panel);
            theframe.pack();
			theframe.repaint();
        }
          
        if(evt.getSource() == Q2AButton){
            CorrectLabel2.setVisible(false);
            WrongLabel2.setVisible(true);
            Next3Button.setVisible(true);
        }else if(evt.getSource() == Q2BButton){
            CorrectLabel2.setVisible(false);
            WrongLabel2.setVisible(true);
            Next3Button.setVisible(true);
        }else if(evt.getSource() == Q2CButton){
            // Correct
            WrongLabel2.setVisible(false);
            CorrectLabel2.setVisible(true);
            Next3Button.setVisible(true);
        }

        if(evt.getSource() == Next3Button){
            theframe.setContentPane(quiz3panel);
            theframe.pack();
			theframe.repaint();
        }

        if(evt.getSource() == Q3AButton){
            // Correct
            WrongLabel3.setVisible(false);
            CorrectLabel3.setVisible(true);
        }else if(evt.getSource() == Q3BButton){
            CorrectLabel3.setVisible(false);
            WrongLabel3.setVisible(true);
        }else if(evt.getSource() == Q3CButton){
            CorrectLabel3.setVisible(false);
            WrongLabel3.setVisible(true);
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
			theframe.setContentPane(help);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == aboutmenu){
			theframe.setContentPane(about);
			theframe.pack();
			theframe.repaint();
		}else if(evt.getSource() == quizmenu){
			theframe.setContentPane(quiz1panel);
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
        formulalabel.setLocation(650,20);
        thepanel.add(formulalabel);

        /* 
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
        */

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
        quiz1panel.setPreferredSize(new Dimension(960,540));
		quiz1panel.setLayout(null);
		
        quiz2panel.setPreferredSize(new Dimension(960,540));
		quiz2panel.setLayout(null);

        quiz3panel.setPreferredSize(new Dimension(960,540));
		quiz3panel.setLayout(null);

        Q1Label = new JLabel("1. What does the 'k' value represents in the vertex form equation?");
        Q1Label.setSize(800,20);
        Q1Label.setLocation(5,5);
        quiz1panel.add(Q1Label);
        
        Q1ALabel = new JLabel("reflection across x-axis");
        Q1ALabel.setSize(600,20);
        Q1ALabel.setLocation(25,25);
        quiz1panel.add(Q1ALabel);

        Q1BLabel = new JLabel("horizontal translation");
        Q1BLabel.setSize(600,20);
        Q1BLabel.setLocation(25,45);
        quiz1panel.add(Q1BLabel);

        Q1CLabel = new JLabel("vertical translation");
        Q1CLabel.setSize(600,20);
        Q1CLabel.setLocation(25,65);
        quiz1panel.add(Q1CLabel);

        Q2Label = new JLabel("<html> 2. Which of the following statements is true about the equation: f(x) = (x - 3)<sup>2</sup> - 8 </html>");
        Q2Label.setSize(800,20);
        Q2Label.setLocation(5,5);
        quiz2panel.add(Q2Label);
        
        Q2ALabel = new JLabel("horizontal translation 3 units to the left");
        Q2ALabel.setSize(600,20);
        Q2ALabel.setLocation(25,25);
        quiz2panel.add(Q2ALabel);

        Q2BLabel = new JLabel("horizontal translation 4 units to the right");
        Q2BLabel.setSize(600,20);
        Q2BLabel.setLocation(25,45);
        quiz2panel.add(Q2BLabel);

        Q2CLabel = new JLabel("vertical translation 8 units down");
        Q2CLabel.setSize(600,20);
        Q2CLabel.setLocation(25,65);
        quiz2panel.add(Q2CLabel);

        Q3Label = new JLabel("3. Select the correct equation for the following descriptions: vertical translation 9 units up, horizontal translation 1 unit left");
        Q3Label.setSize(900,20);
        Q3Label.setLocation(5,5);
        quiz3panel.add(Q3Label);
        
        Q3ALabel = new JLabel("<html> f(x) = (x + 1)<sup>2</sup> + 9</html>");
        Q3ALabel.setSize(600,20);
        Q3ALabel.setLocation(25,25);
        quiz3panel.add(Q3ALabel);

        Q3BLabel = new JLabel("<html> f(x) = (x - 1)<sup>2</sup> - 9</html>");
        Q3BLabel.setSize(600,20);
        Q3BLabel.setLocation(25,45);
        quiz3panel.add(Q3BLabel);

        Q3CLabel = new JLabel("<html> f(x) = (x - 1)<sup>2</sup> + 9</html>");
        Q3CLabel.setSize(600,20);
        Q3CLabel.setLocation(25,65);
        quiz3panel.add(Q3CLabel);

        // Answer Buttons
        Q1AButton = new JRadioButton();
        Q1AButton.setSize(20,20);
        Q1AButton.setLocation(5,25);
        quiz1panel.add(Q1AButton);
        Q1AButton.addActionListener(this);

        Q1BButton = new JRadioButton();
        Q1BButton.setSize(20,20);
        Q1BButton.setLocation(5,45);
        quiz1panel.add(Q1BButton);
        Q1BButton.addActionListener(this);

        Q1CButton = new JRadioButton();
        Q1CButton.setSize(20,20);
        Q1CButton.setLocation(5,65);
        quiz1panel.add(Q1CButton);
        Q1CButton.addActionListener(this);

        Q1Group = new ButtonGroup();
        Q1Group.add(Q1AButton);
        Q1Group.add(Q1BButton);
        Q1Group.add(Q1CButton);

        Q2AButton = new JRadioButton();
        Q2AButton.setSize(20,20);
        Q2AButton.setLocation(5,25);
        quiz2panel.add(Q2AButton);
        Q2AButton.addActionListener(this);

        Q2BButton = new JRadioButton();
        Q2BButton.setSize(20,20);
        Q2BButton.setLocation(5,45);
        quiz2panel.add(Q2BButton);
        Q2BButton.addActionListener(this);

        Q2CButton = new JRadioButton();
        Q2CButton.setSize(20,20);
        Q2CButton.setLocation(5,65);
        quiz2panel.add(Q2CButton);
        Q2CButton.addActionListener(this);

        Q2Group = new ButtonGroup();
        Q2Group.add(Q2AButton);
        Q2Group.add(Q2BButton);
        Q2Group.add(Q2CButton);

        Q3AButton = new JRadioButton();
        Q3AButton.setSize(20,20);
        Q3AButton.setLocation(5,30);
        quiz3panel.add(Q3AButton);
        Q3AButton.addActionListener(this);

        Q3BButton = new JRadioButton();
        Q3BButton.setSize(20,20);
        Q3BButton.setLocation(5,50);
        quiz3panel.add(Q3BButton);
        Q3BButton.addActionListener(this);

        Q3CButton = new JRadioButton();
        Q3CButton.setSize(20,20);
        Q3CButton.setLocation(5,70);
        quiz3panel.add(Q3CButton);
        Q3CButton.addActionListener(this);

        Q3Group = new ButtonGroup();
        Q3Group.add(Q3AButton);
        Q3Group.add(Q3BButton);
        Q3Group.add(Q3CButton);

        Next2Button = new JButton("Next");
        Next2Button.setSize(300,30);
        Next2Button.setLocation(5,250);
        Next2Button.setVisible(false);
        quiz1panel.add(Next2Button);
        Next2Button.addActionListener(this);

        Next3Button = new JButton("Next");
        Next3Button.setSize(300,30);
        Next3Button.setLocation(5,250);
        Next3Button.setVisible(false);
        quiz2panel.add(Next3Button);
        Next3Button.addActionListener(this);

        WrongLabel1 = new JLabel("Wrong answer, the correct answer is 'vertical translation'");
        WrongLabel1.setSize(500,30);
        WrongLabel1.setLocation(5,130);
        WrongLabel1.setVisible(false);
        quiz1panel.add(WrongLabel1);

        WrongLabel2 = new JLabel("Wrong answer, the correct answer is 'vertical translation 8 units down'");
        WrongLabel2.setSize(500,30);
        WrongLabel2.setLocation(5,130);
        WrongLabel2.setVisible(false);
        quiz2panel.add(WrongLabel2);

        WrongLabel3 = new JLabel("<html>Wrong answer, the correct answer is f(x) = (x + 1)<sup>2</sup> + 9<br>Please return to main menu</br></html>");
        WrongLabel3.setSize(500,60);
        WrongLabel3.setLocation(5,130);
        WrongLabel3.setVisible(false);
        quiz3panel.add(WrongLabel3);

        CorrectLabel = new JLabel("Correct:) Try the next question!");
        CorrectLabel.setSize(500,30);
        CorrectLabel.setLocation(5,130);
        CorrectLabel.setVisible(false); 
        quiz1panel.add(CorrectLabel);

        CorrectLabel2 = new JLabel("Correct:) Try the next question!");
        CorrectLabel2.setSize(500,30);
        CorrectLabel2.setLocation(5,130);
        CorrectLabel2.setVisible(false); 
        quiz2panel.add(CorrectLabel2);

        CorrectLabel3 = new JLabel("Correct:) Please return to main menu");
        CorrectLabel3.setSize(500,30);
        CorrectLabel3.setLocation(5,130);
        CorrectLabel3.setVisible(false); 
        quiz3panel.add(CorrectLabel3);
        
		// Help Panel
		help.setPreferredSize(new Dimension(960,540));
        help.setLayout(null);

		// About Panel
        about.setPreferredSize(new Dimension(960,540));
        about.setLayout(null);

        theframe.setContentPane(thepanel);
        theframe.pack();
        theframe.setResizable(false);
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setIconImage(thepanel.imgIcon.getImage());
        theframe.setLocationRelativeTo(null);
        theframe.setVisible(true);
        thetimer.start();
    }   

    // Main Program
    public static void main(String[] args){
        new quadratic();
    }
}
