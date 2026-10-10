import java.util.*;

abstract class Journey {
    protected final double distance;

    Journey(double distance) {
        this.distance = distance;
    }

    abstract String getType();

    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double distance) { super(distance); }

    String getType() { return "BUS"; }

    double fare() { return Math.min(10.0, 2.0 + 0.10 * distance); }
}

class TrainJourney extends Journey {
    TrainJourney(double distance) { super(distance); }

    String getType() { return "TRAIN"; }

    double fare() { return 3.0 + 0.15 * distance; }
}

class MetroJourney extends Journey {
    private final double peakHourFactor;

    MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    String getType() { return "METRO"; }

    double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            switch (type) {
                case "BUS": journeys.add(new BusJourney(distance)); break;
                case "TRAIN": journeys.add(new TrainJourney(distance)); break;
                case "METRO": journeys.add(new MetroJourney(distance, sc.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }

        double total = 0;
        for (Journey j : journeys) {
            double f = j.fare();
            System.out.printf("%s: %.2f%n", j.getType(), f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
