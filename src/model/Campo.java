package model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Decorator.PowerUp;
import model.FactoryMethod.Player;
import model.Observer.Observable;
import model.Observer.Observer;
import util.Constants;

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

    public void handlePlayerCollisions() {
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                for (Ball ball : balls) {
                    if ( ball.isEnMovimiento()) {  // Verificar si la pelota está en movimiento
                        for (Player player : jugadores) {

                            // Verificar si la pelota está dentro del radio de tolerancia del jugador
                            if (Math.abs(player.getPosX() - ball.getPosX()) <= Constants.RADIO_PONCHAR
                                    && Math.abs(player.getPosY() - ball.getPosY()) <= Constants.RADIO_PONCHAR) {
                                player.serPonchado();
                                System.out.println("Player fue ponchado");
                                ball.detenerMovimiento();
                                notifyObservers(); // Notificar cambios a los observadores (puntaje)
                            }
                        }
                    }
                }
            }
        });
    
        timer.start();
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

    public List<Player> getJugadores() {
        return jugadores;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
