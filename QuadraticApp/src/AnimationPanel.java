import java.awt.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {
    // Properties
    
    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(0,50,100,100);
    }

    // Constructor  
    public AnimationPanel(){
        super();
    }
}
