import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class helppanel extends JPanel{
	BufferedImage imgHelp;
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(imgHelp, 0, 0, null);
	}
	
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
