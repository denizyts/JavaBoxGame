import java.awt.Color;
import javax.swing.*;


public class line {
    
    public boolean is_active;
    public int x;
    public int y;
    public int width;
    public int height;
    public JButton button;   
    public int lineNumber;
    public Color color;

    public line(int x, int y , int width , int height ,int lineNumber) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lineNumber = lineNumber;
        this.is_active = false;
    }

    public void setButton( JButton button){
        this.button = button;
    }

    public void activate(Color color) {
        if (!this.is_active) {
            this.is_active = true;
            if (this.button != null) {
                this.button.setBackground(color);
                this.button.setOpaque(true); // Necessary for non-default backgrounds
                this.button.setBorderPainted(false); // Optional: Enhances visual effect
            }
        }
    }
    

    public JButton getButton() {
        return this.button;
    }

    public boolean isActive() {
        return this.is_active;
    }
}
