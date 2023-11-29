// CampoView.java
package view;

import util.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CampoView extends JPanel {
    private Image backgroundImage;
    private List<PlayerView> playerViews;

    public CampoView() {
        // Lógica para cargar la imagen de fondo
        backgroundImage = Toolkit.getDefaultToolkit().getImage("assets/cancha.png");
        // Establecer el tamaño del CampoView al tamaño de la imagen de fondo
        setPreferredSize(new Dimension(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT));

        // Inicializar la lista de PlayerViews
        playerViews = new ArrayList<>();

        // Agregar un PlayerView de ejemplo (puedes hacerlo dinámicamente según tus necesidades)
        PlayerView playerView = new PlayerView();
        playerViews.add(playerView);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Dibujar cada PlayerView en la lista
        for (PlayerView playerView : playerViews) {
            playerView.paintComponent(g);
        }
    }
}