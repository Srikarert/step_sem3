/**
 * Program Name  : AtmPinValidator
 * Class Name    : AtmPinValidator
 * Description   : Week 2 Assignment - Problem 1: ATM"PIN Length Validator.
 *                 Checks if an ATM PIN is exactly 4 digits long using length().
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class AtmPinValidator {

    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN -- must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       ATM PIN LENGTH VALIDATOR               ");
        System.out.println("==================================================\n");

        String[] testPins = {"482", "4820", "", "12345" };

        for (String pin : testPins) {
            System.out.println("Input: \"" + pin + "\"");
            System.out.print("Output: ");
            checkPinLength(pin);
            System.out.println("-------------------------------------------------");
        }
    }
}