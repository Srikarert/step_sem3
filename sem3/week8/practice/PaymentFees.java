import java.util.*;

abstract class Payment {
    protected final double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) { super(amount); }

    String getType() { return "CARD"; }

    double finalAmount() { return amount * 1.02; }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) { super(amount); }

    String getType() { return "WALLET"; }

    double finalAmount() { return amount * 1.01; }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) { super(amount); }

    String getType() { return "BANKTRANSFER"; }

    double finalAmount() { return amount; }
}

public class PaymentFees {
    static Payment create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD": return new CardPayment(amount);
            case "WALLET": return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            payments.add(create(type, amount));
        }

        double total = 0;
        for (Payment p : payments) {
            double fa = p.finalAmount();
            System.out.printf("%s: %.2f%n", p.getType(), fa);
            total += fa;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
