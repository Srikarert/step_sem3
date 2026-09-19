/**
 * Category C - Problem M2: Hostel Mess Wallet Management
 * 
 * Scenario:
 * A hostel mess-card top-up wallet must never be allowed to go negative,
 * and its balance must never be overwritten directly from outside the class.
 */
class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initialized to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
            return;
        }
        this.balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Balance after deduct: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}

public class HostelMessWalletManagement {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
