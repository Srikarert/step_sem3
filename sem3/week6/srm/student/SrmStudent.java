package srm.student;

import java.io.Serializable;

/**
 * Demonstrates:
 * 1. SECTION 4: The JavaBean Standard (getters, setters, isX for boolean, public no-arg constructor)
 * 2. SECTION 5: Read-Only Property (regNo has getter only, set in constructor)
 */
public class SrmStudent implements Serializable {
    private static final long serialVersionUID = 1L;

    // Read-only property (set once, getter only)
    private final String regNo;

    // Read-write properties following standard JavaBean conventions
    private String name;
    private int attendance;
    private boolean scholarshipHolder;

    /**
     * Public no-argument constructor:
     * Required by JavaBean standard for frameworks (Spring, Jackson, Hibernate, etc.)
     * to instantiate objects via reflection.
     */
    public SrmStudent() {
        this.regNo = "TEMP-" + System.currentTimeMillis() % 10000;
        this.name = "Unknown";
        this.attendance = 0;
        this.scholarshipHolder = false;
    }

    /**
     * Parameterized constructor
     */
    public SrmStudent(String regNo, String name) {
        this.regNo = regNo;
        this.name = name;
        this.attendance = 100;
        this.scholarshipHolder = false;
    }

    public SrmStudent(String regNo, String name, int attendance, boolean scholarshipHolder) {
        this.regNo = regNo;
        this.name = name;
        setAttendance(attendance);
        this.scholarshipHolder = scholarshipHolder;
    }

    // READ-ONLY PROPERTY: regNo has getter, but DELIBERATELY no setter
    public String getRegNo() {
        return regNo;
    }

    // STANDARD JAVABEAN GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : "Unknown";
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        if (attendance < 0 || attendance > 100) {
            throw new IllegalArgumentException("Attendance must be between 0 and 100%. Given: " + attendance);
        }
        this.attendance = attendance;
    }

    /**
     * CRITICAL JAVABEAN RULE:
     * For boolean fields, getter must start with 'is', NOT 'get'!
     */
    public boolean isScholarshipHolder() {
        return scholarshipHolder;
    }

    public void setScholarshipHolder(boolean scholarshipHolder) {
        this.scholarshipHolder = scholarshipHolder;
    }

    @Override
    public String toString() {
        return String.format("SrmStudent[regNo=%s, name=%s, attendance=%d%%, scholarship=%b]",
                regNo, name, attendance, scholarshipHolder);
    }
}
