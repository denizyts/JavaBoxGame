import java.awt.Color;

public class main {
    public static void main(String[] args) {
        

        controller controller = new controller(new Player(Color.RED, "Player 1"), new Player(Color.CYAN, "Player 2"));
        controller.run();

    }
}
