/**
 * Program Name  : VowelConsonantCounter
 * Class Name    : VowelConsonantCounter
 * Description   : Day 2 Live-Coding Session - Problem 1: Vowel & Consonant Counter.
 *                 Counts vowels and consonants using charAt() ignoring spaces.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        if (text == null) {
            System.out.println("Invalid Input: Text cannot be null.");
            return;
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') {
                continue;
            }

            char lowerCh = Character.toLowerCase(ch);

            if (lowerCh >= 'a' && lowerCh <= 'z') {
                if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d%n", vowelCount, consonantCount);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        VOWEL & CONSONANT COUNTER             ");
        System.out.println("===================================================\n");

        String testText1 = "Java Programming";
        System.out.println("Input: \"" + testText1 + "\"");
        countVowelsAndConsonants(testText1);

        System.out.println("-------------------------------------------------");

        System.out.println("Input: \"CodInClub BridgeLabz\"");
        countVowelsAndConsonants("CodInClub BridgeLabz");
    }
}