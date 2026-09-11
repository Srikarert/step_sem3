/**
 * Program Name  : DuplicateTeamNameFinder
 * Class Name    : DuplicateTeamNameFinder
 * Description   : Scans a list of registered hackathon team names and reports
 *                 the first duplicate found using plain nested loops — no
 *                 Collections, Sets, or Maps allowed.
 * Author        : Akula Srikar
 * Date          : 2026-09-11
 *
 * Concepts      : String arrays, nested loops, String.equals(),
 *                 early exit, pairwise comparison.
 */

import java.util.Scanner;

public class DuplicateTeamNameFinder {

    // ─── Core Method ────────────────────────────────────────────────────
    /**
     * Finds the first duplicate team name by comparing every name against
     * the names that come after it (avoids redundant A-vs-B then B-vs-A).
     *
     * @param teamNames array of registered team names
     * @return message indicating the first duplicate or that none exist
     */
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    // ─── Display Method ─────────────────────────────────────────────────
    /**
     * Prints the team list and the duplicate-check result.
     *
     * @param teamNames array of team names to check
     */
    static void displayDuplicateResult(String[] teamNames) {
        System.out.print("Teams Registered : [");
        for (int i = 0; i < teamNames.length; i++) {
            System.out.print("\"" + teamNames[i] + "\"");
            if (i < teamNames.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Result           : " + findDuplicateTeam(teamNames));
    }

    // ─── Input Method ───────────────────────────────────────────────────
    /**
     * Reads team names from user input.
     *
     * @param scanner the Scanner for user input
     */
    static void readAndProcessInput(Scanner scanner) {
        System.out.print("Enter number of teams: ");
        int teamCount = Integer.parseInt(scanner.nextLine().trim());

        String[] teamNames = new String[teamCount];
        for (int i = 0; i < teamCount; i++) {
            System.out.print("Enter team " + (i + 1) + " name: ");
            teamNames[i] = scanner.nextLine().trim();
        }

        System.out.println();
        displayDuplicateResult(teamNames);
    }

    // ─── Main ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   DUPLICATE TEAM NAME FINDER");
        System.out.println("==============================================");
        System.out.println();

        // --- Sample Run 1: Duplicate exists ---
        System.out.println("--- Sample Run 1 ---");
        String[] sampleWithDuplicate = {"ByteForce", "CodeCrafters", "ByteForce"};
        displayDuplicateResult(sampleWithDuplicate);
        System.out.println();

        // --- Sample Run 2: No duplicates ---
        System.out.println("--- Sample Run 2 ---");
        String[] sampleNoDuplicate = {"ByteForce", "CodeCrafters", "NullPointers"};
        displayDuplicateResult(sampleNoDuplicate);
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
