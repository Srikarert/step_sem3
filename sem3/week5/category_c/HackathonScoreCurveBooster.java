/**
 * Program Name  : HackathonScoreCurveBooster
 * Class Name    : HackathonScoreCurveBooster
 * Description   : The judging panel at a campus hackathon boosts every team's
 *                 score by a flat bonus directly inside the original array.
 *                 Demonstrates that arrays are passed by reference in Java —
 *                 no new array or return value is needed.
 * Author        : Akula Srikar
 * Date          : 2026-09-11
 *
 * Concepts      : Arrays (pass-by-reference), in-place modification,
 *                 Arrays.toString(), void methods, for loops.
 */

import java.util.Arrays;
import java.util.Scanner;

public class HackathonScoreCurveBooster {

    // ─── Core Method ────────────────────────────────────────────────────
    /**
     * Adds a flat bonus to every score in-place.
     * The caller's original array is modified directly — nothing is returned.
     *
     * @param scores the array of hackathon scores to boost
     * @param bonus  the non-negative bonus to add to each score
     */
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] + bonus;
        }
    }

    // ─── Display Method ─────────────────────────────────────────────────
    /**
     * Prints the leaderboard before and after curving.
     *
     * @param scores the array of scores
     * @param bonus  the bonus applied
     */
    static void displayCurvedLeaderboard(int[] scores, int bonus) {
        System.out.println("Original Scores : " + Arrays.toString(scores));
        curveScores(scores, bonus);
        System.out.println("Bonus Applied   : +" + bonus);
        System.out.println("Curved Scores   : " + Arrays.toString(scores));
    }

    // ─── Input Method ───────────────────────────────────────────────────
    /**
     * Reads scores and bonus from the user via Scanner.
     *
     * @param scanner the Scanner for user input
     */
    static void readAndProcessInput(Scanner scanner) {
        System.out.print("Enter number of teams: ");
        int teamCount = scanner.nextInt();

        int[] scores = new int[teamCount];
        System.out.print("Enter " + teamCount + " scores (space-separated): ");
        for (int i = 0; i < teamCount; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.print("Enter bonus to add: ");
        int bonus = scanner.nextInt();

        System.out.println();
        displayCurvedLeaderboard(scores, bonus);
    }

    // ─── Main ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   HACKATHON SCORE CURVE BOOSTER");
        System.out.println("==============================================");
        System.out.println();

        // --- Demo with sample data ---
        System.out.println("--- Sample Run ---");
        int[] sampleScores = {70, 85, 60};
        displayCurvedLeaderboard(sampleScores, 10);
        System.out.println();

        // --- Interactive input ---
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("--- Your Turn ---");
            readAndProcessInput(scanner);
        } catch (Exception exception) {
            System.out.println("Error: Invalid input. " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
