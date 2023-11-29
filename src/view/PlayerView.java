// PlayerView.java
package view;

import util.*;
import javax.swing.*;
import java.awt.*;

public class PlayerView extends JPanel {
    private Image playerImage;

    public PlayerView() {
        // Cargar la imagen del jugador
        playerImage = new ImageIcon("assets/spiderman.png").getImage();
        // Establecer el tamaño del PlayerView al tamaño de la imagen del jugador
        setPreferredSize(new Dimension(Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Calcular las coordenadas y dimensiones escaladas de la imagen
        int scaledWidth = Constants.PLAYER_WIDTH;
        int scaledHeight = Constants.PLAYER_HEIGHT;

        // Dibujar la imagen del jugador escalada en las coordenadas iniciales
        g.drawImage(playerImage, Constants.INITIAL_PLAYER_X, Constants.INITIAL_PLAYER_Y, scaledWidth, scaledHeight, this);
    }
}