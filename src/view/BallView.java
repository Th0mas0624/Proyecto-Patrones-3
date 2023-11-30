package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import launcher.Game;
import model.Ball;
import model.FactoryMethod.Player;
import util.Constants;

public class BallView {

    private Ball ball;
    private Image ballImage;

    public BallView(Ball ball){
        this.ball = ball;
        loadImage();
    }
    
    private void loadImage(){
         // Cargar la imagen del balon
        ballImage = new ImageIcon(ball.getPathImg()).getImage();
        // Establecer el tamaño del PlayerView al tamaño de la imagen del jugador
    }
    
    public void render(Graphics g) {
        // Calcular las coordenadas y dimensiones escaladas de la imagen
        int scaledWidth = Constants.BALL_WIDTH;
        int scaledHeight = Constants.BALL_HEIGHT;

        // Dibujar la imagen del balon escalada en las coordenadas iniciales
        g.drawImage(ballImage, ball.getPosX(), ball.getPosY(), scaledWidth, scaledHeight, null);    

    }
}
