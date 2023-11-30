package launcher;

import view.GameFrame;
import view.GamePanel;

public class GameLauncher {
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Game game;


    public GameLauncher() {
        game = new Game();
        gamePanel = new GamePanel(game);
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
    }
}
