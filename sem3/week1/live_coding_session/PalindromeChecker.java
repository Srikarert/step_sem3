/**
 * Program Name  : PalindromeChecker
 * Class Name    : PalindromeChecker
 * Description   : Day 1 Live-Coding Session - Problem 2: Palindrome Checker (3 Approaches).
 *                 Verifies palindrome using iterative comparison, recursion, and array reversal.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.toLowerCase();
        int leftIndex = 0;
        int rightIndex = cleanText.length() - 1;

        while (leftIndex < rightIndex) {
            if (cleanText.charAt(leftIndex) != cleanText.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.toLowerCase();
        return checkRecursiveHelper(cleanText, 0, cleanText.length() - 1);
    }

    private static boolean checkRecursiveHelper(String text, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return true;
        }
        if (text.charAt(startIndex) != text.charAt(endIndex)) {
            return false;
        }
        return checkRecursiveHelper(text, startIndex + 1, endIndex - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) {
            return false;
        }
        String cleanText = text.toLowerCase();
        char[] originalChars = cleanText.toCharArray();
        int charCount = originalChars.length;
        char[] reversedChars = new char[charCount];

        for (int i = 0; i < charCount; i++) {
            reversedChars[i] = originalChars[charCount - 1 - i];
        }

        for (int i = 0; i < charCount; i++) {
            if (originalChars[i] != reversedChars[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyAndDisplay(String sampleInput) {
        boolean iterativeResult = isPalindromeIterative(sampleInput);
        boolean recursiveResult = isPalindromeRecursive(sampleInput);
        boolean arrayReversalResult = isPalindromeArrayReversal(sampleInput);

        String iterativeStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recursiveStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrayStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        System.out.printf("Input: \"%s\"%n", sampleInput);
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                iterativeStr, recursiveStr, arrayStr);

        boolean allAgree = (iterativeResult == recursiveResult) && (recursiveResult == arrayReversalResult);
        System.out.println("Consistency Status: " + (allAgree ? "All 3 approaches agree!" : "Mismatch detected!"));
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        QA TEXT VERIFICATION - PALINDROME CHECKER");
        System.out.println("===================================================\n");

        String[] testStrings = {"madam", "hello", "racecar", "step", "noon"};

        for (String testWord : testStrings) {
            verifyAndDisplay(testWord);
        }
    }
}