import java.util.Scanner;

public class Problem10 {
    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            return (marks[0] + marks[1] + marks[2]) / 3.0;
        }

        char grade() {
            double average = average();
            if (average >= 90) {
                return 'A';
            } else if (average >= 75) {
                return 'B';
            } else if (average >= 60) {
                return 'C';
            } else if (average >= 40) {
                return 'D';
            }
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String name = scanner.next();
            int[] marks = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
            Student student = new Student(name, marks);
            System.out.printf("%s: Average %.1f, Grade %c%n",
                    student.name.toUpperCase(), student.average(), student.grade());
        }
    }
}
