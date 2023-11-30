package model.Observer;

public interface Observable {
    public void addObserver(Observer observador);
    public void removeObserver(Observer observador);
    public void notifyObservers();
}
