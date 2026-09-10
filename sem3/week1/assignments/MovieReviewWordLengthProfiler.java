/**
 * Program Name  : MovieReviewWordLengthProfiler
 * Class Name    : MovieReviewWordLengthProfiler
 * Description   : Week 1 Assignment - Problem 5: The Movie Review Word Length Profiler.
 *                 Splits movie review into words and profiles length categories.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class MovieReviewWordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");

        int shortCount = 0;   // 1-4 letters
        int mediumCount = 0;  // 5-8 letters
        int longCount = 0;    // 9+ letters

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z0-9]", "");
            int wordLength = cleanWord.length();

            if (wordLength >= 1 && wordLength <= 4) {
                shortCount++;
            } else if (wordLength >= 5 && wordLength <= 8) {
                mediumCount++;
            } else if (wordLength >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   MOVIE REVIEW WORD LENGTH PROFILER        ");
        System.out.println("==================================================\n");

        String sampleReview = "This movie was absolutely fantastic and thrilling";
        System.out.println("Review: \"" + sampleReview + "\"");
        classifyWordLengths(sampleReview);

        System.out.println("-------------------------------------------------");

        String review2 = "A stunning masterpiece with breathtaking visuals and perfect direction";
        System.out.println("Review 2: \"" + review2 + "\"");
        classifyWordLengths(review2);
    }
}