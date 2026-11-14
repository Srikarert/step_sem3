import java.math.BigInteger;
import java.util.Scanner;

public class Problem7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        BigInteger factorial = BigInteger.ONE;

        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);
    }
}
