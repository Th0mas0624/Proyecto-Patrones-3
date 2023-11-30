// GamePanel.java
package view;


import util.*;
import javax.swing.*;

import controller.inputs.KeyboardInputs;
import launcher.Game;

import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;
    private PlayerView playerView,playerView2;
    private BallView ballsView;
    private CampoView campoView;


    public GamePanel(Game game) {
        this.game = game;
        this.playerView = new PlayerView(game.getPlayers().get(0));
        this.playerView2 = new PlayerView(game.getPlayers().get(1));
        this.campoView = new CampoView(game);
        this.ballsView = new BallView(game.getBalls().get(0));

        initializePanel();
        addKeyListener(new KeyboardInputs(this));
        setFocusable(true);
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        campoView.render(g);
        playerView.render(g);
        playerView2.render(g);
        ballsView.render(g);
        //System.out.println(game.getPlayer().getPosX());
        repaint();
    }

    public Game getGame() {
        return game;
    }
    
  
}
