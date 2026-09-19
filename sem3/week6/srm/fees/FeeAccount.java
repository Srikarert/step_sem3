package srm.fees;

/**
 * Demonstrates the four access levels and core encapsulation principles in Java.
 * - private: only this class
 * - default (package-private): same package (srm.fees)
 * - protected: same package + subclasses anywhere
 * - public: anywhere without restriction
 */
public class FeeAccount {
    // 1. private: Accessible only within FeeAccount
    private String regNo;
    private String internalAuditCode;

    // 2. default (package-private, no keyword): Accessible only within srm.fees package
    double totalFee;

    // 3. protected: Accessible in srm.fees AND any subclass in any package
    protected double amountPaid;

    // 4. public: Accessible anywhere across all packages
    public String accountType;

    /**
     * Default constructor for JavaBean compatibility
     */
    public FeeAccount() {
        this("UNKNOWN", 0.0, "REGULAR");
    }

    /**
     * Parameterized constructor
     */
    public FeeAccount(String regNo, double totalFee) {
        this(regNo, totalFee, "REGULAR");
    }

    public FeeAccount(String regNo, double totalFee, String accountType) {
        this.regNo = regNo;
        this.totalFee = Math.max(0.0, totalFee);
        this.amountPaid = 0.0;
        this.accountType = accountType != null ? accountType : "REGULAR";
        this.internalAuditCode = "AUDIT-" + Math.abs(regNo.hashCode());
    }

    // Public getter for private field regNo (Read-only door)
    public String getRegNo() {
        return regNo;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getAccountType() {
        return accountType;
    }

    /**
     * Protected method: accessible to classes in srm.fees and subclasses (e.g. HostelFeeAccount)
     */
    protected void applyLatePenalty(double penaltyAmount) {
        if (penaltyAmount > 0) {
            this.totalFee += penaltyAmount;
            System.out.println("[FeeAccount] Late penalty applied: Rs." + penaltyAmount + ". New total: Rs." + totalFee);
        }
    }

    /**
     * Encapsulated method with business logic validation.
     * Prevents negative or zero payments from corrupting account state.
     */
    public void pay(double amount) {
        if (amount <= 0) {
            System.out.println("[FeeAccount] Payment rejected: Amount must be positive! Attempted: Rs." + amount);
            return;
        }
        this.amountPaid += amount;
        System.out.println("[FeeAccount] Payment accepted: Rs." + amount + ". Total paid: Rs." + amountPaid);
    }

    /**
     * Computed read-only property
     */
    public double getDue() {
        return Math.max(0.0, totalFee - amountPaid);
    }

    @Override
    public String toString() {
        return String.format("FeeAccount[regNo=%s, totalFee=%.2f, amountPaid=%.2f, due=%.2f, type=%s]",
                regNo, totalFee, amountPaid, getDue(), accountType);
    }
}
