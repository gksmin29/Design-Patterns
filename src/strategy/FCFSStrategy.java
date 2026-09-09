package strategy;

import java.util.Arrays;

public class FCFSStrategy implements SeekStrategy{

    @Override
    public void process(int[] queue, int start) {
        // 순서대로 이동
        for (int i = 0; i < queue.length; i++) {
            System.out.printf("%d ", queue[i]);
        }
        System.out.printf("\n");
    }
}
