package mp1;

import java.util.Random;

public class Main {



    public static void main(String[] args) {

        Context context = new Context();
        RainyDayStrategy rainyDayStrategy = new RainyDayStrategy();
        WindyDayStrategy windyDayStrategy = new WindyDayStrategy();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randInt = random.nextInt(30000);
            if (randInt < 10000) {
                context.deliver("상명대학교");
            }
            else if (randInt > 19999) {
                context.setFlightStrategy(rainyDayStrategy);
                context.deliver("상명대학교");
            }
            else {
                context.setFlightStrategy(windyDayStrategy);
                context.deliver("상명대학교");
            }
        }
    }





}
