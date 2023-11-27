package view;

import javax.swing.*;

import model.Decorator.PowerUp;

import java.awt.*;

public class PowerUpView {
    private PowerUp powerUp;
    private Color color;

    public PowerUpView(PowerUp powerUp, Color color) {
        this.powerUp = powerUp;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(powerUp.getX(), powerUp.getY(), 15, 15); // Ejemplo: Renderizar un rectángulo para el poder
    }
}
