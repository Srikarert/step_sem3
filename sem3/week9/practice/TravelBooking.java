import java.util.*;

abstract class Booking {
    // The booking fee is defined here and only here.
    private static final double BOOKING_FEE = 50;

    protected final double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract String getMode();

    // Mode-specific part, supplied by each subclass.
    protected abstract double baseFare();

    // Shared part: every booking adds the same fee. Final so no mode can skip it.
    final double totalFare() {
        return baseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) { super(distanceKm); }

    String getMode() { return "BUS"; }

    protected double baseFare() { return 2.0 * distanceKm; }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) { super(distanceKm); }

    String getMode() { return "TRAIN"; }

    protected double baseFare() { return 1.5 * distanceKm; }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) { super(distanceKm); }

    String getMode() { return "FLIGHT"; }

    protected double baseFare() { return 2500 + 4.0 * distanceKm; }
}

public class TravelBooking {
    static Booking create(String mode, double km) {
        switch (mode.toUpperCase()) {
            case "BUS": return new BusBooking(km);
            case "TRAIN": return new TrainBooking(km);
            case "FLIGHT": return new FlightBooking(km);
            default: throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double km = sc.nextDouble();
            bookings.add(create(mode, km));
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.totalFare());
        }
    }
}
