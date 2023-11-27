package model;

public class Ball {
    
    private int posX;
    private int posY;
    private boolean enMovimiento;

    public Ball(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    public void move(){
        this.enMovimiento = true;
    }

    public void detenerMovimiento(){
        this.enMovimiento = false;
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

    
}
