import java.util.*;

// Saver mode is a capability only some appliances have.
interface SaverMode {
    double SAVER_REDUCTION = 0.25;

    default double applySaver(double units) {
        return units * (1 - SAVER_REDUCTION);
    }
}

abstract class Appliance {
    private static final double COST_PER_UNIT = 8;

    abstract String getName();

    protected abstract double powerWatts();

    double units(double hours) {
        return powerWatts() * hours / 1000;
    }

    double cost(double units) {
        return units * COST_PER_UNIT;
    }

    boolean supportsSaver() {
        return this instanceof SaverMode;
    }

    // Caller must check supportsSaver() first.
    double saverUnits(double hours) {
        return ((SaverMode) this).applySaver(units(hours));
    }
}

class Fridge extends Appliance {
    String getName() { return "FRIDGE"; }

    protected double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    String getName() { return "AC"; }

    protected double powerWatts() { return 1500; }
}

class Tv extends Appliance {
    String getName() { return "TV"; }

    protected double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    String getName() { return "WASHER"; }

    protected double powerWatts() { return 500; }
}

public class ApplianceEnergyReport {
    static Appliance create(String name) {
        switch (name.toUpperCase()) {
            case "FRIDGE": return new Fridge();
            case "AC": return new AirConditioner();
            case "TV": return new Tv();
            case "WASHER": return new WashingMachine();
            default: throw new IllegalArgumentException("Unknown appliance: " + name);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            Appliance a = create(parts[0]);
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            if (saver && !a.supportsSaver()) {
                System.out.println(a.getName() + ": saver mode not supported");
                continue;
            }
            double units = saver ? a.saverUnits(hours) : a.units(hours);
            double cost = a.cost(units);
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", a.getName(), units, cost);
            total += cost;
        }
        System.out.printf("Total Cost: %.2f%n", total);
    }
}
