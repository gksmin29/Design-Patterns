package mp2;

import java.util.HashMap;
import java.util.Map;

public class ConsumerThresholdAlert implements Observer, Runnable {

    private final int threshold = 90;

    Map<String, Integer> stocks = new HashMap<>();


    public ConsumerThresholdAlert(int samsung, int hynix, int hyundai) {
        stocks.put("samsung", samsung);
        stocks.put("hynix", hynix);
        stocks.put("hyundai", hyundai);
    }

    @Override
    public void run() {
    }

    @Override
    public void update(Stock stock) {
        for (String s : stocks.keySet()) {
            if (s.equals(stock.stock())) {
                stocks.put(s, stock.stockPrice());
                if (stocks.get(s) >= threshold) {
                    System.out.println(s + "이(가) 90 이상입니다.");
                }
            }
        }
    }
}
