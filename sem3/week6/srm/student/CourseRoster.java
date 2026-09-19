package srm.student;

import java.util.Arrays;

/**
 * Demonstrates Section 7: final Fields and Encapsulation.
 * Shows why 'final' alone is not sufficient when dealing with mutable objects (like arrays).
 * Explains and implements DEFENSIVE COPYING to seal the mutability leak.
 */
public class CourseRoster {
    private final String courseCode;
    // final locks the reference to the array; it does NOT freeze the array elements!
    private final int[] scores;

    /**
     * Defensive constructor:
     * Clones the input array so callers cannot modify internal state via their original reference.
     */
    public CourseRoster(String courseCode, int[] scores) {
        this.courseCode = courseCode != null ? courseCode : "UNKNOWN";
        // DEFENSIVE COPY IN:
        this.scores = (scores != null) ? scores.clone() : new int[0];
    }

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Defensive getter:
     * Clones the internal array before returning so outside callers cannot modify internal scores.
     */
    public int[] getScores() {
        // DEFENSIVE COPY OUT:
        return scores.clone();
    }

    /**
     * Computes the average score safely without exposing internal array.
     */
    public double getAverageScore() {
        if (scores.length == 0) return 0.0;
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        return (double) sum / scores.length;
    }

    @Override
    public String toString() {
        return "CourseRoster[course=" + courseCode + ", scores=" + Arrays.toString(scores) +
                ", avg=" + String.format("%.1f", getAverageScore()) + "]";
    }
}
