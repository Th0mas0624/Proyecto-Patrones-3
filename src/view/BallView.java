package view;

import javax.swing.*;

import model.Ball;

import java.awt.*;

public class BallView {
    private Ball ball;
    private Color color;

    public BallView(Ball ball, Color color) {
        this.ball = ball;
        this.color = color;
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval(ball.getPosX(), ball.getPosY(), 10, 10); // Ejemplo: Renderizar un círculo para la pelota
    }
}