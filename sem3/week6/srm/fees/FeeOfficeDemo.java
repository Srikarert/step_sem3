package srm.fees;

/**
 * Demonstrates access level rules from within the exact same package (srm.fees).
 */
public class FeeOfficeDemo {
    public static void main(String[] args) {
        System.out.println("=== SECTION 1 & 3 DEMO: Same-Package Access & Encapsulation ===");

        FeeAccount acc = new FeeAccount("RA2311003010123", 200000.0, "MERIT");

        // 1. public field: accessible directly
        System.out.println("acc.accountType (public)     : " + acc.accountType);

        // 2. default field: accessible directly because FeeOfficeDemo is in srm.fees
        System.out.println("acc.totalFee (package-default): Rs." + acc.totalFee);

        // 3. protected field: accessible directly because it is in the same package
        System.out.println("acc.amountPaid (protected)   : Rs." + acc.amountPaid);

        // 4. private field: CANNOT be accessed directly (would cause compile error)
        // System.out.println(acc.regNo); // COMPILE ERROR: regNo has private access in FeeAccount
        System.out.println("acc.getRegNo() (via getter)  : " + acc.getRegNo());

        System.out.println("\n--- Testing Encapsulated Validation ---");
        // Rejecting invalid negative payments
        acc.pay(-50000); // Properly rejected!
        acc.pay(75000);  // Valid payment accepted!

        System.out.println("Outstanding Due: Rs." + acc.getDue());
    }
}
