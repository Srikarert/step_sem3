import java.util.*;

// Night service is an ability only some cabs have.
interface NightService {
    double NIGHT_SURCHARGE = 0.20;

    default double nightFare(double dayFare) {
        return dayFare * (1 + NIGHT_SURCHARGE);
    }
}

abstract class Cab {
    // The minimum fare applies to every cab and is written only here.
    private static final double MINIMUM_FARE = 100;

    abstract String getType();

    protected abstract double ratePerKm();

    final double fare(double km) {
        return Math.max(MINIMUM_FARE, km * ratePerKm());
    }

    boolean offersNightService() {
        return this instanceof NightService;
    }

    // Caller must check offersNightService() first.
    double nightTripFare(double km) {
        return ((NightService) this).nightFare(fare(km));
    }
}

class MiniCab extends Cab {
    String getType() { return "MINI"; }

    protected double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    String getType() { return "SEDAN"; }

    protected double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    String getType() { return "SUV"; }

    protected double ratePerKm() { return 18; }
}

public class CityCabFareMeter {
    static Cab create(String type) {
        switch (type.toUpperCase()) {
            case "MINI": return new MiniCab();
            case "SEDAN": return new SedanCab();
            case "SUV": return new SuvCab();
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Cab cab = create(sc.next());
            double km = sc.nextDouble();
            boolean night = sc.next().equalsIgnoreCase("NIGHT");

            if (night && !cab.offersNightService()) {
                System.out.println(cab.getType() + ": night service not available");
                continue;
            }
            double fare = night ? cab.nightTripFare(km) : cab.fare(km);
            System.out.printf("%s: %.2f%n", cab.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
