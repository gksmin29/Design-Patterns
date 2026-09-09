package strategy;

class Main {
    public static void main(String[] args) {
        int[] queue = { 70, 53, 24, 57, 140, 15, 115, 80, 85 };
        int start = 43;

        SeekMain seek = new SeekMain();

        // 각각의 Strategy를 객체 배열로 선언해도 된다.
        SeekStrategy[] strategy = {
                new FCFSStrategy(), new SCANStrategy(), new SSTFStrategy()
        };

        FCFSStrategy fcfsStrategy = new FCFSStrategy();
        SCANStrategy scanStrategy = new SCANStrategy();
        SSTFStrategy sstfStrategy = new SSTFStrategy();

        System.out.println("FCFS");
        seek.setSeekStrategy(fcfsStrategy);
        seek.process(queue, start);

        System.out.println("SCAN");
        seek.setSeekStrategy(scanStrategy);
        seek.process(queue, start);

        System.out.println("SSTF");
        seek.setSeekStrategy(sstfStrategy);
        seek.process(queue, start);

    }
}