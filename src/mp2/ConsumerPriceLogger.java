package mp2;

import java.util.HashMap;
import java.util.Map;

public class ConsumerPriceLogger implements Observer, Runnable {
    Map<String, Integer> stocks = new HashMap<>();


    public ConsumerPriceLogger(int samsung, int hynix, int hyundai) {
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
                System.out.println(s + "이(가) 변동되었습니다." + " 가격 = " + stock.stockPrice());
                stocks.put(s, stock.stockPrice());
            }
        }
    }
}
