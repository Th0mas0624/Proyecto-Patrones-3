package controller.inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FactoryMethod.Player;
import util.Constants;
import view.GamePanel;

public class KeyboardInputs implements KeyListener, Runnable {

    private GamePanel gamePanel;
    private Player player;
    private Player player2;
    private boolean[] keys;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.player = gamePanel.getGame().getPlayers().get(0);
        this.player2 = gamePanel.getGame().getPlayers().get(1);
        this.keys = new boolean[256];
        // Iniciar el hilo para manejar la entrada
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            handleInput();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput() {
        int spaceMovement = Constants.MOVEMENT_PLAYERS;

        if (keys[KeyEvent.VK_W] && player.getPosY() > Constants.PLAYER_UPPER_LIMIT) {
            player.move(0, -spaceMovement);
        }
        if (keys[KeyEvent.VK_A]) {
            player.move(-spaceMovement, 0);
        }
        if (keys[KeyEvent.VK_S] && player.getPosY() < Constants.PLAYER_LOWER_LIMIT) {
            player.move(0, spaceMovement);
        }
        if (keys[KeyEvent.VK_D] && player.getPosX() < Constants.PLAYER_RIGHT_LIMIT) {
            player.move(spaceMovement, 0);
        }
        if (keys[KeyEvent.VK_Q]) {
            if (!player.isAgarre()){
                player.agarrarPelota(gamePanel.getGame().getBalls());
            }
        }
		if (keys[KeyEvent.VK_E]) {
            if (player.isAgarre()) {
                player.lanzarPelota(player2.getPosX(), player2.getPosY());
            }
        }

        if (keys[KeyEvent.VK_U]) {
            if (!player2.isAgarre()){
                player2.agarrarPelota(gamePanel.getGame().getBalls());
            }
        }
		if (keys[KeyEvent.VK_O]) {
            if (player2.isAgarre()) {
                player2.lanzarPelota(player.getPosX(), player.getPosY());
            }
        }
        if (keys[KeyEvent.VK_I] && player2.getPosY() > Constants.PLAYER_UPPER_LIMIT) {
            player2.move(0, -spaceMovement);
        }
        if (keys[KeyEvent.VK_J] && player2.getPosX() >= 560) {
            player2.move(-spaceMovement, 0);
        }
        if (keys[KeyEvent.VK_K] && player2.getPosY() < Constants.PLAYER_LOWER_LIMIT) {
            player2.move(0, spaceMovement);
        }
        if (keys[KeyEvent.VK_L]) {
            player2.move(spaceMovement, 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza en este ejemplo
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Actualizar el estado de las teclas cuando se sueltan
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Actualizar el estado de las teclas cuando se presionan
        keys[e.getKeyCode()] = true;
    }
}
