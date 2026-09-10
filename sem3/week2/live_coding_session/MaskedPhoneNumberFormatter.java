/**
 * Program Name  : MaskedPhoneNumberFormatter
 * Class Name    : MaskedPhoneNumberFormatter
 * Description   : Day 2 Live-Coding Session - Problem 4: Masked Phone Number Formatter.
 *                 Validates 10-digit phone number and masks as XXXXXX-dddd.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {
        if (phone == null) {
            return "Invalid phone number";
        }

        String trimmedPhone = phone.trim();

        if (trimmedPhone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < 10; i++) {
            if (!Character.isDigit(trimmedPhone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder phoneBuilder = new StringBuilder();
        phoneBuilder.append("XXXXXX");
        phoneBuilder.append(trimmedPhone.substring(6));

        phoneBuilder.insert(6, '-');

        return phoneBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        MASKED PHONE NUMBER FORMATTER           ");
        System.out.println("==================================================\n");

        String[] testNumbers = {
            "9876543210",
            "98765",
            "987654321011",
            "9876a43210",
            "9801020304"
        };

        for (String num : testNumbers) {
            String result = maskPhoneNumber(num);
            System.out.printf("Input: \"%s\" => Output: %s\n", num, result);
        }
    }
}