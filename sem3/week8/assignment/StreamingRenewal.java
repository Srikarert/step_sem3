import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected final String subscriber;
    protected final LocalDate startDate;

    Plan(String subscriber, LocalDate startDate) {
        this.subscriber = subscriber;
        this.startDate = startDate;
    }

    String getSubscriber() { return subscriber; }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate start) { super(name, start); }

    int validityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate start) { super(name, start); }

    int validityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate start) { super(name, start); }

    int validityDays() { return 365; }
}

public class StreamingRenewal {
    static Plan create(String type, String name, LocalDate start) {
        switch (type.toUpperCase()) {
            case "BASIC": return new BasicPlan(name, start);
            case "STANDARD": return new StandardPlan(name, start);
            case "PREMIUM": return new PremiumPlan(name, start);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate start = LocalDate.parse(sc.next());
            plans.add(create(type, name, start));
        }

        for (Plan p : plans) {
            System.out.println(p.getSubscriber() + ": " + p.renewalDate());
        }
    }
}
