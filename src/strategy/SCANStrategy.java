package strategy;

import java.util.Arrays;

public class SCANStrategy implements SeekStrategy{

    @Override
    public void process(int[] queue, int start) {
        // 헤드(head)가 작은 번호쪽으로 움직이고 있다고 가정
        // 배열을 복사해서 새로운 배열을 생성해야 함
        // 원본 배열이 정렬되면 다른 알고리즘을 실행시킬 때 영향을 미치게 됨
        int[] tempQueue = new int[queue.length];
        for (int i = 0; i < queue.length; i++) {
            tempQueue[i] = queue[i];
        }
        // 새로 생성한 배열을 오름차순으로 정렬
        Arrays.sort(tempQueue);
        // 배열의 실린더 값에서 start보다 작거나 같은 가장 큰 숫자의 위치를 찾음
        int idx = -1;
        for (int i = 0; i < tempQueue.length; i++) {
            if (tempQueue[i] > start) {
                idx = i;
                break;
            }
        }
        // 작은 쪽으로 head 이동
        for (int i = idx - 1; i >= 0; i--) {
            System.out.printf("%d ", tempQueue[i]);
        }
        System.out.print("0 ");  // 끝에 도달했음을 표시
        // 반대 방향으로 이동하면서 나머지 처리
        for (int i = idx; i < tempQueue.length; i++) {
            System.out.printf("%d ", tempQueue[i]);
        }
        System.out.printf("\n");
    }
}
