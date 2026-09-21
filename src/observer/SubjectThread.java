package observer;

public interface SubjectThread {

    void registerObserver(ObserverThread obs);
    void unregisterObserver(ObserverThread obs);
    void notifyObservers(Object arg);

}
