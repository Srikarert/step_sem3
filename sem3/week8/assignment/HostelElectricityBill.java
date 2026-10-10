import java.util.*;

abstract class Room {
    protected final int units;

    Room(int units) {
        this.units = units;
    }

    abstract String getType();

    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(int units) { super(units); }

    String getType() { return "SINGLE"; }

    double bill() { return 8.0 * units; }
}

// The extra value (occupants) lives inside the shared room itself,
// so the main flow can treat every room through the same bill() call.
class SharedRoom extends Room {
    private final int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    String getType() { return "SHARED"; }

    double bill() { return 6.0 * units / occupants; }
}

class ACRoom extends Room {
    ACRoom(int units) { super(units); }

    String getType() { return "AC"; }

    double bill() { return 10.0 * units + 200; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();
            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, sc.nextInt())); break;
                case "AC": rooms.add(new ACRoom(units)); break;
                default: throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            System.out.printf("%s: %.2f%n", r.getType(), b);
            total += b;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
