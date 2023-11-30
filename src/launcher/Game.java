package launcher;

import controller.PlayerController;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerAFactory;
import model.FactoryMethod.PlayerBFactory;
import model.FactoryMethod.PlayerFactory;
import util.Constants;

public class Game {

    private Player player;
    private Player player2;

    public Game() {
        // Inicializa player, playerView, playerController y otros elementos del juego
        initClasses();
    }

    private void initClasses() {
        // Inicializar el jugador
        PlayerFactory playerFactory = new PlayerAFactory();
        PlayerFactory playerFactory2 = new PlayerBFactory();
        player = playerFactory.createPlayer(Constants.INITIAL_PLAYER_X, Constants.INITIAL_PLAYER_Y);
        player2 = playerFactory2.createPlayer(Constants.INITIAL_PLAYER_X+100, Constants.INITIAL_PLAYER_Y+100);

    }

    public Player getPlayer() {
        return player;
    }
    
    public Player getPlayer2() {
        return player2;
    }

    
}

