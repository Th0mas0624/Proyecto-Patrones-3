package model;

public class Ball {
    
    public int posX;
    public int posY;

    public Ball(int x, int y){
        this.posX = x;
        this.posY = y;
    }
    public void move(int x, int y){
        this.posX += x;
        this.posY += y;
    }
}
