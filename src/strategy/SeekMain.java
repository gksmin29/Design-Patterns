package strategy;

public class SeekMain {

    private SeekStrategy seekStrategy;

    public void setSeekStrategy(SeekStrategy seekStrategy) {
        this.seekStrategy = seekStrategy;
    }

    public void process(int[] queue, int start) {
        seekStrategy.process(queue, start);
    }


}
