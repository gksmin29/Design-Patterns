package observer;

public class Consumer implements Observer {

    private int num;
    private Subject subject;

    public Consumer(int n, Subject subject) {
        num = n;
        this.subject = subject;
    }

    public void update() {
        int state = subject.getState();
        System.out.println("Consumer " + num + ", state " + state);
    }

}
