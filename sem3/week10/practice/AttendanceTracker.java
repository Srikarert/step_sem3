import java.util.*;

public class AttendanceTracker {
    // Returns {presentDays, longestStreak} in a single pass.
    // Time: O(n). Space: O(1) (only three counters).
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int current = 0;
        int longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                current++;
                longest = Math.max(longest, current);
            } else {
                current = 0;
            }
        }
        return new int[]{present, longest};
    }

    // Input: first line N, then N values of 0/1.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }
        int[] r = attendanceSummary(days);
        System.out.println("Present: " + r[0] + ", Longest streak: " + r[1]);
    }
}
