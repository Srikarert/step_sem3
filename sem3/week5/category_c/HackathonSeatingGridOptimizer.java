/**
 * Program Name  : HackathonSeatingGridOptimizer
 * Class Name    : HackathonSeatingGridOptimizer
 * Description   : Classifies venue seating rows as "Quiet Zone" or "Buzzing Zone"
 *                 based on whether the row's average score meets a given threshold.
 *                 Uses a reusable helper method rowAverage() to avoid repeating
 *                 the averaging logic. Supports jagged arrays (rows of varying length).
 * Author        : Akula Srikar
 * Date          : 2026-09-11
 *
 * Concepts      : 2D arrays (jagged), helper methods, method decomposition,
 *                 double arithmetic, String concatenation, for loops.
 */

import java.util.Scanner;

public class HackathonSeatingGridOptimizer {

    // ─── Helper Method ──────────────────────────────────────────────────
    /**
     * Computes the average of a single row's scores.
     * Handles rows of any length (jagged array support).
     *
     * @param row a single row of integer scores
     * @return the average score as a double
     */
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int i = 0; i < row.length; i++) {
            sum = sum + row[i];
        }
        return (double) sum / row.length;
    }

    // ─── Core Method ────────────────────────────────────────────────────
    /**
     * Classifies each row as "Quiet Zone" (below threshold) or
     * "Buzzing Zone" (at or above threshold) using the rowAverage() helper.
     *
     * @param seatingScores 2D array where each row contains team scores
     * @param threshold     the minimum average to be classified as "Buzzing"
     * @return formatted string showing each row's classification
     */
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int rowIndex = 0; rowIndex < seatingScores.length; rowIndex++) {
            double average = rowAverage(seatingScores[rowIndex]);
            String zone;

            if (average >= threshold) {
                zone = "Buzzing Zone";
            } else {
                zone = "Quiet Zone";
            }

            if (rowIndex > 0) {
                result.append(" | ");
            }
            result.append("Row " + rowIndex + ": " + zone);
        }

        return result.toString();
    }

    // ─── Display Method ─────────────────────────────────────────────────
    /**
     * Prints the seating grid, row averages, and zone classifications.
     *
     * @param seatingScores 2D array of scores
     * @param threshold     the zone classification threshold
     */
    static void displayGridAnalysis(int[][] seatingScores, int threshold) {
        System.out.println("Threshold: " + threshold);
        System.out.println();

        for (int rowIndex = 0; rowIndex < seatingScores.length; rowIndex++) {
            System.out.print("  Row " + rowIndex + ": [");
            for (int colIndex = 0; colIndex < seatingScores[rowIndex].length; colIndex++) {
                System.out.print(seatingScores[rowIndex][colIndex]);
                if (colIndex < seatingScores[rowIndex].length - 1) {
                    System.out.print(", ");
                }
            }
            double average = rowAverage(seatingScores[rowIndex]);
            System.out.printf("] → avg = %.1f%n", average);
        }

        System.out.println();
        System.out.println("Result: " + classifyRows(seatingScores, threshold));
    }

    // ─── Input Method ───────────────────────────────────────────────────
    /**
     * Reads a seating grid from user input and classifies it.
     *
     * @param scanner the Scanner for user input
     */
    static void readAndProcessInput(Scanner scanner) {
        System.out.print("Enter number of rows: ");
        int rowCount = scanner.nextInt();

        int[][] seatingScores = new int[rowCount][];
        for (int i = 0; i < rowCount; i++) {
            System.out.print("Enter number of seats in row " + i + ": ");
            int seatCount = scanner.nextInt();
            seatingScores[i] = new int[seatCount];

            System.out.print("Enter " + seatCount + " scores for row " + i + ": ");
            for (int j = 0; j < seatCount; j++) {
                seatingScores[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter threshold: ");
        int threshold = scanner.nextInt();

        System.out.println();
        displayGridAnalysis(seatingScores, threshold);
    }

    // ─── Main ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   HACKATHON SEATING GRID OPTIMIZER");
        System.out.println("==============================================");
        System.out.println();

        // --- Sample Run ---
        System.out.println("--- Sample Run ---");
        int[][] sampleGrid = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        displayGridAnalysis(sampleGrid, 60);
        System.out.println();

        // --- Sample Run 2: Jagged grid ---
        System.out.println("--- Sample Run 2 (Jagged Grid) ---");
        int[][] jaggedGrid = {
            {70, 80},
            {55, 60, 65, 50},
            {90}
        };
        displayGridAnalysis(jaggedGrid, 65);
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
