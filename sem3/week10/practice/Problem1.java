import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int vowels = 0;
        int consonants = 0;

        for (char character : word.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(character) >= 0) {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
