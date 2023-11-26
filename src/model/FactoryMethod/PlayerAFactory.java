package model.FactoryMethod;

import javax.swing.ImageIcon;

public class PlayerAFactory implements PlayerFactory{
    
    @Override
    public Player createPlayer(int x, int y){
        return new PlayerA(x, y);
    }
    
}
