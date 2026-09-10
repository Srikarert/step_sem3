/**
 * Program Name  : FirstNonRepeatingChar
 * Class Name    : FirstNonRepeatingChar
 * Description   : Day 1 Live-Coding Session - Problem 4: First Non-Repeating Character.
 *                 Computes frequency of characters and identifies the first unique character.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String text) {
        if (text == null || text.isEmpty()) {
            return '\0';
        }

        int[] frequencyMap = new int[256];
        int textLength = text.length();

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            if (currentChar < 256) {
                frequencyMap[currentChar]++;
            }
        }

        for (int i = 0; i < textLength; i++) {
            char currentChar = text.charAt(i);
            if (currentChar < 256 && frequencyMap[currentChar] == 1) {
                return currentChar;
            }
        }

        return '\0';
    }

    public static void testAndDisplay(String sampleText) {
        System.out.printf("Input: \"%s\"%n", sampleText);
        char nonRepeating = findFirstNonRepeatingChar(sampleText);
        if (nonRepeating != '\0') {
            System.out.printf("First Non-Repeating Character: '%c'%n", nonRepeating);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("         UNIQUE LETTER HUNT MINI-GAME             ");
        System.out.println("===================================================\n");

        String[] testCases = {"swiss", "aabbcc", "stepsem3", "programming", "noon"};

        for (String sample : testCases) {
            testAndDisplay(sample);
        }
    }
}