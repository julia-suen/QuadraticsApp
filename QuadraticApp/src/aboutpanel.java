import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/** Create an extension of JPanel for About Us Page */
public class aboutpanel extends JPanel{
	// Properties
	/** Create a BufferedImage object to store the About Us page */
	public BufferedImage imgAbout;
	
	// Methods
	/** Paints the About Us page to the screen when triggered */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(imgAbout, 0, 0, null);
	}
	
	// Constructor
	/** Loads About Us page to the BufferedImage object */
	public aboutpanel(){
		super();
		try{
			imgAbout = ImageIO.read(getClass().getResourceAsStream("/Images/about.png"));
		}catch(IOException e){
			System.out.println("Unable to load About Us Page");
            System.out.println(e.toString());
		}
	}
}
