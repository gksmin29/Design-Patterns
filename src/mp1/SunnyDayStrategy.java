package mp1;

public class SunnyDayStrategy implements FlightStrategy {

    @Override
    public void fly(String destination) {
        System.out.println("직선 경로로 빠르게 " + destination +  "까지 이동");
    }

}
