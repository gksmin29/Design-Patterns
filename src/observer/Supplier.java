package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supplier implements Subject{

    private int state = 0;
    private List<Observer> observers;
    private Random rand;

    public Supplier() {
        observers = new ArrayList<>();
        rand = new Random();
    }

    public void run() {
        int value = rand.nextInt(11);
        if (value >= 5 && value != state) {
            state = value;
            notifyObservers();
        }
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void unregisterObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

}
