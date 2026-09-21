package observer;

public interface Subject {

    int getState();
    void registerObserver(Observer obs);
    void unregisterObserver(Observer obs);
    void notifyObservers();

}
