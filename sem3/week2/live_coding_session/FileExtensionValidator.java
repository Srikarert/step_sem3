/**
 * Program Name  : FileExtensionValidator
 * Class Name    : FileExtensionValidator
 * Description   : Day 2 Live-Coding Session - Problem 3: File Extension Validator.
 *                 Validates file name extension (PDF, DOCX, ZIP) case-insensitively.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public static String validateFileExtension(String filename) {
        if (filename == null) {
            return "Rejected -- invalid file type";
        }

        String trimmedName = filename.trim();
        int lastDotIndex = trimmedName.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == trimmedName.length() - 1) {
            return "Rejected -- invalid file type";
        }

        String extension = trimmedName.substring(lastDotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(accepted)) {
                return "Accepted";
            }
        }

        return "Rejected -- invalid file type";
     }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("        FILE EXTENSION VALIDATOR                ");
        System.out.println("==================================================\n");

        String[] testFiles = {
            "Assignment1.PDF",
            "notes.txt",
            "project_report.docx",
            "ackula_srikar.ZIP",
            "image.png",
            "fileWithoutExtension",
            ".noname.zip"
        };

        for (String filename : testFiles) {
            String result = validateFileExtension(filename);
            System.out.printf("Input: \"%s\" => Output: %s\n", filename, result);
        }
    }
}