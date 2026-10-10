import java.util.*;

abstract class Vehicle {
    protected final int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract String getType();

    abstract double charge();
}

class Bike extends Vehicle {
    Bike(int hours) { super(hours); }

    String getType() { return "BIKE"; }

    double charge() { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car(int hours) { super(hours); }

    String getType() { return "CAR"; }

    double charge() { return 30.0 + 20.0 * (hours - 1); }
}

class Truck extends Vehicle {
    Truck(int hours) { super(hours); }

    String getType() { return "TRUCK"; }

    double charge() { return Math.max(100.0, 50.0 * hours); }
}

public class ParkingCharge {
    static Vehicle create(String type, int hours) {
        switch (type.toUpperCase()) {
            case "BIKE": return new Bike(hours);
            case "CAR": return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            vehicles.add(create(type, hours));
        }

        double total = 0;
        for (Vehicle v : vehicles) {
            double c = v.charge();
            System.out.printf("%s: %.2f%n", v.getType(), c);
            total += c;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
