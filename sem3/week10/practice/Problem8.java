import java.util.Scanner;

public class Problem8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int marks = scanner.nextInt();
            char grade;

            if (marks >= 90) {
                grade = 'A';
            } else if (marks >= 75) {
                grade = 'B';
            } else if (marks >= 60) {
                grade = 'C';
            } else if (marks >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            System.out.println("Grade " + grade);
        }
    }
}
