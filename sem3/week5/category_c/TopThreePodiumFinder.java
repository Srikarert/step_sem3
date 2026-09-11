/**
 * Program Name  : TopThreePodiumFinder
 * Class Name    : TopThreePodiumFinder
 * Description   : Finds the top 3 hackathon scores in a single pass without
 *                 sorting the array. Tracks three running variables (first,
 *                 second, third) and shifts them appropriately when a new
 *                 high score is encountered.
 * Author        : Akula Srikar
 * Date          : 2026-09-11
 *
 * Concepts      : Single-pass traversal, tracking multiple running maximums,
 *                 cascading variable updates, array return, Integer.MIN_VALUE.
 */

import java.util.Arrays;
import java.util.Scanner;

public class TopThreePodiumFinder {

    // ─── Core Method ────────────────────────────────────────────────────
    /**
     * Finds the top 3 scores in descending order using a single pass.
     * Does NOT sort the array — uses three running variables instead.
     *
     * @param scores array of hackathon scores (length >= 3)
     * @return int array of size 3 with scores in descending order
     */
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < scores.length; i++) {
            int currentScore = scores[i];

            if (currentScore >= first) {
                // New highest: shift first → second, second → third
                third = second;
                second = first;
                first = currentScore;
            } else if (currentScore >= second) {
                // New second-highest: shift second → third
                third = second;
                second = currentScore;
            } else if (currentScore >= third) {
                // New third-highest
                third = currentScore;
            }
        }

        int[] topThree = {first, second, third};
        return topThree;
    }

    // ─── Display Method ─────────────────────────────────────────────────
    /**
     * Prints all scores and the top-3 podium result.
     *
     * @param scores array of scores to analyze
     */
    static void displayPodium(int[] scores) {
        System.out.println("All Scores : " + Arrays.toString(scores));
        int[] podium = findTopThreeScores(scores);
        System.out.println("Podium     : " + Arrays.toString(podium));
        System.out.println("  🥇 1st Place : " + podium[0]);
        System.out.println("  🥈 2nd Place : " + podium[1]);
        System.out.println("  🥉 3rd Place : " + podium[2]);
    }

    // ─── Input Method ───────────────────────────────────────────────────
    /**
     * Reads scores from user input and displays the podium.
     *
     * @param scanner the Scanner for user input
     */
    static void readAndProcessInput(Scanner scanner) {
        System.out.print("Enter number of teams: ");
        int teamCount = scanner.nextInt();

        if (teamCount < 3) {
            System.out.println("Error: Need at least 3 teams for a podium.");
            return;
        }

        int[] scores = new int[teamCount];
        System.out.print("Enter " + teamCount + " scores (space-separated): ");
        for (int i = 0; i < teamCount; i++) {
            scores[i] = scanner.nextInt();
        }

        System.out.println();
        displayPodium(scores);
    }

    // ─── Main ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TOP-3 PODIUM FINDER");
        System.out.println("==============================================");
        System.out.println();

        // --- Sample Run 1: With ties ---
        System.out.println("--- Sample Run 1 (with ties) ---");
        int[] sampleScores1 = {45, 82, 79, 90, 33, 90, 61};
        displayPodium(sampleScores1);
        System.out.println();

        // --- Sample Run 2: Distinct scores ---
        System.out.println("--- Sample Run 2 (distinct) ---");
        int[] sampleScores2 = {55, 72, 91, 43, 88, 67};
        displayPodium(sampleScores2);
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
