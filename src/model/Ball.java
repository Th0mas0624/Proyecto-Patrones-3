package model;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Decorator.PowerUp;
import model.FactoryMethod.Player;
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
 
    private String pathImg =  "assets\\ball.png";
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
        Timer timer = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (agarrada) {
                posX = player.getPosX();
                posY = player.getPosY();
                //repaint();  // Asegúrate de llamar a repaint para actualizar la vista
            } else {
                ((Timer) e.getSource()).stop();  // Detener el temporizador cuando ya no esté agarrada
            }
        }
    });

    // Iniciar el temporizador
    timer.start();

    }
    /* Logica encargada de poner en movimiento el balon */
    public void move(){
        if (!enMovimiento) {
            enMovimiento = true;
            agarrada = false;
            // Inicializar la velocidad (puedes ajustar según tus necesidades)
            velocidadX = 10;
            velocidadY = 10;
            updatePosition();
        }
    }

    
    /* Metodo para el lanzamiento de la pelota*/
    public void updatePosition() {
        if (enMovimiento) {
            while (enMovimiento) {
                // Actualizar continuamente la posición de la pelota
                posX += velocidadX;
                posY += velocidadY;

                // Agregar lógica para detectar colisiones con los bordes del campo
                // Puedes ajustar según las dimensiones de tu campo
                
                if (posX <= 0 || posX >= Constants.PLAYER_RIGHT_LIMIT) {
                    // La pelota chocó con el borde izquierdo o derecho, cambiar dirección
                    detenerMovimiento();
                }

                if (posY <= 0 || posY >= Constants.PLAYER_LOWER_LIMIT) {
                    // La pelota chocó con el borde superior o inferior, cambiar dirección
                    detenerMovimiento();
                }
            }
            
        }
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
