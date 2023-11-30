package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Ball;
import model.Campo;
import model.FactoryMethod.Player;
import view.PlayerView;

public class PlayerController implements KeyListener {
    private Player player;
    private PlayerView playerView;
    private Campo campo;

    public PlayerController(Player player, PlayerView playerView, Campo campo) {
        this.player = player;
        this.playerView = playerView;
        this.campo = campo;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W:
                player.move(0, -10); // Mover hacia arriba
                break;
            case KeyEvent.VK_A:
                player.move(-10, 0); // Mover hacia la izquierda
                break;
            case KeyEvent.VK_S:
                player.move(0, 10); // Mover hacia abajo
                break;
            case KeyEvent.VK_D:
                player.move(10, 0); // Mover hacia la derecha
                break;
            case KeyEvent.VK_E:
                if (player.isAgarre()) {
                    // Si el jugador ya tiene la pelota, lanzarla
                    player.lanzarPelota();
                } else {
                    player.agarrarPelota(campo.getBalls());
                }
                break;
        }

        // Notificar a la vista después de que el jugador se haya movido o lanzado la pelota
        playerView.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza en este ejemplo
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No se utiliza en este ejemplo
    }
}
