/**
 * Program Name  : FilteredWordFrequencyReport
 * Class Name    : FilteredWordFrequencyReport
 * Description   : Week 2 Assignment - Problem 5: Stop-Word-Filtered Word Frequency Report.
 *                 Filters stop words, counts unique word frequencies,
 *                 and prints results sorted by count descending.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class FilteredWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    public static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback provided.");
            return;
        }

        String cleaned = feedback.toLowerCase();
        cleaned = cleaned.replace(".", "");
        cleaned = cleaned.replace(",", "");
        cleaned = cleaned.replace("!", "");
        cleaned = cleaned.replace("?", "");
        cleaned = cleaned.replace(";", "");
        cleaned = cleaned.replace(":", "");

        String[] words = cleaned.trim().split("\\s+");

        java.util.Map<String, Integer> frequencyMap = new java.util.HashMap<>();

        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        java.util.List<java.util.Map.Entry<String, Integer>> entryList =
            new java.util.ArrayList<>(frequencyMap.entrySet());

        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (java.util.Map.Entry<String, Integer> entry : entryList) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" STOP-WORD-FILTERED WORD FREQUENCY REPORT      ");
        System.out.println("==================================================\n");

        String feedback1 = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + feedback1 + "\"\n");
        System.out.println("Filtered Word Frequency Report:");
        printFilteredWordFrequency(feedback1);

        System.out.println("\n-------------------------------------------------\n");

        String feedback2 = "Java is great, programming in Java is also great and exciting.";
        System.out.println("Input: \"" + feedback2 + "\"\n");
        System.out.println("Filtered Word Frequency Report:");
        printFilteredWordFrequency(feedback2);
    }
}