/**
 * Category C — Assignment Problems
 * Problem 3: The Password Checker
 * 
 * Scenario:
 * A signup form checks how strong your chosen password is.
 * 
 * Problem Statement:
 * Design a PasswordChecker class that accepts a password once and reveals only its strength rating
 * — never the password itself.
 * 
 * Key Requirements:
 * - Take the password as a string in the constructor and store it privately, with no getter that returns it.
 * - Provide a method that returns a strength label:
 *     - "Weak": under 6 characters (< 6)
 *     - "Medium": 6-9 characters (6 to 9 inclusive)
 *     - "Strong": 10+ characters (>= 10)
 * - The password itself must never be changeable after the object is created (immutable / final).
 * - There is no method anywhere that exposes the actual password text.
 */
public class PasswordChecker {
    private final String password;

    /**
     * Constructs a PasswordChecker with the given password.
     * The password is saved in a private final field and can never be retrieved or modified.
     *
     * @param password the password to evaluate
     */
    public PasswordChecker(String password) {
        this.password = (password == null) ? "" : password;
    }

    /**
     * Evaluates and returns the strength rating based on password length.
     * 
     * Strength rules:
     * - Under 6 characters: "Weak"
     * - 6 to 9 characters: "Medium"
     * - 10 or more characters: "Strong"
     *
     * @return strength label ("Weak", "Medium", or "Strong")
     */
    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    /**
     * Checks if the password satisfies a minimum requirement (e.g. contains at least one digit).
     * Does not expose the password text.
     *
     * @return true if password contains at least one digit
     */
    public boolean containsDigit() {
        for (char c : password.toCharArray()) {
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PasswordChecker [Strength: " + getStrength() + ", Password: [PROTECTED]]";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Password Checker ===");

        // Sample Input/Output from Assignment
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password 'abcd' (len 4)            -> pc1.getStrength() = " + pc1.getStrength()); // Weak

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password 'abcdefgh' (len 8)        -> pc2.getStrength() = " + pc2.getStrength()); // Medium

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Password 'abcdefghij' (len 10)     -> pc3.getStrength() = " + pc3.getStrength()); // Strong

        PasswordChecker pc4 = new PasswordChecker("superStrongPassword123!");
        System.out.println("Password (len 23)                  -> pc4.getStrength() = " + pc4.getStrength()); // Strong

        System.out.println("\nObject inspection (no password leak): " + pc1);
        System.out.println("Notice: No getter exists to reveal the actual password string!");
    }
}
