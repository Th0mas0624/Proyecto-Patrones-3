// GamePanel.java
package view;


import util.*;
import javax.swing.*;

import controller.inputs.KeyboardInputs;
import launcher.Game;

import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;
    private PlayerView playerView;
    private CampoView campoView;


    public GamePanel(Game game) {
        this.game = game;
        this.playerView = new PlayerView(game);
        this.campoView = new CampoView(game);


        initializePanel();
        addKeyListener(new KeyboardInputs(this));
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
        System.out.println(game.getPlayer().getPosX());
        repaint();
    }

    public Game getGame() {
        return game;
    }
    
  
}
