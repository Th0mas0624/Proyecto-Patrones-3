package controller;

import model.Campo;
import view.CampoView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController {
    private Campo game;
    private CampoView gamePanel;

    public GameController(Campo game, CampoView gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
        setupMouseListener();
    }

    private void setupMouseListener() {
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Lógica para manejar clics del mouse (por ejemplo, lanzar la pelota al hacer clic)
                    
                }
            }
        });
    }

    public void startGame() {
        // Lógica para iniciar el juego
        // Puedes implementar el bucle del juego aquí
    }
}
