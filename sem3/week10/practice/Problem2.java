import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String word = scanner.next();
            String reversed = new StringBuilder(word).reverse().toString();
            String result = word.equalsIgnoreCase(reversed) ? "palindrome" : "not a palindrome";
            System.out.println(reversed + " - " + result);
        }
    }
}
