package model.Observer;

import java.util.ArrayList;
import java.util.List;


import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerA;

public class Marcador implements Observer{

    private Player player;

    public Marcador(Player player){
        this.player = player;
        player.addObserver(this);
    }
    @Override
    public void update(Observable marcador) {
        if (marcador instanceof Player) {
            Player updatedplayer = (Player) marcador;
            // Realizar la lógica de actualización del marcador según los cambios en el player
            actualizarMarcador(updatedplayer.getPuntaje());
        }
    }

    private void actualizarMarcador(int puntaje) {
        // Lógica para actualizar el marcador (imprimirlo por ahora)
        System.out.println("Marcador actualizado: " + puntaje);
    }
    
}
