package observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SupplierThread implements SubjectThread, Runnable {

    private List<ObserverThread> observers;
    private int state;
    private Random rand;

    public SupplierThread() {
        observers = new ArrayList<>();
        rand = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int value = rand.nextInt(11);
            System.out.println("Supplier count: " + i + ", " + value + " 생성됨");
            if (value >= 5 && value != state) {
                state = value;
                notifyObservers(value);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void registerObserver(ObserverThread obs) {
        observers.add(obs);
    }

    @Override
    public void unregisterObserver(ObserverThread obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (ObserverThread o : observers) {
            o.update(arg);
        }
    }
}
