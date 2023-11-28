package model.Decorator;

import model.Ball;

public class SpeedPowerUp implements PowerUp {
    private int x, y;


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
        /*Esto en vez de llamar a una clase de ball 
         * es mejor hacer la logica aqui
         */
    }
}
