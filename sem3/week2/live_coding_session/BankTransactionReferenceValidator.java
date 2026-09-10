/**
 * Program Name  : BankTransactionReferenceValidator
 * Class Name    : BankTransactionReferenceValidator
 * Description   : Day 2 Live-Coding Session - Problem 5: Bank Transaction Reference Generator & Validator.
 *                 Normalizes raw references, validates length & character types,
 *                 and builds formatted reference strings.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String upperBankCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        return upperBankCode + remainder;
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.isEmpty()) {
            return "Invalid: reference cannot be empty";
        }

        if (reference.length() != 14) {
            return "Invalid: wrong length (expected 14 characters, got " + reference.length() + ")";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body (expected digits for date and sequence)";
            }
        }

        String bankCode = reference.substring(0, 3);
        String dd = reference.substring(3, 5);
        String mm = reference.substring(5, 7);
        String yy = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder formattedBuilder = new StringBuilder();
        formattedBuilder.append("[").append(bankCode).append("] DATE: ")
                        .append(dd).append("/").append(mm).append("/").append(yy)
                        .append(" | SEQ: ").append(seq);

        return formattedBuilder.toString();
    }

    public static void processReference(String rawRef) {
        String normalized = normalizeReference(rawRef);
        String finalOutput = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\" => Output: %s\n", rawRef, finalOutput);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("    BANK TRANSACTION REFERENCE VALIDATOR       ");
        System.out.println("===================================================\n");

        String[] testRawReferences = {
            " hdf03022600042 ",
            "12F03022600042",
            "sbi0302260A042",
            " ic1103022600042 ",
            "barb10022500999"
        };

        for (String raw : testRawReferences) {
            processReference(raw);
        }
    }
}