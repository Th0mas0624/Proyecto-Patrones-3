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
    public void update(Observable player) {
        if (player instanceof Player) {
            Player updatedPlayer = (Player) player;
            System.out.println("Vida del jugador actualizada: " + updatedPlayer.getHealth());
        }
    }
    
}
