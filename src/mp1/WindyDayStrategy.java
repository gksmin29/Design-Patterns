package mp1;

public class WindyDayStrategy implements FlightStrategy {

    @Override
    public void fly(String destination) {
        System.out.println("저고도에서 안정적으로 " + destination + "까지 이동");
    }

}
