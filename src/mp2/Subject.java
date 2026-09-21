package mp2;

public interface Subject {

    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyObservers(Stock stock);

}
