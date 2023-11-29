package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Decorator.PowerUp;
import model.FactoryMethod.Player;
import model.Observer.Observable;
import model.Observer.Observer;

public class Campo implements Observable {
    private List<Player> jugadores = new ArrayList<>();
    private List<Ball> balls = new ArrayList<>();
    private List<PowerUp> poderes = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private int puntaje; // Asumiendo que el campo tiene un puntaje

    public void addPlayer(Player player) {
        jugadores.add(player);
    }

    public void addBall(Ball ball) {
        balls.add(ball);
    }

    public void addPowerUp(PowerUp powerUp) {
        poderes.add(powerUp);
    }

    public void handleCollisions() {
        handlePlayerBallCollisions();
        handleBallPowerUpCollisions();
        // Otros métodos de manejo de colisiones si es necesario
    }

    private void handlePlayerBallCollisions() {
        Iterator<Ball> ballIterator = balls.iterator();
        while (ballIterator.hasNext()) {
            Ball ball = ballIterator.next();
            for (Player player : jugadores) {
                if (player.getPosX() == ball.getPosX() && player.getPosY() == ball.getPosY()) {
                    player.agarrarPelota(balls);
                    ballIterator.remove();
                    notifyObservers(); // Notificar cambios a los observadores (puntaje)
                }
            }
        }
    }

    private void handleBallPowerUpCollisions() {
        Iterator<PowerUp> powerUpIterator = poderes.iterator();
        while (powerUpIterator.hasNext()) {
            PowerUp powerUp = powerUpIterator.next();
            for (Ball ball : balls) {
                if (ball.getPosX() == powerUp.getX() && ball.getPosY() == powerUp.getY()) {
                    ball.setPowerUp(powerUp);
                    powerUpIterator.remove();
                }
            }
        }
    }

    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
