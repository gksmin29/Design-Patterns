package observer;

public class Main {

    public static void main(String[] args) {
        Supplier subject = new Supplier();
        Observer observer1 = new Consumer(1, subject);
        Observer observer2 = new Consumer(2, subject);

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        for (int i = 0; i < 5; i++) {
            System.out.println("Run count = " + i);
            subject.run();
        }
    }

}
