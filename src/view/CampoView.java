// CampoView.java
package view;

import javax.swing.*;
import java.awt.*;

public class CampoView extends JPanel {
    private Image backgroundImage;

    public CampoView() {
        // Lógica para cargar la imagen de fondo
        backgroundImage = Toolkit.getDefaultToolkit().getImage("src/assets/cancha.png");
        // Establecer el tamaño del CampoView al tamaño de la imagen de fondo
        setPreferredSize(new Dimension(1200,600));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Lógica para dibujar otros elementos del campo si es necesario
    }
}
