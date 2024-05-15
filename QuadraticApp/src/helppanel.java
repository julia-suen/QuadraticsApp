import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class helppanel extends JPanel{
	// Properties
	/** Create a BufferedImage object to store the Help screen image */
	public BufferedImage imgHelp;
	
	// Methods
	/** Paints the Help page to the screen when triggered */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(imgHelp, 0, 0, null);
	}
	
	// Constructor
	/** Loads Help page to the BufferedImage object */
	public helppanel(){
		super();
		try{
			imgHelp = ImageIO.read(getClass().getResourceAsStream("/Images/help.png"));
		}catch(IOException e){
			System.out.println("Unable to load Help Menu");
            System.out.println(e.toString());
		}
	}
}
