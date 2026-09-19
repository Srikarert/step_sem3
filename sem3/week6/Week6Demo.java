import srm.fees.FeeAccount;
import srm.fees.FeeOfficeDemo;
import srm.hostel.HostelFeeAccount;
import srm.hostel.HostelOfficeDemo;
import srm.student.*;

import java.util.Arrays;

/**
 * Master demonstration driver for STEP SEM-3 Week 6:
 * Access Modifiers, Encapsulation & Object Modeling.
 */
public class Week6Demo {
    public static void main(String[] args) {
        printHeader("STEP SEM-3 · Week 6 · Master Tutorial Demo");

        // -------------------------------------------------------------
        // SECTION 1: Four Access Levels
        // -------------------------------------------------------------
        printSection(1, "Access Modifiers — private, default, protected, public");
        FeeAccount feeAcc = new FeeAccount("RA2311003010001", 175000.0, "SCHOLARSHIP");
        System.out.println("Created: " + feeAcc);
        System.out.println("Public field 'accountType'   : " + feeAcc.accountType);
        System.out.println("Private field 'regNo' via getter: " + feeAcc.getRegNo());
        System.out.println("Note: Direct access to 'regNo' would trigger a compile-time error.");

        // -------------------------------------------------------------
        // SECTION 2: Visibility Across Packages and Inheritance
        // -------------------------------------------------------------
        printSection(2, "Visibility Rules Across Packages and Inheritance");
        HostelFeeAccount hostelAcc = new HostelFeeAccount("RA2311003010001", 175000.0, "MH-1 402", 70000.0);
        System.out.println("Hostel subclass created: Room " + hostelAcc.getRoomNumber());
        // Subclass calls protected method across package boundaries:
        hostelAcc.chargeLateFine(1500.0);
        System.out.println("Total due (academic + hostel): Rs." + hostelAcc.getTotalHostelAndAcademicDue());
        System.out.println("Subclass can access protected members; unrelated classes in another package cannot!");

        // -------------------------------------------------------------
        // SECTION 3: Encapsulation — Data Hiding & Invariant Enforcement
        // -------------------------------------------------------------
        printSection(3, "Encapsulation — Data Hiding with Validated Methods");
        System.out.println("Initial Due: Rs." + feeAcc.getDue());
        System.out.println("Attempting invalid negative payment (-25000):");
        feeAcc.pay(-25000); // Handled safely by encapsulation
        System.out.println("Attempting valid payment (50000):");
        feeAcc.pay(50000);
        System.out.println("Updated Due: Rs." + feeAcc.getDue());

        // -------------------------------------------------------------
        // SECTION 4: The JavaBean Standard
        // -------------------------------------------------------------
        printSection(4, "The JavaBean Standard — Getters, Setters & Naming Conventions");
        SrmStudent student = new SrmStudent();
        student.setName("Akula Srikar");
        student.setAttendance(92);
        student.setScholarshipHolder(true);
        System.out.println("JavaBean Student: " + student);
        System.out.println("getName()                     : " + student.getName());
        System.out.println("getAttendance()               : " + student.getAttendance() + "%");
        System.out.println("isScholarshipHolder() (isX!)  : " + student.isScholarshipHolder());

        // -------------------------------------------------------------
        // SECTION 5: Read-Only and Write-Only Properties
        // -------------------------------------------------------------
        printSection(5, "Read-Only and Write-Only Properties");
        // Read-only:
        System.out.println("Read-only property 'regNo': " + student.getRegNo() + " (Cannot be changed via setter)");

        // Write-only:
        PortalAccount portal = new PortalAccount("srikar_a", "InitialPass#2026");
        System.out.println("PortalAccount created: " + portal);
        System.out.println("Testing password verification ('wrongPass'): " + portal.verifyPassword("wrongPass"));
        System.out.println("Testing password verification ('InitialPass#2026'): " + portal.verifyPassword("InitialPass#2026"));
        portal.setPassword("NewSecurePassword#99");
        System.out.println("Password updated! Note: No getPassword() exists to prevent credential leaks.");

        // -------------------------------------------------------------
        // SECTION 6: Immutable Objects
        // -------------------------------------------------------------
        printSection(6, "Immutable Objects & Wither Methods");
        EnrollmentRecord original = new EnrollmentRecord("RA2311003010001", "B.Tech CSE - Core", 2023);
        System.out.println("Original Object : " + original);

        EnrollmentRecord updated = original.withCourse("B.Tech CSE - AI & ML");
        System.out.println("Updated Object  : " + updated);
        System.out.println("Original Object : " + original);
        System.out.println("Are they distinct memory instances? " + (original != updated ? "YES (Original remains untouched!)" : "NO"));

        // -------------------------------------------------------------
        // SECTION 7: final Fields & Defensive Copying
        // -------------------------------------------------------------
        printSection(7, "final Fields and Encapsulation — Defensive Copying");
        int[] externalScores = {88, 92, 79, 95};
        CourseRoster roster = new CourseRoster("21CSC201J", externalScores);
        System.out.println("Initial Roster: " + roster);

        // Attempting to attack/corrupt state via caller array:
        System.out.println("Attacker modifies external array externalScores[0] = 0...");
        externalScores[0] = 0;
        System.out.println("Roster after external array mutation: " + roster);

        // Attempting to attack/corrupt state via getter:
        System.out.println("Attacker modifies getter return value roster.getScores()[1] = 0...");
        roster.getScores()[1] = 0;
        System.out.println("Roster after getter mutation attempt: " + roster);
        System.out.println("SUCCESS: Defensive copying fully protected internal state from tampering!");

        // -------------------------------------------------------------
        // WRAP-UP: Object Modeling
        // -------------------------------------------------------------
        printSection(8, "Object Modeling Wrap-Up — Putting It All Together");
        SrmStudentProfile profile = new SrmStudentProfile("RA2311003010999", "Akula Srikar", 85.0);
        System.out.println("Created Student Profile: " + profile);
        System.out.println("Attempting invalid attendance update (120%):");
        profile.setAttendance(120.0);
        System.out.println("Attempting valid attendance update (88.5%):");
        profile.setAttendance(88.5);
        System.out.println("Final Profile State: " + profile);

        printHeader("All Week 6 Demonstrations Completed Successfully!");
    }

    private static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(75));
        System.out.println("  " + title);
        System.out.println("=".repeat(75));
    }

    private static void printSection(int number, String title) {
        System.out.println("\n" + "-".repeat(75));
        System.out.println(" [SECTION " + number + "] " + title);
        System.out.println("-".repeat(75));
    }
}
