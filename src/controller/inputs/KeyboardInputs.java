package controller.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FactoryMethod.Player;
import view.GamePanel;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;
	private Player player;
	private Player player2;
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.player = gamePanel.getGame().getPlayers().get(0);
		this.player2 = gamePanel.getGame().getPlayers().get(1);
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
            case KeyEvent.VK_Z:
                System.out.println("SOltaste Z");
                break;
        }
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.move(0, -10);
			break;
		case KeyEvent.VK_A:
			player.move(-10, 0);
			break;
		case KeyEvent.VK_S:
			player.move(0, 10);
			break;
		case KeyEvent.VK_D:
			player.move(10, 0);
			break;
		case KeyEvent.VK_Z:
			if (player.isAgarre()) {
				// Si el jugador ya tiene la pelota, lanzarla
				player.lanzarPelota();
			} else {
				player.agarrarPelota(gamePanel.getGame().getBalls());
			}
			break;		
		case KeyEvent.VK_X:
            System.out.println("X");
			break;
		case KeyEvent.VK_I:
			player2.move(0, -10);
			break;
		case KeyEvent.VK_J:
			player2.move(-10, 0);
			break;
		case KeyEvent.VK_K:
			player2.move(0, 10);
			break;
		case KeyEvent.VK_L:
			player2.move(10, 0);
			break;
		}

	}



}