import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class controller {

    ArrayList<line> HorizontalLines;
    ArrayList<line> VerticalLines;
    ArrayList<square> squares;
    ArrayList<JPanel> panels;
    gui gui;
    Player[] players;
    Player currentPlayer;
    int activatedSquares;

    public controller(Player player1, Player player2) {
        this.HorizontalLines = new ArrayList<line>();
        this.VerticalLines = new ArrayList<line>();
        this.squares = new ArrayList<square>();
        this.panels = new ArrayList<JPanel>();
        gui = new gui(this);
        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        currentPlayer = players[0];
        activatedSquares = 0;
        
    }

    public void switchPlayer() {
        if (currentPlayer == players[0]) {
            currentPlayer = players[1];
        } else {
            currentPlayer = players[0];
        }
        gui.setLabel(currentPlayer.getName() + "'s Turn" + " Score: " + currentPlayer.getScore());
    }

    public void addLine(line param_line , String orientation){ 
        if(orientation == "horizontal"){
            this.HorizontalLines.add(param_line);
        }
        if(orientation == "vertical"){
            this.VerticalLines.add(param_line);
        }
    }
    

    public void activateLine(line line){
        line.activate(currentPlayer.getColor());
        gui.setButton(line);
    }

    int ctr = 0;
    public void addPanel(JPanel param_panel){
        this.panels.add(param_panel);

    }

    public void createSquare(int number, JPanel param_panel) {
        int vert_index = number + (Integer)(number / 5);
        square newSquare = new square(HorizontalLines.get(number), 
            HorizontalLines.get(number + 5), 
            VerticalLines.get(vert_index), 
            VerticalLines.get(vert_index + 1), 
            param_panel);
        this.squares.add(newSquare);

    }
    

    public void createSquares(){
        for (int i = 0; i < 25; i++){
            createSquare(i, panels.get(i));
        }
    }

    public void activateSquare(square square) {
        square.activate(currentPlayer.getColor());
        if (square.panel != null) {
            square.panel.repaint(); 
        }
    }
    

    public void checkSquares() {
        boolean anySquareActivated = false;
        for (square square : squares) {
            if (square.isAllLinesAreActive() && !square.is_active) {
                anySquareActivated = true;
                activateSquare(square);
                gui.setPanel(square); 
                currentPlayer.increaseScore();
                activatedSquares++;
            }
        }
        if (!anySquareActivated) {
            switchPlayer();
        }
        if (activatedSquares == 25) {
            gameEnd();
        }
    }

    public void afterClick(line line) {
        activateLine(line);
        checkSquares();
    }
    
    
    public void run(){
        gui.run_gui();
    }

    public void gameEnd() {
        if (players[0].getScore() > players[1].getScore()) {
            gui.setLabel(players[0].getName() + " Wins!");
            gui.gameEndpopup("Player 1 wins", "Player 1 wins");
        } else if (players[0].getScore() < players[1].getScore()) {
            gui.setLabel(players[1].getName() + " Wins!");
            gui.gameEndpopup("Player 2 wins", "Player 2 wins");
        } 
    }

    



}