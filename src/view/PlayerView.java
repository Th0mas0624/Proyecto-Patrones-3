package view;

import model.FactoryMethod.Player;
import javax.swing.*;
import java.awt.*;

//Player View
public class PlayerView extends JPanel{
    private Player player;
    private Image playerImage; // Imagen del jugador

    public PlayerView(Player player, String imagePath) {
        this.player = player;
        this.playerImage = new ImageIcon(imagePath).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(playerImage, player.getPosX(), player.getPosY(), null);
    }
}