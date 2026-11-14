import java.util.Scanner;

public class Problem9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            boolean isLeapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
            System.out.println(isLeapYear ? "Leap year" : "Not a leap year");
        }
    }
}
