package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import launcher.Game;
import util.Constants;

public class CampoView {
    private Game game;
    private Image backgroundImage;

    public CampoView(Game game){
        this.game = game;
        loadImage();
    }


    private void loadImage(){
        // Lógica para cargar la imagen de fondo
        backgroundImage = new ImageIcon("assets/cancha.png").getImage();
        // Establecer el tamaño del CampoView al tamaño de la imagen de fondo
    }
    

    public void render(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT, null);
    }

    
}
