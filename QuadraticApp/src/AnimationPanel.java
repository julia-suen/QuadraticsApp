import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {
    // Properties
    BufferedImage imgGrid;
    BufferedImage imgCurve;
    public int intA;
    public int intH;
    public int intK;
    int intX;
    int intY;
    int intDeltaX;
    int intDeltaY;
    int intLimitX;
    int intLimitY;
    

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Variables for Graph translation
        if(intH == -10){
			intLimitX = 231;
		}
		if(intH == -9){
			intLimitX = 209;
		}
		if(intH == -8){
			intLimitX = 186;
		}
		if(intH == -7){
			intLimitX = 163;
		}
		if(intH == -6){
			intLimitX = 140;
		}
		if(intH == -5){
			intLimitX = 116;
		}
		if(intH == -4){
			intLimitX = 94;
		}
		if(intH == -3){
			intLimitX = 71;
		}
		if(intH == -2){
			intLimitX = 47;
		}
		if(intH == -1){
			intLimitX = 24;
		}
		if(intH == 0){
			intLimitX = 0;
		}
        // Drawing Grid
        g.drawImage(imgGrid, 0, 0, null);
        // Covering up watermark
        g.setColor(Color.WHITE);
        g.fillRect(0, 520, 540, 540);
        // Drawing Quadratic Graph
        // x = 0 and y level at -231 is the origin on the graph (Default value)
        // around 23 to 24 pixels for x or y to move 1 horizontal or vertical
        g.drawImage(imgCurve, 0, -231, null);
        g.drawLine(540,0,540,540);
        System.out.println(intH);
    }

    // Constructor  
    public AnimationPanel(){
        super();
        try{
            imgGrid = ImageIO.read(getClass().getResourceAsStream("/Images/grid.png"));
            //imgGrid = ImageIO.read(new File("/Images/grid.png"));
        }catch(IOException e){
            System.out.println("Unable to load image");
            System.out.println(e.toString());
        }
        try {
            imgCurve = ImageIO.read(getClass().getResourceAsStream("/Images/parabola.png"));
            //imgCurve = ImageIO.read(new File("/Images/parabola.png"));
        } catch (IOException e) {
            System.out.println("Unable to load image");
            System.out.println(e.toString());
        }
    }
}
