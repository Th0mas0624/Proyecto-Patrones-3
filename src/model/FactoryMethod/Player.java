package model.FactoryMethod;

import java.util.List;

import model.Ball;
import model.Observer.Observable;

public interface Player extends Observable{
    public void move(int x,int y);
    public void agarrarPelota(List<Ball> balls);
    public void lanzarPelota();
    public void serPonchado();
    public int getPosX();
    public int getPosY();
    public int getHealth();
    public int getPuntaje();
    public boolean isAgarre();
    public void setAgarre(boolean agarre);

}

