/**
 * Category C - Problem M5: Student and College Information Management
 * 
 * Scenario:
 * A club member's first draft of Student stores attendance, name, AND the college name
 * as instance fields — meaning every single student object ends up with its own copy
 * of "SRM Institute of Science and Technology" typed in separately.
 * Fix the design using static fields and a static method.
 */
class Student {
    String name;
    double attendance;

    // Shared class-level static fields
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // increments once per student instantiation
    }

    // Static method: prints shared college info, does not access instance fields
    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentAndCollegeInformationManagement {
    public static void main(String[] args) {
        // Create two Student objects
        Student s1 = new Student("Ravi", 85.0);
        Student s2 = new Student("Anitha", 92.5);

        // Call printCollegeInfo() through the class name, not through either object
        Student.printCollegeInfo();
    }
}
