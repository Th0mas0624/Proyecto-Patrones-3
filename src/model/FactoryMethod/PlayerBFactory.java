package model.FactoryMethod;

public class PlayerBFactory implements PlayerFactory{
    
    /* Clase encargada de crear al jugador B */
    @Override
    public Player createPlayer(int x, int y){
        return new PlayerB(x, y);
    }
}
