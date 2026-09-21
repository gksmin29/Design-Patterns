package mp2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int samsung = rand.nextInt(30, 150);
        int hynix = rand.nextInt(30, 150);
        int hyundai = rand.nextInt(30, 150);

        Supplier supplier = new Supplier(samsung, hynix, hyundai);
        Thread supplierThread = new Thread(supplier);

        ConsumerPriceLogger consumerPriceLogger = new ConsumerPriceLogger(samsung, hynix, hyundai);
        ConsumerThresholdAlert consumerThresholdAlert = new ConsumerThresholdAlert(samsung, hynix, hyundai);

        supplier.registerObserver(consumerPriceLogger);
        supplier.registerObserver(consumerThresholdAlert);

        Thread consumerPriceLoggerThread = new Thread(new ConsumerPriceLogger(samsung, hynix, hyundai));
        Thread consumerThresholdAlertThread = new Thread(new ConsumerThresholdAlert(samsung, hynix, hyundai));

        supplierThread.start();
        consumerPriceLoggerThread.start();
        consumerThresholdAlertThread.start();
    }

}
