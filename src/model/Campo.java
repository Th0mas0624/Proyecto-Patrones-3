package model;

import java.util.ArrayList;
import java.util.List;

import model.Decorator.PowerUp;
import model.FactoryMethod.Player;
import model.Observer.Observable;
import model.Observer.Observer;

public class Campo implements Observable{
    private List<Observer> observers = new ArrayList<>();
    private List<Player> jugadores = new ArrayList<>();
    private List<Ball> balls = new ArrayList<>();
    private List<PowerUp> poderes = new ArrayList<>();

    /* Metodos para añadir los componentes que van en el campo */
    public void addPlayer(Player player){
        jugadores.add(player);
    }

    public void addBall(Ball ball){
        balls.add(ball);
    }
    public void addPowerUp(PowerUp powerUp){
        poderes.add(powerUp);
    }

    /* Metodos del patron observer para ver el marcador */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public int getScore() {
        // Lógica para obtener la puntuación del juego
        return 0;  // Reemplazar con la lógica real
    }
}
