package observer;

public class ConsumerThread implements ObserverThread, Runnable {

    private int num;
    private SupplierThread supplier;

    public ConsumerThread(int n, SupplierThread supplier) {
        num = n;
        this.supplier = supplier;
    }

    @Override
    public void update(Object arg) {
        System.out.println("Consumer " + num + ", state " + arg);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
