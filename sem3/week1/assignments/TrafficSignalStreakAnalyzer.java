/**
 * Program Name  : TrafficSignalStreakAnalyzer
 * Class Name    : TrafficSignalStreakAnalyzer
 * Description   : Week 1 Assignment - Problem 3: The Traffic Signal Streak Analyzer.
 *                 Scans signal log and reports longest continuous streak of a color.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class TrafficSignalStreakAnalyzer {

    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal readings available.");
            return;
        }

        char longestStreakColor = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;


        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);
            if (ch == currentColor) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestStreakColor = currentColor;
                }
                currentColor = ch;
                currentStreakLength = 1;
            }
        }

        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            longestStreakColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestStreakColor, maxStreakLength);
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("   TRAFFIC SIGNAL STREAK ANALYZER              ");
        System.out.println("===================================================\n");

        String[] testLogs = {"RRGGGYRR", "RRRRYYGG", "YYYYYYYY", "RGYRGY"};

        for (String log : testLogs) {
            System.out.println("Signal Log: \"" + log + "\"");
            findLongestStreak(log);
            System.out.println("-------------------------------------------------");
        }
    }
}