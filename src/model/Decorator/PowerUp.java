package model.Decorator;

import model.Ball;

public interface PowerUp {
    public int getX();
    public int getY();
    public void applyPowerUp(Ball ball);
    
}
