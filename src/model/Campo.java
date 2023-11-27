package model;

import java.util.List;

import model.FactoryMethod.Player;

public class Campo {
    private List<Player> jugadores;
    private List<Ball> balls;
    /*private List<PowerUp> poderes;*/

    public void agregarJugador(Player player){
        jugadores.add(player);
    }

    public void agregarBalon(Ball ball){
        balls.add(ball);
    }
}
