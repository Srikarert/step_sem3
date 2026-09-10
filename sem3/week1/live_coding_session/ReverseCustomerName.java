/**
 * Program Name  : ReverseCustomerName
 * Class Name    : ReverseCustomerName
 * Description   : Day 1 Live-Coding Session - Problem 5: Reverse Customer Name.
 *                 Reverses customer name for identity verification while preserving original.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        if (customerName == null) {
            return null;
        }

        char[] originalChars = customerName.toCharArray();
        int nameLength = originalChars.length;
        char[] reversedChars = new char[nameLength];

        for (int i = 0; i < nameLength; i++) {
            reversedChars[i] = originalChars[nameLength - 1 - i];
        }

        return new String(reversedChars);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     CUSTOMER IDENTITY VERIFICATION SYSTEM        ");
        System.out.println("==================================================\n");

        String[] customerNames = {"Sunil", "Akula Srikar", "SRM", "JavaDeveloper"};

        for (String originalName : customerNames) {
            String reversedName = reverseCustomerName(originalName);
            System.out.println("Original Name: " + originalName);
            System.out.println("Reversed Name: " + reversedName);
            System.out.println("--------------------------------------------------");
        }
    }
}