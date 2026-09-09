package strategy;

public class SSTFStrategy implements SeekStrategy{

    @Override
    public void process(int[] queue, int start) {
        int curPos = start;
        int readCount = 0; // 읽은(처리한) 위치의 개수
        boolean[] read = new boolean[queue.length]; // 읽었는지 확인

        for (int i = 0; i < read.length; i++) { // 읽지 않음으로 표시
            read[i] = false;
        }

        // 읽지 않은 노드 중에서 가장 거리가 짧은 곳을 찾아서 이동
        while (readCount < read.length) { // 마지막 위치를 제외하고 처리
            int shortestIdx = -1; // 나올 수 없는 인덱스 값으로 지정
            int minDist = Integer.MAX_VALUE; // 최대값으로 설정
            // 큐에 있는 위치에서 아직 읽지 않은 위치에 대해
            // 최단 거리에 있는 인덱스를 찾는 작업
            for (int i = 0; i < queue.length; i++) {
                if (read[i] == false) {
                    int distance = Math.abs(queue[i] - curPos);
                    if (distance < minDist) {
                        shortestIdx = i;
                        minDist = distance;
                    }
                }
            }
            // 최단 거리 위치로 조정
            curPos = queue[shortestIdx];
            read[shortestIdx] = true;
            readCount++;
            System.out.printf("%d ", curPos);
        }
        System.out.printf("\n");
    }
}
