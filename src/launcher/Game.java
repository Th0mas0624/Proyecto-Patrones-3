package launcher;

import controller.PlayerController;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerAFactory;
import model.FactoryMethod.PlayerFactory;
import util.Constants;

public class Game {

    private Player player;
    

    public Game() {
        // Inicializa player, playerView, playerController y otros elementos del juego
        initClasses();
    }

    private void initClasses() {
        // Inicializar el jugador
        PlayerFactory playerFactory = new PlayerAFactory();
        player = playerFactory.createPlayer(Constants.INITIAL_PLAYER_X, Constants.INITIAL_PLAYER_Y);
        
        
        
    }

    public Player getPlayer() {
        return player;
    }
    

    
}

