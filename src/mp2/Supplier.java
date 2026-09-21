package mp2;

import java.util.*;

public class Supplier implements Subject, Runnable{

    Map<String, Integer> stocks = new HashMap<>();

    Random rand;

    List<Observer> observerList;

    public Supplier(int samsung, int hynix, int hyundai) {
        stocks.put("samsung", samsung);
        stocks.put("hynix", hynix);
        stocks.put("hyundai", hyundai);
        observerList = new ArrayList<>();
        rand = new Random();
    }

    @Override
    public void notifyObservers(Stock stock) {
        for (Observer observer : observerList) {
            observer.update(stock);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            for (String s : stocks.keySet()) {
                int originalStockPrice = stocks.get(s);
                int newStockPrice;
                if (rand.nextInt(1, 3) == 1) {
                    newStockPrice = originalStockPrice + rand.nextInt(10, 21);
                }
                else {
                    newStockPrice = originalStockPrice - rand.nextInt(10, 21);
                }

                if (originalStockPrice != newStockPrice) {
                    notifyObservers(new Stock(s, newStockPrice));
                }
                stocks.put(s, newStockPrice);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
