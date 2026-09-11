/**
 * Program Name  : PlacementDriveShortlistingEngine
 * Class Name    : PlacementDriveShortlistingEngine
 * Description   : Shortlists and ranks candidates for a placement coding round.
 *                 Uses method overloading for eligibility checks (CGPA-only vs
 *                 CGPA+coding-score), Comparable interface for natural ordering
 *                 by composite score, and Arrays.sort() for ranking.
 * Author        : Akula Srikar
 * Date          : 2026-09-11
 *
 * Concepts      : Method overloading, Comparable<T> interface, Arrays.sort(),
 *                 constructors, encapsulation, composite scoring, static methods.
 */

import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveShortlistingEngine {

    // ════════════════════════════════════════════════════════════════════
    //  INNER CLASS: Candidate
    // ════════════════════════════════════════════════════════════════════
    /**
     * Represents a placement candidate with CGPA, coding score,
     * and a composite score used for ranking.
     * Implements Comparable to enable natural sorting via Arrays.sort().
     */
    static class Candidate implements Comparable<Candidate> {

        // ─── Fields ─────────────────────────────────────────────────
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;

        // ─── Constructor ────────────────────────────────────────────
        /**
         * Creates a Candidate and computes the composite score.
         * Composite = (CGPA × 10) + (codingScore × 0.5)
         *
         * @param name        the candidate's name
         * @param cgpa        CGPA on a 0–10 scale
         * @param codingScore coding test score on a 0–100 scale
         */
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
        }

        // ─── Getters ───────────────────────────────────────────────
        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        public int getCodingScore() {
            return codingScore;
        }

        public double getCompositeScore() {
            return compositeScore;
        }

        // ─── Comparable: Descending by composite score ─────────────
        /**
         * Compares candidates by composite score in DESCENDING order.
         * Higher composite score comes first.
         *
         * @param other the other candidate to compare against
         * @return negative if this candidate ranks higher, positive if lower
         */
        @Override
        public int compareTo(Candidate other) {
            // Descending: higher composite score comes first
            if (this.compositeScore > other.compositeScore) {
                return -1;
            } else if (this.compositeScore < other.compositeScore) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return name + " (CGPA: " + cgpa + ", Code: " + codingScore
                   + ", Composite: " + compositeScore + ")";
        }
    }

    // ════════════════════════════════════════════════════════════════════
    //  ELIGIBILITY CHECKS (Method Overloading)
    // ════════════════════════════════════════════════════════════════════

    /** CGPA-only threshold for direct eligibility */
    private static final double CGPA_DIRECT_THRESHOLD = 7.0;

    /** Borderline CGPA threshold (below direct, but may qualify with coding) */
    private static final double CGPA_BORDERLINE_THRESHOLD = 6.5;

    /** Minimum coding score required for borderline CGPA candidates */
    private static final int CODING_SCORE_THRESHOLD = 60;

    // ─── Overload 1: CGPA-only quick filter ─────────────────────────
    /**
     * Checks if a candidate is eligible based on CGPA alone.
     * CGPA >= 7.0 qualifies directly.
     *
     * @param cgpa the candidate's CGPA
     * @return true if CGPA alone meets the threshold
     */
    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_DIRECT_THRESHOLD;
    }

    // ─── Overload 2: Combined CGPA + coding score filter ────────────
    /**
     * Checks if a borderline candidate (CGPA between 6.5 and 7.0)
     * is eligible via a strong coding score (>= 60).
     *
     * @param cgpa        the candidate's CGPA
     * @param codingScore the candidate's coding test score
     * @return true if CGPA is borderline but coding score compensates
     */
    static boolean isEligible(double cgpa, int codingScore) {
        if (isEligible(cgpa)) {
            return true;  // Already qualifies on CGPA alone
        }
        return cgpa >= CGPA_BORDERLINE_THRESHOLD && codingScore >= CODING_SCORE_THRESHOLD;
    }

    // ════════════════════════════════════════════════════════════════════
    //  SHORTLIST & RANK ENGINE
    // ════════════════════════════════════════════════════════════════════
    /**
     * Shortlists eligible candidates and ranks them by composite score
     * using Arrays.sort() (leveraging Candidate's compareTo method).
     *
     * @param candidates array of all candidates
     * @return formatted ranking string of shortlisted candidates
     */
    static String shortlistAndRank(Candidate[] candidates) {
        // Step 1: Count eligible candidates
        int eligibleCount = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].getCgpa(), candidates[i].getCodingScore())) {
                eligibleCount++;
            }
        }

        // Step 2: Build shortlisted array
        Candidate[] shortlisted = new Candidate[eligibleCount];
        int index = 0;
        for (int i = 0; i < candidates.length; i++) {
            if (isEligible(candidates[i].getCgpa(), candidates[i].getCodingScore())) {
                shortlisted[index] = candidates[i];
                index++;
            }
        }

        // Step 3: Rank using Arrays.sort() — relies on compareTo()
        Arrays.sort(shortlisted);

        // Step 4: Build output string
        if (shortlisted.length == 0) {
            return "No candidates shortlisted.";
        }

        StringBuilder result = new StringBuilder();
        for (int rank = 0; rank < shortlisted.length; rank++) {
            if (rank > 0) {
                result.append(" | ");
            }
            result.append((rank + 1) + ". " + shortlisted[rank].getName()
                          + " (" + shortlisted[rank].getCompositeScore() + ")");
        }

        return result.toString();
    }

    // ─── Display Method ─────────────────────────────────────────────────
    /**
     * Prints candidate details, eligibility status, and final ranking.
     *
     * @param candidates array of candidates to process
     */
    static void displayShortlistResults(Candidate[] candidates) {
        System.out.println("--- Eligibility Check ---");
        for (int i = 0; i < candidates.length; i++) {
            Candidate candidate = candidates[i];
            boolean cgpaOnly = isEligible(candidate.getCgpa());
            boolean combined = isEligible(candidate.getCgpa(), candidate.getCodingScore());
            String status;

            if (cgpaOnly) {
                status = "ELIGIBLE (CGPA direct)";
            } else if (combined) {
                status = "ELIGIBLE (CGPA + Coding)";
            } else {
                status = "NOT ELIGIBLE";
            }

            System.out.printf("  %-10s | CGPA: %.1f | Code: %3d | %s%n",
                    candidate.getName(), candidate.getCgpa(),
                    candidate.getCodingScore(), status);
        }

        System.out.println();
        System.out.println("--- Final Ranking ---");
        System.out.println(shortlistAndRank(candidates));
    }

    // ─── Input Method ───────────────────────────────────────────────────
    /**
     * Reads candidate data from user input and processes them.
     *
     * @param scanner the Scanner for user input
     */
    static void readAndProcessInput(Scanner scanner) {
        System.out.print("Enter number of candidates: ");
        int count = Integer.parseInt(scanner.nextLine().trim());

        Candidate[] candidates = new Candidate[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Candidate " + (i + 1) + ":");
            System.out.print("  Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("  CGPA (0-10): ");
            double cgpa = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("  Coding Score (0-100): ");
            int codingScore = Integer.parseInt(scanner.nextLine().trim());
            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println();
        displayShortlistResults(candidates);
    }

    // ─── Main ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   PLACEMENT DRIVE SHORTLISTING & RANKING");
        System.out.println("==============================================");
        System.out.println();

        // --- Sample Run (matches problem statement) ---
        System.out.println("--- Sample Run ---");
        System.out.println("Thresholds: CGPA direct >= 7.0 | Borderline CGPA >= 6.5 with Coding >= 60");
        System.out.println();

        Candidate[] sampleCandidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        displayShortlistResults(sampleCandidates);
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
