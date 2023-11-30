package controller.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.FactoryMethod.Player;
import view.GamePanel;

public class KeyboardInputs implements KeyListener {

	private GamePanel gamePanel;
	private Player player;

	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.player = gamePanel.getGame().getPlayer();
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
			player.move(0, -5);
			break;
		case KeyEvent.VK_A:
			player.move(-5, 0);
			break;
		case KeyEvent.VK_S:
			player.move(0, 5);
			break;
		case KeyEvent.VK_D:
			player.move(5, 0);
			break;
		case KeyEvent.VK_Z:
			System.out.println("Z");			
			break;
		case KeyEvent.VK_K:
            System.out.println("K");
			break;
		}

	}



}