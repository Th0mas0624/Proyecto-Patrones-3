package model.Observer;

import java.util.ArrayList;
import java.util.List;

import model.Campo;

public class Marcador implements Observer{

    private Campo campo;

    public Marcador(Campo campo){
        this.campo = campo;
        campo.addObserver(this);
    }
    @Override
    public void update() {
        
    }
    
}
