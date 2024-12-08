
import java.awt.Color;
import javax.swing.*;

public class square {
    
    public boolean is_active;
    public Color color;
    public line line1;
    public line line2;
    public line line3;
    public line line4;
    public JPanel panel;
 

    public square(line line1, line line2,line line3,line line4, JPanel panel) {
        this.is_active = false;
        this.color = Color.BLUE;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.line4 = line4;
        this.panel = panel;
    }

    public void activate(Color color) {
        if(this.is_active) {
            return;
        }
        this.is_active = true;
        this.color = color;
        if (panel != null) {
            panel.setBackground(color);
            panel.setOpaque(true);
            panel.repaint(); 
        }
    }
    
    
    public JPanel getPanel() {
        return this.panel;
    }

    public boolean isAllLinesAreActive() {
        return line1.isActive() && line2.isActive() && line3.isActive() && line4.isActive();
    }

}
