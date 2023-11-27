package model.FactoryMethod;

import java.util.List;

import model.Ball;

public interface Player {
    public void move(int x,int y);
    public void agarrarPelota(List<Ball> balls);
    public void lanzarPelota();
    public void serPonchado();
}

