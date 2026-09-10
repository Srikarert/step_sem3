/**
 * Program Name  : ExamSeatDuplicationChecker
 * Class Name    : ExamSeatDuplicationChecker
 * Description   : Week 1 Assignment - Problem 1: The Exam Hall Seat Duplication Checker.
 *                 Scans seat numbers using nested loops to flag duplicates without Collections.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class ExamSeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length <= 1) {
            System.out.println("No Duplicate Seats Found");
            return;
        }

        int totalSeats = seatNumbers.length;
        int[] alreadyReported = new int[totalSeats];
        int reportedCount = 0;
        boolean duplicateFound = false;

        for (int i = 0; i < totalSeats; i++) {
            int currentSeat = seatNumbers[i];

            boolean wasReported = false;
            for (int k = 0; k < reportedCount; k++) {
                if (alreadyReported[k] == currentSeat) {
                    wasReported = true;
                    break;
                }
            }

            if (wasReported) {
                continue;
            }

            boolean hasCopy = false;
            for (int j = i + 1; j < totalSeats; j++) {
                if (seatNumbers[j] == currentSeat) {
                    hasCopy = true;
                    break;
                }
            }

            if (hasCopy) {
                System.out.println("Duplicate Seat Number Found: " + currentSeat);
                alreadyReported[reportedCount++] = currentSeat;
                duplicateFound = true;
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("     EXAM HALL SEAT DUPLICATION CHECKER        ");
        System.out.println("===================================================\n");

        int[] case1Array = {101, 102, 103, 102, 105};
        System.out.println("Test Case 1: " + java.util.Arrays.toString(case1Array));
        checkDuplicateSeats(case1Array);

        System.out.println("--------------------------------------------------");

        int[] case2Array = {101, 102, 103, 104, 105};
        System.out.println("Test Case 2: " + java.util.Arrays.toString(case2Array));
        checkDuplicateSeats(case2Array);
    }
}