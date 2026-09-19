package srm.hostel;

import srm.fees.FeeAccount;

/**
 * Demonstrates visibility rules when accessing FeeAccount from a different package
 * without inheritance.
 */
public class HostelOfficeDemo {
    public static void main(String[] args) {
        System.out.println("=== SECTION 2 DEMO: Subclass vs Unrelated Class in Different Package ===");

        // 1. Using subclass HostelFeeAccount:
        HostelFeeAccount hostelAcc = new HostelFeeAccount("RA2311003010456", 180000.0, "BH-2, Room 304", 65000.0);
        hostelAcc.chargeLateFine(2500.0);
        System.out.println("Total Hostel & Academic Due: Rs." + hostelAcc.getTotalHostelAndAcademicDue());

        // 2. An unrelated class in srm.hostel accessing a raw FeeAccount object:
        FeeAccount rawAcc = new FeeAccount("RA2311003010789", 150000.0);

        // Can access PUBLIC members:
        System.out.println("Raw account type (public): " + rawAcc.accountType);
        System.out.println("Raw account regNo (getter): " + rawAcc.getRegNo());

        // CANNOT access DEFAULT (package-private):
        // System.out.println(rawAcc.totalFee); // COMPILE ERROR: totalFee is not public in FeeAccount

        // CANNOT access PROTECTED from unrelated class in another package:
        // System.out.println(rawAcc.amountPaid); // COMPILE ERROR: amountPaid has protected access
        // rawAcc.applyLatePenalty(1000);         // COMPILE ERROR: applyLatePenalty has protected access

        System.out.println("Notice: protected is accessible to subclasses, but NOT to unrelated classes in other packages!");
    }
}
