package model;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Decorator.PowerUp;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerA;
import util.Constants;

public class Ball {
    
    private int posX;
    private int posY;
    /* enMovimiento: Verifica si el balon esta actualmente en movimiento */
    private boolean enMovimiento;
    private PowerUp powerUp;

    //propiedades para manejar la dirección y velocidad de la pelota
    private int velocidadX;
    private int velocidadY;
    private boolean agarrada=false;
 
    private String pathImg =  "assets/ball.png";
    public Ball(int x, int y){
        this.posX = x;
        this.posY = y;
        this.enMovimiento = false;
        this.powerUp = null;
        this.velocidadX = 0;
        this.velocidadY = 0;
    }


    public void pelotaAgarrada(Player player){
        agarrada = true;
        // Crear un temporizador que actualice la posición de la pelota cada 100 milisegundos
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agarrada) {
                    if(player instanceof PlayerA ){
                        posX = player.getPosX()+80;
                    }else{
                        posX = player.getPosX()-50;
                    }
                    
                    posY = player.getPosY();
                } else {
                    ((Timer) e.getSource()).stop();  // Detener el temporizador cuando ya no esté agarrada
                }
            }
        });

        // Iniciar el temporizador
        timer.start();

    }
    /* Logica encargada de poner en movimiento el balon */
    public void move(int targetX, int targetY) {
        if (!enMovimiento) {
            enMovimiento = true;
            agarrada = false;
            // Calcular la dirección hacia las coordenadas del jugador 2
            double direccionX = (targetX - posX) / Math.hypot(targetX - posX, targetY - posY);
            double direccionY = (targetY - posY) / Math.hypot(targetX - posX, targetY - posY);
            // Establecer las velocidades según la dirección calculada
            velocidadX =(int) (5 * direccionX);  // Ajusta la velocidad según sea necesario
            velocidadY = (int) (5 * direccionY);  // Ajusta la velocidad según sea necesario
            updatePosition(targetX, targetY);
        }
    }

    public void updatePosition(int targetX, int targetY) {
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enMovimiento) {
                    posX += velocidadX;
                    posY += velocidadY;
                    // Verificar si la pelota está dentro del radio de tolerancia del objetivo
                    if (Math.abs(posX - targetX) <= Constants.RADIO_TARGET_BALL) {
                        detenerMovimiento();
                        ((Timer) e.getSource()).stop();  // Detener el temporizador cuando llega a su destino
                    }
                    // Verificar colisiones con los bordes del campo
                    if (posX <= 0 || posX >= Constants.FIELD_WIDTH || posY <= 0 || posY >= Constants.FIELD_HEIGHT) {
                        detenerMovimiento();
                        ((Timer) e.getSource()).stop();  // Detener el temporizador cuando llega a su destino
                    }
                }
            }
        });
    
        timer.start();
    }
    

    /*Una vez que el balon llega a su destino se detiene
     * o en caso de que un jugador lo detenga antes
     */
    public void detenerMovimiento(){
        enMovimiento = false;
        powerUp = null;
        // Detener la velocidad
        velocidadX = 0;
        velocidadY = 0;
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
        velocidadX += 2;
        velocidadY += 2;
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

    public String getPathImg() {
        return pathImg;
    }
    
}
