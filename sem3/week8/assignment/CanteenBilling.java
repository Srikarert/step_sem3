import java.util.*;

abstract class Customer {
    protected final double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class Student extends Customer {
    Student(double amount) { super(amount); }

    String getType() { return "STUDENT"; }

    double finalAmount() { return amount * 0.90; }
}

class Staff extends Customer {
    Staff(double amount) { super(amount); }

    String getType() { return "STAFF"; }

    double finalAmount() { return amount * 0.95; }
}

class Guest extends Customer {
    Guest(double amount) { super(amount); }

    String getType() { return "GUEST"; }

    double finalAmount() { return amount + 10; }
}

public class CanteenBilling {
    static Customer create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "STUDENT": return new Student(amount);
            case "STAFF": return new Staff(amount);
            case "GUEST": return new Guest(amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            bills.add(create(type, amount));
        }

        double total = 0;
        for (Customer c : bills) {
            double fa = c.finalAmount();
            System.out.printf("%s: %.2f%n", c.getType(), fa);
            total += fa;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
