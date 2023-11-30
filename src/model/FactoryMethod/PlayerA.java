package model.FactoryMethod;

import java.util.ArrayList;
import java.util.List;

import model.Ball;
import model.Observer.Observable;
import model.Observer.Observer;

public class PlayerA implements Player{
    
    /*
     * posX y posY: Posiciones del jugador
     * health: Vida del jugador
     * agarre: Verifica si agarro algun balon
     * ball: Es la pelota que esta agarrada por el jugador
     * observers: 
     */
    private int posX, posY;
    private int health=3;
    private boolean agarre=false;
    private Ball ball;
    private List<Observer> observers = new ArrayList<>();
    private int puntaje = 0;

    private String pathImg = "assets/spiderman.png";

    public PlayerA(int x, int y){
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
                System.out.println("agarro la pelota");
            }
        }
    }

    /*Logica para lanzar la pelota */
    @Override
    public void lanzarPelota(){
        if (agarre){
            this.ball.move();
            System.out.println("solto pelota");
            this.agarre = false;
        }
    }

    /* Logica para determinar cuando el jugador sea ponchado */
    @Override
    public void serPonchado(){
        this.health -= 1;
        if(health <= 0){
            notifyObservers();
        }
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
        for (Observer observer : observers) {
            // Notificar a cada observador sobre la pérdida de vida del jugador
            observer.update(this);
        }
    }

    /* Getters y Setters */
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

    public int getPuntaje() {
        return puntaje;
    }

    public String getPathImg() {
        return pathImg;
    }
    
}
