package observer;

public class MainThread {
    public static void main(String[] args) {
        SupplierThread supplier = new SupplierThread();
        Thread supplierThread = new Thread(supplier);

        ObserverThread observer1 = new ConsumerThread(1, supplier);
        ObserverThread observer2 = new ConsumerThread(2, supplier);

        supplier.registerObserver(observer1);
        supplier.registerObserver(observer2);

        Thread consumerThread1 = new Thread(new ConsumerThread(1, supplier));
        Thread consumerThread2 = new Thread(new ConsumerThread(2, supplier));

        supplierThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }

}
