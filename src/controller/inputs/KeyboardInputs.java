package controller.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FactoryMethod.Player;
import util.Constants;
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

		int spaceMovement = Constants.MOVEMENT_PLAYERS;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			if (player.getPosY() > Constants.PLAYER_UPPER_LIMIT)
				player.move(0, -spaceMovement);
				System.out.println(player.getPosY());
			break;
		case KeyEvent.VK_A:
			player.move(-spaceMovement, 0);
			break;
		case KeyEvent.VK_S:
			if (player.getPosY() < Constants.PLAYER_LOWER_LIMIT)
				player.move(0, spaceMovement);
			break;
		case KeyEvent.VK_D:
			if (player.getPosX() < Constants.PLAYER_RIGHT_LIMIT)
				player.move(spaceMovement, 0);
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
			if (player2.getPosY() > Constants.PLAYER_UPPER_LIMIT)
				player2.move(0, -spaceMovement);
			break;
		case KeyEvent.VK_J:
			if (player2.getPosX() >= 560)
				player2.move(-spaceMovement, 0);
				System.out.println(player2.getPosX());
			break;
		case KeyEvent.VK_K:
			if (player2.getPosY() < Constants.PLAYER_LOWER_LIMIT)
				player2.move(0, spaceMovement);
			break;
		case KeyEvent.VK_L:
			player2.move(spaceMovement, 0);
			break;
		}

	}



}