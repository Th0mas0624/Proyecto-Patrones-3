package view;

import javax.swing.*;

import model.Ball;

import java.awt.*;

public class BallView {
    private Ball ball;
    private Image ballImage; // Imagen del balón

    public BallView(model.Ball ball, String imagePath) {
        this.ball = ball;
        this.ballImage = new ImageIcon(imagePath).getImage();
    }

    public void render(Graphics g) {
        g.drawImage(ballImage, ball.getPosX(), ball.getPosY(), null);
    }
}