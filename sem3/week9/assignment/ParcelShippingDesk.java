import java.util.*;

// Insurance is a separate ability: only parcel types that implement this can be insured.
interface Insurable {
    double INSURANCE_RATE = 0.02;

    double getDeclaredValue();

    default double insurance() {
        return INSURANCE_RATE * getDeclaredValue();
    }
}

abstract class Parcel {
    protected final double weightKg;
    protected final double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public double getDeclaredValue() { return declaredValue; }

    abstract String getType();

    abstract double charge();

    // Shared by standard parcels and by the base of fragile parcels.
    protected double standardCharge() {
        return 40 + 10 * weightKg;
    }

    double insuranceAmount() {
        return (this instanceof Insurable) ? ((Insurable) this).insurance() : 0;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    String getType() { return "STANDARD"; }

    double charge() { return standardCharge(); }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    String getType() { return "EXPRESS"; }

    double charge() { return 80 + 15 * weightKg; }
}

class FragileParcel extends Parcel implements Insurable {
    private static final double HANDLING_FEE = 50;

    FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }

    String getType() { return "FRAGILE"; }

    double charge() { return standardCharge() + HANDLING_FEE; }
}

public class ParcelShippingDesk {
    static Parcel create(String type, double weight, double value) {
        switch (type.toUpperCase()) {
            case "STANDARD": return new StandardParcel(weight, value);
            case "EXPRESS": return new ExpressParcel(weight, value);
            case "FRAGILE": return new FragileParcel(weight, value);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            parcels.add(create(type, weight, value));
        }

        double grand = 0;
        for (Parcel p : parcels) {
            double c = p.charge();
            double ins = p.insuranceAmount();
            double t = c + ins;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", p.getType(), c, ins, t);
            grand += t;
        }
        System.out.printf("Grand Total: %.2f%n", grand);
    }
}
