/**
 * Category C - Problem M3: Course Credit Management
 * 
 * Scenario:
 * Some courses come with a separate lab component and lab credit count; most don't.
 * Support both without writing the same setup logic twice by using constructor chaining with this(...).
 */
class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Constructor chaining for theory-only courses (defaults labCredits to 0)
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

public class CourseCreditManagement {
    public static void main(String[] args) {
        Course course1 = new Course("21CSC201J", "Data Structures", 4);
        Course course2 = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(course1.code + " total credits: " + course1.totalCredits());
        System.out.println(course2.code + " total credits: " + course2.totalCredits());
    }
}
