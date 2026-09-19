package srm.hostel;

import srm.fees.FeeAccount;

/**
 * Demonstrates Section 2: Visibility Across Packages and Inheritance.
 * HostelFeeAccount lives in package 'srm.hostel' and extends FeeAccount from 'srm.fees'.
 */
public class HostelFeeAccount extends FeeAccount {
    private String roomNumber;
    private double messFee;

    public HostelFeeAccount(String regNo, double academicFee, String roomNumber, double messFee) {
        super(regNo, academicFee, "HOSTEL_RESIDENT");
        this.roomNumber = roomNumber;
        this.messFee = Math.max(0.0, messFee);
    }

    public void chargeLateFine(double penalty) {
        System.out.println("[HostelFeeAccount] Charging late fine of Rs." + penalty + " for room " + roomNumber);

        // 1. applyLatePenalty() is PROTECTED in FeeAccount:
        // Accessible here because HostelFeeAccount is a SUBCLASS, even in a different package!
        applyLatePenalty(penalty);

        // 2. amountPaid is PROTECTED in FeeAccount:
        // Accessible through the inheritance relationship!
        System.out.println("[HostelFeeAccount] Current amount paid: Rs." + this.amountPaid);

        // 3. totalFee is DEFAULT (package-private) in FeeAccount:
        // System.out.println(this.totalFee);
        // COMPILE ERROR: totalFee is not public in FeeAccount; cannot be accessed from outside package

        // 4. internalAuditCode / regNo are PRIVATE:
        // System.out.println(this.internalAuditCode);
        // COMPILE ERROR: internalAuditCode has private access in FeeAccount
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getMessFee() {
        return messFee;
    }

    public double getTotalHostelAndAcademicDue() {
        return getDue() + messFee;
    }
}
