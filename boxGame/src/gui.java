
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class gui {

    JFrame frame = new JFrame("BOX GAME");
    JPanel rightPanel = new JPanel();
    public controller controller;

    public gui(controller controller){
        this.controller = controller;
    }

    public void run_gui() {
        
        frame.setSize(1500, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 

        rightPanel.setBounds(900, 100, 500, 400);
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        rightPanel.setBackground(Color.WHITE);
        
        JLabel label = new JLabel("Player 1's Turn Score: 0");
        
        rightPanel.add(label);

        frame.add(rightPanel);

    
        for (int i = 0; i < 30; i++) {
        
            JButton button = new JButton();

            int x = (i % 5) * 150 + 10; 
            int y = (i / 5) * 150 + 10; 
            int width = 150;           
            int height = 10;

            button.setBounds(x, y, width, height); 
            
            line line = new line(x,y,width, height,i);
            controller.addLine(line , "horizontal");
            button.addActionListener(e -> {
                controller.afterClick(line);
            });
            line.setButton(button);
            frame.add(button);   
        }

        for (int i = 0; i < 25; i++) {
            int x = (i % 5) * 150 + 20;
            int y = (i / 5) * 150 + 20;
            int width = 140;
            int height = 140;
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                panel.setBounds(x , y, width, height);
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Set border
                controller.addPanel(panel);
                frame.add(panel);
            }

        for (int i = 0; i < 30; i++) {
            JButton button = new JButton();
             
            int x = (i % 6) * 150 + 10; 
            int y = (i / 6) * 150 + 10; 
            int width = 10;           
            int height = 150;         

            button.setBounds(x, y, width, height); 
            line line2 = new line(x,y,width, height,i);
            controller.addLine(line2 , "vertical");
            button.addActionListener(e -> {
                controller.afterClick(line2);
            });
            line2.setButton(button);
            frame.add(button);   
        }
    
        controller.createSquares();
        frame.setVisible(true);
    }





    public void setButton(line line) {
        JButton button = line.getButton();
        if (button != null) {
            button.setOpaque(true);
            button.repaint(); 
        }
        frame.repaint(); 
    }

    public void setPanel(square square) {
        JPanel panel = square.getPanel();
        if (panel != null) {
            panel.setBackground(square.color);
            panel.setOpaque(true);
            panel.repaint(); 
        }
        frame.repaint(); 
    }

    public void setLabel(String text) {
        
        JLabel label = (JLabel) rightPanel.getComponent(0);
        label.setText(text);
        label.repaint(); 
        frame.repaint(); 
    }

    public void gameEndpopup(String text , String title) {
        JFrame popup = new JFrame(title);
        popup.setSize(300, 300);
        popup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        popup.setLayout(null); 
        JTextPane textPane = new JTextPane();
        textPane.setText(text);
        textPane.setBounds(10, 10, 280, 280);
        popup.add(textPane);
        popup.setVisible(true);
    }
    
    
}

