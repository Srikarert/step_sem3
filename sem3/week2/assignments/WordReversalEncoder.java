/**
 * Program Name  : WardReversalEncoder
 * Class Name    : WardReversalEncoder
 * Description   : Week 2 Assignment - Problem 2: Word Reversal Encoder.
 *                 Reverses every word in a sentence individually using StringBuilder.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            return null;
        }

        String[] words = sentence.split(" ");
        StringBuilder encodedResult = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            StringBuilder reversedWord = new StringBuilder();

            for (int j = currentWord.length() - 1; j >= 0; j--) {
                reversedWord.append(currentWord.charAt(j));
            }

            encodedResult.append(reversedWord);

            if (i < words.length - 1) {
                encodedResult.append(" ");
            }
        }

        return encodedResult.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("         WORD REVERSAL ENCODER                 ");
        System.out.println("==================================================\n");

        String[] testSentences = {
            "hello club",
            "java programming is fun",
            "SRM STEP Semester 3",
            "word"
        };

        for (String sentence : testSentences) {
            String result = reverseEachWord(sentence);
            System.out.printf("Input: \"%s\" => Output: \"%s\"\n", sentence, result);
        }
    }
}