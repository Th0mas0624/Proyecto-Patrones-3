package launcher;

import java.util.ArrayList;
import java.util.List;

import controller.PlayerController;
import model.Ball;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerAFactory;
import model.FactoryMethod.PlayerBFactory;
import model.FactoryMethod.PlayerFactory;
import util.Constants;

public class Game {

    private Player player;
    private Player player2;
    private List<Player> players = new ArrayList<>();
    private List<Ball> balls = new ArrayList<>();
    public Game() {
        // Inicializa player, playerView, playerController y otros elementos del juego
        initClasses();
    }

    private void initClasses() {
        // Inicializar el jugador
        PlayerFactory playerFactory = new PlayerAFactory();
        PlayerFactory playerFactory2 = new PlayerBFactory();
        players.add(playerFactory.createPlayer(Constants.INITIAL_PLAYER_X, Constants.INITIAL_PLAYER_Y));
        players.add(playerFactory2.createPlayer(Constants.INITIAL_PLAYER_X+100, Constants.INITIAL_PLAYER_Y+100));
        balls.add(new Ball(200, 200));

    }

    public Player getPlayer() {
        return player;
    }
    
    public Player getPlayer2() {
        return player2;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}

