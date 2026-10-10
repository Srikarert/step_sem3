import java.util.*;

// abstract: a generic staff member with no pay rule can never be created.
abstract class StaffMember {
    protected final String name;

    StaffMember(String name) {
        this.name = name;
    }

    String getName() { return name; }

    abstract double pay();
}

class FullTimeStaff extends StaffMember {
    private final double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double pay() { return weeklySalary; }
}

class HourlyStaff extends StaffMember {
    private static final double REGULAR_HOURS = 40;
    private static final double OVERTIME_MULTIPLIER = 1.5;

    private final double hours;
    private final double rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        double regular = Math.min(hours, REGULAR_HOURS);
        double overtime = Math.max(0, hours - REGULAR_HOURS);
        return regular * rate + overtime * rate * OVERTIME_MULTIPLIER;
    }
}

class InternStaff extends StaffMember {
    private final double stipend;

    InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() { return stipend; }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<StaffMember> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            switch (type) {
                case "FULLTIME":
                    staff.add(new FullTimeStaff(name, sc.nextDouble()));
                    break;
                case "HOURLY": {
                    double hours = sc.nextDouble();
                    double rate = sc.nextDouble();
                    staff.add(new HourlyStaff(name, hours, rate));
                    break;
                }
                case "INTERN":
                    staff.add(new InternStaff(name, sc.nextDouble()));
                    break;
                default: throw new IllegalArgumentException("Unknown staff type: " + type);
            }
        }

        double total = 0;
        for (StaffMember s : staff) {
            double p = s.pay();
            System.out.printf("%s: %.2f%n", s.getName(), p);
            total += p;
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
