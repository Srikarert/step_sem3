import java.util.*;

abstract class Delivery {
    protected final double weight;
    protected final double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract String getType();

    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) { super(weight, distance); }

    String getType() { return "STANDARD"; }

    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) { super(weight, distance); }

    String getType() { return "EXPRESS"; }

    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

// The extra CustomsFee is stored inside the object, so callers still just call fee().
class InternationalDelivery extends Delivery {
    private final double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    String getType() { return "INTERNATIONAL"; }

    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            switch (type) {
                case "STANDARD": deliveries.add(new StandardDelivery(weight, distance)); break;
                case "EXPRESS": deliveries.add(new ExpressDelivery(weight, distance)); break;
                case "INTERNATIONAL":
                    deliveries.add(new InternationalDelivery(weight, distance, sc.nextDouble()));
                    break;
                default: throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double f = d.fee();
            System.out.printf("%s: %.2f%n", d.getType(), f);
            total += f;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
