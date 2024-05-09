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
    

    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Variables for Graph translation
        int intX = this.intH;
        int intY = this.intK;
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
            imgCurve = ImageIO.read(getClass().getResource("/Images/parabola.png"));
            //imgCurve = ImageIO.read(new File("/Images/parabola.png"));
        } catch (IOException e) {
            System.out.println("Unable to load image");
            System.out.println(e.toString());
        }
    }
}
