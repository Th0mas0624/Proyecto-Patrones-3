package launcher;

import view.main.*;

public class GameLauncher {
    private GameFrame gameFrame;
    private GamePanel gamePanel;

    public GameLauncher() {
        gamePanel = new GamePanel();
        gameFrame = new GameFrame(gamePanel);
        gamePanel.requestFocus();
    }
}
