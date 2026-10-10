import java.util.*;

// abstract: a plain "ticket" with no seat type can never be sold.
abstract class Ticket {
    // The convenience fee is defined here and only here.
    private static final double CONVENIENCE_FEE = 20;

    protected final int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract String getSeat();

    // Seat-specific part, supplied by each subclass.
    protected abstract double pricePerTicket();

    // Shared part: every ticket carries the same fee. Final so no seat can skip it.
    final double amount() {
        return count * (pricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) { super(count); }

    String getSeat() { return "REGULAR"; }

    protected double pricePerTicket() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) { super(count); }

    String getSeat() { return "PREMIUM"; }

    protected double pricePerTicket() { return 250; }
}

class RecliningTicket extends Ticket {
    RecliningTicket(int count) { super(count); }

    String getSeat() { return "RECLINER"; }

    protected double pricePerTicket() { return 400; }
}

public class MovieTicketCounter {
    static Ticket create(String seat, int count) {
        switch (seat.toUpperCase()) {
            case "REGULAR": return new RegularTicket(count);
            case "PREMIUM": return new PremiumTicket(count);
            case "RECLINER": return new RecliningTicket(count);
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            bookings.add(create(seat, count));
        }

        double total = 0;
        for (Ticket t : bookings) {
            double a = t.amount();
            System.out.printf("%s: %.2f%n", t.getSeat(), a);
            total += a;
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
