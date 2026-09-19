package srm.student;

/**
 * Demonstrates the Wrap-Up: Object Modeling - Putting It All Together.
 * 
 * Design decisions:
 * - regNo: final, read-only (Identity fixed at registration, never drifts)
 * - name: final, read-only (Student legal name fixed on admission)
 * - attendance: private double, read-write with strict validation (0.0 to 100.0)
 */
public final class SrmStudentProfile {
    // SECTION 6 & 7: final -- fixed forever once constructed
    private final String regNo;
    private final String name;

    // SECTION 3: private mutable state with validated access
    private double attendance;

    public SrmStudentProfile(String regNo, String name, double attendance) {
        if (regNo == null || name == null) {
            throw new IllegalArgumentException("Registration number and name cannot be null.");
        }
        this.regNo = regNo;
        this.name = name;
        setAttendance(attendance);
    }

    // SECTION 5: Read-only properties (getters only)
    public String getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    // SECTION 4: Standard JavaBean getter
    public double getAttendance() {
        return attendance;
    }

    // SECTION 3: Validated setter enforcing business rules
    public void setAttendance(double attendance) {
        if (attendance < 0.0 || attendance > 100.0) {
            System.out.println("[SrmStudentProfile] Rejected: Attendance must be between 0.0% and 100.0%. Attempted: " + attendance);
            return;
        }
        this.attendance = attendance;
        System.out.println("[SrmStudentProfile] Attendance updated to " + attendance + "% for " + name);
    }

    @Override
    public String toString() {
        return String.format("SrmStudentProfile[regNo=%s, name=%s, attendance=%.1f%%]", regNo, name, attendance);
    }
}
