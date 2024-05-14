import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {
    // Properties
    BufferedImage imgGrid;
    BufferedImage imgCurve;
    BufferedImage imgMathIcon;
    ImageIcon imgIcon;
    public int intH;
    public int intK;
    int intX = 0;
    int intY = -231;
    int intDeltaX = 1;
    int intDeltaY = 1;
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
		if(intH == 1){
			intLimitX = -22;
		}
        if(intH == 2){
			intLimitX = -45;
		}
        if(intH == 3){
			intLimitX = -69;
		}
        if(intH == 4){
			intLimitX = -92;
		}
        if(intH == 5){
			intLimitX = -114;
		}
        if(intH == 6){
			intLimitX = -138;
		}
        if(intH == 7){
			intLimitX = -161;
		}
        if(intH == 8){
			intLimitX = -184;
		}
        if(intH == 9){
			intLimitX = -207;
		}
        if(intH == 10){
			intLimitX = -229;
		}
		if(intK == 10){
			intLimitY = -462;
		}
		if(intK == 9){
			intLimitY = -440;
		}
		if(intK == 8){
			intLimitY = -417;
		}
		if(intK == 7){
			intLimitY = -394;
		}
		if(intK == 6){
			intLimitY = -371;
		}
		if(intK == 5){
			intLimitY = -347;
		}
		if(intK == 4){
			intLimitY = -325;
		}
		if(intK == 3){
			intLimitY = -302;
		}
		if(intK == 2){
			intLimitY = -278;
		}
		if(intK == 1){
			intLimitY = -255;
		}
		if(intK == 0){
			intLimitY = -231;
		}
		if(intK == -1){
			intLimitY = -207;
		}
		if(intK == -2){
			intLimitY = -184;
		}
		if(intK == -3){
			intLimitY = -160;
		}
		if(intK == -4){
			intLimitY = -137;
		}
		if(intK == -5){
			intLimitY = -115;
		}
		if(intK == -6){
			intLimitY = -91;
		}
		if(intK == -7){
			intLimitY = -68;
		}
		if(intK == -8){
			intLimitY = -45;
		}
		if(intK == -9){
			intLimitY = -22;
		}
		if(intK == -10){
			intLimitY = 0;
		}
        // Drawing Grid
        g.drawImage(imgGrid, 0, 0, null);
        // Covering up watermark
        g.setColor(Color.WHITE);
        g.fillRect(0, 520, 540, 540);
        // Drawing Quadratic Graph
        g.drawImage(imgCurve, intX, intY, null);
        g.drawLine(540,0,540,540);
    }

    // Constructor  
    public AnimationPanel(){
        super();
        try{
            imgGrid = ImageIO.read(getClass().getResourceAsStream("/Images/grid.png"));
        }catch(IOException e){
            System.out.println("Unable to load image");
            System.out.println(e.toString());
        }
        try {
            imgCurve = ImageIO.read(getClass().getResourceAsStream("/Images/parabola.png"));
        } catch (IOException e) {
            System.out.println("Unable to load image");
            System.out.println(e.toString());
        }
        try{
			imgMathIcon = ImageIO.read(getClass().getResourceAsStream("/Images/mathicon.png"));
			imgIcon = new ImageIcon(imgMathIcon);
		}catch(IOException e){
			System.out.println("Unable to load app icon");
			System.out.println(e.toString());
		}
    }
}
