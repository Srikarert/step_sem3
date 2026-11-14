import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = scanner.nextLong();
        long remaining = number;
        long sum = 0;
        long reversed = 0;

        while (remaining > 0) {
            long digit = remaining % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            remaining /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }
}
