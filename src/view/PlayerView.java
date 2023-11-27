package view;

import model.FactoryMethod.Player;
import javax.swing.*;
import java.awt.*;

public class PlayerView {
    private Player player;
    private Color color;

    public PlayerView(Player player, Color color) {
        this.player = player;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(player.getPosX(), player.getPosY(), 20, 20); // Ejemplo: Renderizar un rectángulo para el jugador
    }
}