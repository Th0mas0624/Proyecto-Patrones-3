package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import launcher.Game;
import util.Constants;

public class PlayerView {

    private Game game;
    private Image playerImage;

    public PlayerView(Game game){
        this.game = game;
        loadImage();
    }
    
    private void loadImage(){
         // Cargar la imagen del jugador
        playerImage = new ImageIcon("assets/player_sprite.png").getImage();
        // Establecer el tamaño del PlayerView al tamaño de la imagen del jugador
    }
    
    public void render(Graphics g) {
        // Calcular las coordenadas y dimensiones escaladas de la imagen
        int scaledWidth = Constants.PLAYER_WIDTH;
        int scaledHeight = Constants.PLAYER_HEIGHT;

        // Dibujar la imagen del jugador escalada en las coordenadas iniciales
        g.drawImage(playerImage, game.getPlayer().getPosX(), game.getPlayer().getPosY(), scaledWidth, scaledHeight, null);    

    }
}
