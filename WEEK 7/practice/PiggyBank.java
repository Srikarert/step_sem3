public class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= savings && amount > 0) {
            savings -= amount;
            return true;
        }
        return false;
    }

    public double getSavings() {
        return savings;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("After deposit 100: savings = " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("After withdraw 30: savings = " + pb.getSavings());
        boolean result = pb.withdraw(500);
        System.out.println("Withdraw 500 accepted? " + result + ", savings = " + pb.getSavings());
    }
}
