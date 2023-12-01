package launcher;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Campo;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerAFactory;
import model.FactoryMethod.PlayerBFactory;
import model.FactoryMethod.PlayerFactory;
import util.Constants;

public class Game {


    private Campo campo;
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
        players.add(playerFactory2.createPlayer(Constants.INITIAL_PLAYER_X_2, Constants.INITIAL_PLAYER_Y_2));
        balls.add(new Ball(200, 400));

        Campo campo = new Campo();
        campo.addBall(balls.get(0));
        campo.addPlayer(players.get(0));
        campo.addPlayer(players.get(1));
        System.out.println(campo.getBalls().get(0).getPosX());
        System.out.println(campo.getJugadores().get(0).getPosX());

        campo.handlePlayerCollisions();

        


    }


    public List<Player> getPlayers() {
        return players;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}

