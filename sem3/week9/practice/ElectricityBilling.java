import java.util.*;

abstract class Connection {
    protected final int units;

    Connection(int units) {
        this.units = units;
    }

    abstract String getType();

    abstract double bill();
}

class HomeConnection extends Connection {
    HomeConnection(int units) { super(units); }

    String getType() { return "HOME"; }

    double bill() {
        int first = Math.min(units, 100);
        int rest = Math.max(0, units - 100);
        return first * 5.0 + rest * 7.0;
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) { super(units); }

    String getType() { return "SHOP"; }

    double bill() { return units * 8.0 + 100; }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) { super(units); }

    String getType() { return "FACTORY"; }

    double bill() { return Math.max(1000.0, units * 6.0); }
}

public class ElectricityBilling {
    static Connection create(String type, int units) {
        switch (type.toUpperCase()) {
            case "HOME": return new HomeConnection(units);
            case "SHOP": return new ShopConnection(units);
            case "FACTORY": return new FactoryConnection(units);
            default: throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            connections.add(create(type, units));
        }

        double total = 0;
        for (Connection c : connections) {
            double b = c.bill();
            System.out.printf("%s: %.2f%n", c.getType(), b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
