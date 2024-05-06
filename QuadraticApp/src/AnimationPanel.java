import java.awt.*;
import javax.swing.*;

public class AnimationPanel extends JPanel {
    // Properties
    
    // Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawLine(540,0,540,540);
    }

    // Constructor  
    public AnimationPanel(){
        super();
    }
}
