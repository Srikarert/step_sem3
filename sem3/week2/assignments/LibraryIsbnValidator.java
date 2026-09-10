/**
 * Program Name  : LibraryIsbnWalidator
 * Class Name    : LibraryIsbnValidator
 * Description   : Week 2 Assignment - Problem 4: Library ISBN Normalizer & Validator.
 *                 Normalizes and validates ISBN-style 13-character book codes.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        String upperPubCode = trimmed.substring(0, 3).toUpperCase();
        String remainder = trimmed.substring(3);
        return upperPubCode + remainder;
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.isEmpty()) {
            return "Invalid: code cannot be empty";
        }

        if (code.length() != 13) {
            return "Invalid: wrong length (expected 13 characters, got " + code.length() + ")";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body (expected digits for year and catalog)";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder formattedResult = new StringBuilder();
        formattedResult.append("[").append(pubCode).append("] YEAR: ")
                       .append(year)
                       .append(" | CATALOG: ")
                       .append(catalogNumber);

        return formattedResult.toString();
    }

    public static void processCode(String rawCode) {
        String normalized = normalizeCode(rawCode);
        String output = validateAndFormat(normalized);
        System.out.printf("Input: \"%s\" => Output: %s\n", rawCode, output);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("      LIBRARY ISBN NORMALIZER & VALIDATOR         ");
        System.out.println("==================================================\n");

        String[] testCodes = {
            " pen2026004251 ",
            "12N2026004251",
            "oxf202500a123",
            " oiu20240011 ",
            "spr20260001234"
        };

        for (String raw : testCodes) {
            processCode(raw);
        }
    }
}