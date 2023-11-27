package model;

import model.Decorator.PowerUp;

public class Ball {
    
    private int posX;
    private int posY;
    /* enMovimiento: Verifica si el balon esta actualmente en movimiento */
    private boolean enMovimiento;
    private PowerUp powerUp;

    public Ball(int x, int y){
        this.posX = x;
        this.posY = y;
        this.enMovimiento = false;
        this.powerUp = null;
    }

    /* Logica encargada de poner en movimiento el balon */
    public void move(){
        this.enMovimiento = true;
    }

    /*Una vez que el balon llega a su destino se detiene
     * o en caso de que un jugador lo detenga antes
     */
    public void detenerMovimiento(){
        this.enMovimiento = false;
        powerUp = null;
    }

    /*Logica para cambiar el poder  */
    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public void applyPowerUp() {
        if (powerUp != null) {
            powerUp.applyPowerUp(this);
        }
    }

    /*Poder del balon, esto lo debe hacer directamente la clase SpeedPower */
    public void increaseSpeed() {
        // Lógica para aumentar la velocidad de la pelota
    }

    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public boolean isEnMovimiento(){
        return enMovimiento;
    }

    
}
