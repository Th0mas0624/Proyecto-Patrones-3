package model.FactoryMethod;


public class PlayerAFactory implements PlayerFactory{
    
    /*Clase encargada de crear al jugador A*/
    @Override
    public Player createPlayer(int x, int y){
        return new PlayerA(x, y);
    }
    
}
