public class AttendanceSummary {
    public static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;
                longestStreak = Math.max(longestStreak, streak);
            } else {
                streak = 0;
            }
        }

        return new int[] {present, longestStreak};
    }

    public static void main(String[] args) {
        int[] summary = attendanceSummary(new int[] {1, 1, 0, 1, 1, 1, 0, 1});
        System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);
    }
}
