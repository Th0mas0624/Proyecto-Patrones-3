package controller;

import model.Campo;
import view.CampoView;

public class CampoController {
    private static final int FPS = 60; // Número de fotogramas por segundo
    private Campo game;
    private CampoView gamePanel;
    private boolean gameRunning;

    public CampoController(Campo game, CampoView gamePanel) {
        this.game = game;
        this.gamePanel = gamePanel;
        this.gameRunning = false;
    }

    public void startGame() {
        gameRunning = true;

        while (gameRunning) {
            long startTime = System.currentTimeMillis();

            // Actualizar lógica del juego
            updateGame();

            // Renderizar la vista
            gamePanel.repaint();

            // Calcular el tiempo de espera hasta el siguiente fotograma
            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = 1000 / FPS - elapsedTime;

            // Esperar si es necesario para mantener el FPS constante
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void updateGame() {
        // Actualizar lógica del juego
        game.handleCollisions(); // Método hipotético para manejar colisiones
        
    }
    

    public void stopGame() {
        gameRunning = false;
    }
}
