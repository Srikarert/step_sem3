import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int left = 0, right = count - 1; left < right; left++, right--) {
            int temporary = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temporary;
        }

        System.out.print("[");
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(numbers[i]);
        }
        System.out.println("]");
    }
}
