import java.util.*;

// Bus use is a capability: only students implementing this pay the transport fee.
interface BusUser {
    // The transport fee is defined here and only here.
    double TRANSPORT_FEE = 12000;

    default double transportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    protected static final double NORMAL_TUITION = 40000;

    protected final String name;

    Student(String name) {
        this.name = name;
    }

    String getName() { return name; }

    abstract double tuition();

    double totalFee() {
        double fee = tuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).transportFee();
        }
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) { super(name); }

    double tuition() { return NORMAL_TUITION; }
}

class Hosteller extends Student {
    private static final double HOSTEL_FEE = 60000;

    Hosteller(String name) { super(name); }

    double tuition() { return NORMAL_TUITION + HOSTEL_FEE; }
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String name) { super(name); }

    double tuition() { return NORMAL_TUITION / 2; }
}

public class CollegeFeeCounter {
    static Student create(String type, String name) {
        switch (type.toUpperCase()) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER": return new Hosteller(name);
            case "SCHOLAR": return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            students.add(create(type, name));
        }

        double total = 0;
        for (Student s : students) {
            double fee = s.totalFee();
            System.out.printf("%s: %.2f%n", s.getName(), fee);
            total += fee;
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
