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

    private Ball game;
    private Image playerImage;

    public BallView(Ball game){
        this.game = game;
        loadImage();
    }
    
    private void loadImage(){
         // Cargar la imagen del jugador
        playerImage = new ImageIcon(game.getPathImg()).getImage();
        // Establecer el tamaño del PlayerView al tamaño de la imagen del jugador
    }
    
    public void render(Graphics g) {
        // Calcular las coordenadas y dimensiones escaladas de la imagen
        int scaledWidth = Constants.PLAYER_WIDTH;
        int scaledHeight = Constants.PLAYER_HEIGHT;

        // Dibujar la imagen del jugador escalada en las coordenadas iniciales
        g.drawImage(playerImage, game.getPosX(), game.getPosY(), scaledWidth, scaledHeight, null);    

    }
}
