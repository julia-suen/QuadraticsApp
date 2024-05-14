import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class aboutpanel extends JPanel{
	BufferedImage imgAbout;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(imgAbout, 0, 0, null);
	}
	
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
