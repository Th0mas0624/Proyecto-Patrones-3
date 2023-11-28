package view;

import javax.swing.*;

import model.Decorator.PowerUp;

import java.awt.*;

public class PowerUpView {
    private PowerUp powerUp;
    private Image powerUpImage; // Imagen del poder

    public PowerUpView(PowerUp powerUp, String imagePath) {
        this.powerUp = powerUp;
        this.powerUpImage = new ImageIcon(imagePath).getImage();
    }

    public void render(Graphics g) {
        g.drawImage(powerUpImage, powerUp.getX(), powerUp.getY(), null);
    }
}
