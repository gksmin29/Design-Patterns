package mp1;

public class RainyDayStrategy implements FlightStrategy {

    @Override
    public void fly(String destination) {
        System.out.println("건물 사이로 우회하며 " + destination + "까지 이동");
    }

}
