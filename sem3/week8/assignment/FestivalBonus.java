import java.util.*;

abstract class Employee {
    protected final String name;
    protected final double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() { return name; }

    abstract double bonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }

    double bonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }

    double bonus() { return salary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }

    double bonus() { return 2000.0; }
}

public class FestivalBonus {
    static Employee create(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN": return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> staff = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            staff.add(create(type, name, salary));
        }

        double total = 0;
        for (Employee e : staff) {
            double b = e.bonus();
            System.out.printf("%s: %.2f%n", e.getName(), b);
            total += b;
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
