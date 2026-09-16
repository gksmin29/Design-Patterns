package mp1;

public class Context {

    private FlightStrategy flightStrategy = new SunnyDayStrategy();

    public void setFlightStrategy(FlightStrategy flightStrategy) {
        this.flightStrategy = flightStrategy;
    }

    public void deliver(String destination) {
        flightStrategy.fly(destination);
    }

}
