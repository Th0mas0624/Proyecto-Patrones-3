package model.Observer;

import java.util.ArrayList;
import java.util.List;

import model.FactoryMethod.Player;

public class Vida implements Observer{

    private Player player;
    
    public Vida(Player player){
        this.player = player;
        player.addObserver(this);
    }

    @Override
    public void update() {
         System.out.println("Vida del jugador actualizada: " + player.getHealth());
    }
    
}
