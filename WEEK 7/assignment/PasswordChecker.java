public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int len = password.length();
        boolean hasDigit = false;
        for (int i = 0; i < len; i++) {
            if (java.lang.Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        if (len < 6) {
            return "Weak";
        } else if (len < 10) {
            return "Medium";
        } else {
            if (hasDigit) {
                return "Strong";
            } else {
                return "Strong";
            }
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println("abcd strength: " + pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("abcdefgh strength: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij strength: " + pc3.getStrength());

        PasswordChecker pc4 = new PasswordChecker("abc123xyz999");
        System.out.println("abc123xyz999 strength: " + pc4.getStrength());
    }
}
