package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Ball;
import model.FactoryMethod.Player;

// PlayerController
public class PlayerController implements KeyListener {
    private Player player;
    private Ball ball;

    public PlayerController(Player player, Ball ball) {
        this.player = player;
        this.ball = ball;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key Pressed");
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
                if (!ball.isEnMovimiento()) {
                    ball.move(); // Lanzar la pelota
                }
                break;
            // Asegúrate de que la vista se actualice después del movimiento
            
        }
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
