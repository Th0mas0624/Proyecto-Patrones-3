package model.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Observer.Observable;
import model.Observer.Observer;

public class PlayerB implements Player{
    
    /*
     * posX y posY: Posiciones del jugador
     * health: Vida del jugador
     * agarre: Verifica si agarro algun balon
     * ball: Es la pelota que esta agarrada por el jugador
     */
    private int posX, posY;
    private int health=3;
    private boolean agarre=false;
    private Ball ball;
    private List<Observer> observers = new ArrayList<>();
    public PlayerB(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    /*Movimieto del jugador */
    @Override
    public void move(int x, int y){
        this.posX += x;
        this.posY += y;
    }

    /*Verificacion para poder agarrar una pelota */
    @Override
    public void agarrarPelota(List<Ball> balls){

        for (Ball ball : balls) {
            if(ball.getPosX() == posX && ball.getPosY() == posY){
                this.agarre = true;
                this.ball = ball;
            }
        }
    }

    /*Logica para lanzar la pelota */
    @Override
    public void lanzarPelota(){
        if (agarre){
            this.ball.move();
        }
    }

    /*Logica para verificar si el jugador esta ponchado */
    @Override
    public void serPonchado(){

    }


     /* Funcion para agregar el observador Vida */
    @Override
    public void addObserver(Observer o){
        observers.add(o);
    }

    /* Funcion para remover el observador */
    @Override
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    /* 
     * Funcion encargada de notificar al otro jugador
     * para ir eliminando vidas
     */
    @Override
    public void notifyObservers(){

    }

    /*Getters y Setters */
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAgarre() {
        return agarre;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAgarre(boolean agarre) {
        this.agarre = agarre;
    }  
}