package srm.student;

import java.util.Objects;

/**
 * Demonstrates Section 6: Immutable Objects.
 * Rules of Immutability:
 * 1. Declare the class 'final' so subclasses cannot override methods to introduce mutability.
 * 2. All fields are 'private final' -- initialized once via constructor, cannot be reassigned.
 * 3. NO setter methods anywhere.
 * 4. To "change" state, return a BRAND NEW instance with the desired property modified (Wither method).
 */
public final class EnrollmentRecord {
    private final String regNo;
    private final String course;
    private final int enrollmentYear;

    public EnrollmentRecord(String regNo, String course, int enrollmentYear) {
        if (regNo == null || course == null) {
            throw new IllegalArgumentException("Registration number and course cannot be null.");
        }
        this.regNo = regNo;
        this.course = course;
        this.enrollmentYear = enrollmentYear;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getCourse() {
        return course;
    }

    public int getEnrollmentYear() {
        return enrollmentYear;
    }

    /**
     * Wither method:
     * Does NOT modify 'this' object. Instead, constructs and returns a brand-new
     * EnrollmentRecord with the updated course, leaving this instance 100% untouched.
     */
    public EnrollmentRecord withCourse(String newCourse) {
        return new EnrollmentRecord(this.regNo, newCourse, this.enrollmentYear);
    }

    public EnrollmentRecord withEnrollmentYear(int newYear) {
        return new EnrollmentRecord(this.regNo, this.course, newYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnrollmentRecord)) return false;
        EnrollmentRecord that = (EnrollmentRecord) o;
        return enrollmentYear == that.enrollmentYear &&
                Objects.equals(regNo, that.regNo) &&
                Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo, course, enrollmentYear);
    }

    @Override
    public String toString() {
        return String.format("EnrollmentRecord[regNo=%s, course=%s, year=%d, memoryHash=%d]",
                regNo, course, enrollmentYear, System.identityHashCode(this));
    }
}
