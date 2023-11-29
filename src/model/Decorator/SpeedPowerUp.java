package model.Decorator;

import java.util.Random;

import model.Ball;

public class SpeedPowerUp implements PowerUp {
    private int x, y;

    public SpeedPowerUp(){
        // Inicializar las coordenadas con números aleatorios entre 100 y 400
        Random random = new Random();
        this.x = random.nextInt(301) + 100; // Números entre 100 y 400 (ambos inclusive)
        this.y = random.nextInt(301) + 100;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void applyPowerUp(Ball ball) {
        ball.increaseSpeed();
    }
}
