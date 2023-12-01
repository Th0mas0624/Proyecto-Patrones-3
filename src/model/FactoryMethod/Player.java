package model.FactoryMethod;

import java.util.List;

import model.Ball;
import model.Observer.Observable;

public interface Player extends Observable{
    // Principales metodos
    public void move(int x,int y);
    public void agarrarPelota(List<Ball> balls);
    public void lanzarPelota(int targetX, int targetY);


    // otros
    public void serPonchado();
    public int getPosX();
    public int getPosY();
    public int getHealth();
    public int getPuntaje();
    public boolean isAgarre();
    public void setAgarre(boolean agarre);
    public String getPathImg();

}

