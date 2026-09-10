/**
 * Program Name  : ExceptionPractice
 * Class Name    : ExceptionPractice
 * Description   : Demonstrates Java Exception concepts:
 *                  9.  Java Exceptions
 *                 10.  Java Exception Hierarchy
 *                 11.  Java Exception Types
 *                 12.  java.lang.RuntimeException / Unchecked Exceptions
 *                 13.  Checked Exceptions
 * Best Practices: Variables for fixed/input/result values, methods instead
 *                 of inline code, proper naming conventions, try-catch-finally
 *                 blocks, custom exceptions, and multi-catch.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// ==========================================================================
//  CUSTOM EXCEPTIONS (part of Exception Hierarchy demonstration)
// ==========================================================================

/**
 * Custom Checked Exception - must be declared/caught explicitly.
 * Hierarchy: Exception -> IOException -> InvalidStudentDataException (checked)
 */
class InvalidStudentDataException extends Exception {
    // Fixed error code variable
    private final int errorCode;

    public InvalidStudentDataException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

/**
 * Custom Unchecked Exception - extends RuntimeException.
 * Hierarchy: Throwable -> Error / Exception -> RuntimeException -> InvalidAgeException
 */
class InvalidAgeException extends RuntimeException {
    // Fixed minimum age variable
    private static final int MINIMUM_VALID_AGE = 0;

    public InvalidAgeException(String message) {
        super(message);
    }

    public static int getMinimumValidAge() {
        return MINIMUM_VALID_AGE;
    }
}

// ==========================================================================
//  MAIN CLASS
// ==========================================================================

public class ExceptionPractice {

    // ----------------------------------------------------------------------
    // CONCEPT 9 - Java Exceptions: basic try-catch-finally
    // ----------------------------------------------------------------------

    /**
     * Safely divides two integers and handles divide-by-zero.
     * Demonstrates: basic try-catch-finally structure (Concept 9).
     *
     * @param dividend the number to be divided (input parameter)
     * @param divisor  the number to divide by (input parameter)
     * @return int     result of division, or 0 if divisor is zero
     */
    static int safeDivide(int dividend, int divisor) {
        int result = 0; // result variable

        try {
            result = dividend / divisor;
            System.out.println("  Division result : " + dividend + " / " + divisor + " = " + result);

        } catch (ArithmeticException arithmeticEx) {
            System.out.println("  [CAUGHT] ArithmeticException: " + arithmeticEx.getMessage());
            System.out.println("  Division by zero is not allowed. Returning 0.");

        } finally {
            System.out.println("  [FINALLY] safeDivide() block executed.");
        }

        return result; // result
    }

    /**
     * Drives CONCEPT 9 demonstration.
     */
    static void demonstrateBasicException() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 9 - Java Exceptions");
        System.out.println("========================================");

        // Fixed test values
        int dividend1    = 100;
        int divisor1     = 5;
        int dividend2    = 50;
        int divisorZero  = 0;

        System.out.println("Case 1: Normal division");
        int normalResult = safeDivide(dividend1, divisor1);

        System.out.println("\nCase 2: Division by zero");
        int errorResult  = safeDivide(dividend2, divisorZero);

        System.out.println();
    }

    // ----------------------------------------------------------------------
    // CONCEPT 10 - Java Exception Hierarchy
    // ----------------------------------------------------------------------

    /**
     * Visualizes the Exception class hierarchy by intentionally triggering
     * different exception types and catching them at various hierarchy levels.
     *
     * Hierarchy displayed:
     *   Throwable
     *   |- Error         (OutOfMemoryError, StackOverflowError)
     *   |- Exception
     *      |- IOException          (Checked)
     *      |- RuntimeException     (Unchecked)
     *         |- NullPointerException
     *         |- ArrayIndexOutOfBoundsException
     *         |- NumberFormatException
     *         |- ArithmeticException
     */
    static void demonstrateExceptionHierarchy() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 10 - Exception Hierarchy");
        System.out.println("========================================");

        System.out.println("Java Exception Hierarchy:");
        System.out.println("  Throwable");
        System.out.println("  |- Error  (e.g. StackOverflowError, OutOfMemoryError)");
        System.out.println("  |    [Unrecoverable - NOT caught in normal programs]");
        System.out.println("  `- Exception");
        System.out.println("       |- IOException          (Checked)");
        System.out.println("       |- SQLException         (Checked)");
        System.out.println("       |- ClassNotFoundException (Checked)");
        System.out.println("       `- RuntimeException     (Unchecked)");
        System.out.println("            |- NullPointerException");
        System.out.println("            |- ArithmeticException");
        System.out.println("            |- NumberFormatException");
        System.out.println("            |- ArrayIndexOutOfBoundsException");
        System.out.println("            `- ClassCastException");
        System.out.println();

        // Catching via parent class (Exception) to show hierarchy
        try {
            String nullString = null;
            int length = nullString.length(); // triggers NullPointerException

        } catch (Exception parentCatch) {
            // NullPointerException IS-A RuntimeException IS-A Exception
            System.out.println("  Caught via parent class 'Exception'  : "
                    + parentCatch.getClass().getSimpleName());
            System.out.println("  Message: " + parentCatch.getMessage());
        }
        System.out.println();
    }

    // ----------------------------------------------------------------------
    // CONCEPT 11 - Java Exception Types (multiple distinct types)
    // ----------------------------------------------------------------------

    /**
     * Safely parses an integer from a String.
     *
     * @param numberText the text to parse (input parameter)
     * @return int       parsed value, or -1 on failure (result)
     */
    static int parseIntegerSafely(String numberText) {
        int parsedValue = -1; // result variable (default on error)
        try {
            parsedValue = Integer.parseInt(numberText);
        } catch (NumberFormatException numEx) {
            System.out.println("  [CAUGHT] NumberFormatException: \"" + numberText
                    + "\" is not a valid integer.");
        }
        return parsedValue; // result
    }

    /**
     * Safely accesses an element from a String array by index.
     *
     * @param dataArray   the array to access (input parameter)
     * @param targetIndex the index to retrieve (input parameter)
     * @return String     the element at index, or "N/A" if out of bounds (result)
     */
    static String safeArrayAccess(String[] dataArray, int targetIndex) {
        String resultElement = "N/A"; // result variable (default on error)
        try {
            resultElement = dataArray[targetIndex];
        } catch (ArrayIndexOutOfBoundsException arrayEx) {
            System.out.println("  [CAUGHT] ArrayIndexOutOfBoundsException: index "
                    + targetIndex + " is out of bounds for length " + dataArray.length);
        }
        return resultElement; // result
    }

    /**
     * Safely casts an Object to String.
     *
     * @param objectValue the object to cast (input parameter)
     * @return String     cast result or "CAST_FAILED" (result)
     */
    static String safeCast(Object objectValue) {
        String castResult = "CAST_FAILED"; // result variable
        try {
            castResult = (String) objectValue;
        } catch (ClassCastException castEx) {
            System.out.println("  [CAUGHT] ClassCastException: "
                    + objectValue.getClass().getSimpleName() + " cannot be cast to String.");
        }
        return castResult; // result
    }

    /**
     * Drives CONCEPT 11 demonstration.
     */
    static void demonstrateExceptionTypes() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 11 - Exception Types");
        System.out.println("========================================");

        // --- NullPointerException ---
        System.out.println("[ NullPointerException ]");
        try {
            String nullRef = null;
            System.out.println(nullRef.length()); // triggers NPE
        } catch (NullPointerException npe) {
            System.out.println("  [CAUGHT] NullPointerException: cannot invoke method on null reference.");
        }

        // --- NumberFormatException ---
        System.out.println("\n[ NumberFormatException ]");
        String  validNumber   = "123";
        String  invalidNumber = "abc";
        int     parseResult1  = parseIntegerSafely(validNumber);
        int     parseResult2  = parseIntegerSafely(invalidNumber);
        System.out.println("  Parse \"" + validNumber   + "\" -> " + parseResult1);
        System.out.println("  Parse \"" + invalidNumber + "\" -> " + parseResult2);

        // --- ArrayIndexOutOfBoundsException ---
        System.out.println("\n[ ArrayIndexOutOfBoundsException ]");
        String[] colours     = {"Red", "Green", "Blue"};
        int      validIndex  = 1;
        int      invalidIdx  = 10;
        System.out.println("  Access index " + validIndex  + " -> " + safeArrayAccess(colours, validIndex));
        System.out.println("  Access index " + invalidIdx  + " -> " + safeArrayAccess(colours, invalidIdx));

        // --- ClassCastException ---
        System.out.println("\n[ ClassCastException ]");
        Object integerObject = Integer.valueOf(42);
        String castResult    = safeCast(integerObject);
        System.out.println("  Cast result : " + castResult);

        // --- StackOverflowError (caught for display only - not normal practice) ---
        System.out.println("\n[ StackOverflowError (Error subclass) ]");
        try {
            triggerStackOverflow();
        } catch (StackOverflowError soe) {
            System.out.println("  [CAUGHT] StackOverflowError: infinite recursion detected.");
        }

        System.out.println();
    }

    /** Helper method that recurses infinitely to trigger StackOverflowError. */
    static void triggerStackOverflow() {
        triggerStackOverflow(); // infinite recursion
    }

    // ----------------------------------------------------------------------
    // CONCEPT 12 - Unchecked Exceptions (RuntimeException)
    // ----------------------------------------------------------------------

    /**
     * Validates that a student age is within an acceptable range.
     * Throws InvalidAgeException (our custom RuntimeException) if invalid.
     *
     * @param studentAge the age to validate (input parameter)
     * @throws InvalidAgeException if age is negative (unchecked)
     */
    static void validateStudentAge(int studentAge) {
        // Fixed boundary values
        final int maximumValidAge = 120;

        if (studentAge < InvalidAgeException.getMinimumValidAge()) {
            throw new InvalidAgeException(
                    "Age " + studentAge + " is negative. Minimum valid age is "
                    + InvalidAgeException.getMinimumValidAge());
        }
        if (studentAge > maximumValidAge) {
            throw new InvalidAgeException(
                    "Age " + studentAge + " exceeds maximum " + maximumValidAge);
        }
        System.out.println("  Age " + studentAge + " is valid.");
    }

    /**
     * Demonstrates reading an integer from a Scanner and handling mismatch.
     *
     * @param scanner the shared Scanner (input parameter)
     * @return int    the integer read, or -1 on mismatch (result)
     */
    static int readIntegerFromUser(Scanner scanner) {
        int userInteger = -1; // result variable
        System.out.print("  Enter an integer : ");
        try {
            userInteger = scanner.nextInt();
        } catch (InputMismatchException imEx) {
            System.out.println("  [CAUGHT] InputMismatchException: input is not an integer.");
            scanner.nextLine(); // flush bad input
        } finally {
            System.out.println("  [FINALLY] readIntegerFromUser() executed.");
        }
        return userInteger; // result
    }

    /**
     * Drives CONCEPT 12 demonstration.
     *
     * @param scanner the shared Scanner
     */
    static void demonstrateUncheckedExceptions(Scanner scanner) {
        System.out.println("========================================");
        System.out.println("  CONCEPT 12 - Unchecked (Runtime) Exceptions");
        System.out.println("========================================");

        // Fixed test ages
        int validAge   = 20;
        int negativeAge = -5;
        int tooOldAge   = 200;

        System.out.println("Validating ages using custom InvalidAgeException (RuntimeException):");

        // Valid age - no exception
        try {
            validateStudentAge(validAge);
        } catch (InvalidAgeException iae) {
            System.out.println("  [CAUGHT] InvalidAgeException: " + iae.getMessage());
        }

        // Negative age - throws InvalidAgeException
        try {
            validateStudentAge(negativeAge);
        } catch (InvalidAgeException iae) {
            System.out.println("  [CAUGHT] InvalidAgeException: " + iae.getMessage());
        }

        // Too old - throws InvalidAgeException
        try {
            validateStudentAge(tooOldAge);
        } catch (InvalidAgeException iae) {
            System.out.println("  [CAUGHT] InvalidAgeException: " + iae.getMessage());
        }

        // InputMismatchException demo (unchecked - extends RuntimeException)
        System.out.println("\nInputMismatchException (Scanner):");
        int userInput = readIntegerFromUser(scanner);
        System.out.println("  Integer received : " + userInput);

        System.out.println();
    }

    // ----------------------------------------------------------------------
    // CONCEPT 13 - Checked Exceptions
    // ----------------------------------------------------------------------

    /**
     * Reads the first line of a text file - demonstrates checked IOException.
     * Checked exceptions MUST be declared with 'throws' or caught.
     *
     * @param filePath path to the file to read (input parameter)
     * @return String  first line of the file, or error message (result)
     * @throws IOException if an I/O error occurs (checked - declared in signature)
     */
    static String readFirstLineFromFile(String filePath) throws IOException {
        String firstLine; // result variable
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            firstLine = fileReader.readLine();
            if (firstLine == null) {
                firstLine = "[File is empty]";
            }
        }
        // IOException is re-thrown (checked) - caller must handle it
        return firstLine; // result
    }

    /**
     * Validates student data and throws a custom checked exception.
     *
     * @param studentName the name to validate (input parameter)
     * @param studentAge  the age to validate (input parameter)
     * @throws InvalidStudentDataException if name is empty or age is invalid (checked)
     */
    static void validateStudentData(String studentName, int studentAge)
            throws InvalidStudentDataException {

        // Fixed error codes
        final int EMPTY_NAME_ERROR_CODE = 1001;
        final int INVALID_AGE_ERROR_CODE = 1002;

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new InvalidStudentDataException(
                    "Student name cannot be empty.", EMPTY_NAME_ERROR_CODE);
        }
        if (studentAge < 0 || studentAge > 120) {
            throw new InvalidStudentDataException(
                    "Student age " + studentAge + " is not in valid range [0-120].",
                    INVALID_AGE_ERROR_CODE);
        }
        System.out.println("  Student data is valid: Name = " + studentName
                + ", Age = " + studentAge);
    }

    /**
     * Drives CONCEPT 13 demonstration.
     */
    static void demonstrateCheckedExceptions() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 13 - Checked Exceptions");
        System.out.println("========================================");

        // --- IOException demo ---
        System.out.println("[ IOException - File Reading ]");

        // Fixed file paths
        String nonExistentFilePath = "ghost_file.txt";

        try {
            String firstLine = readFirstLineFromFile(nonExistentFilePath);
            System.out.println("  First line: " + firstLine);
        } catch (IOException ioEx) {
            System.out.println("  [CAUGHT] IOException: " + ioEx.getMessage());
            System.out.println("  File \"" + nonExistentFilePath + "\" could not be read.");
        }

        // --- Custom Checked Exception (InvalidStudentDataException) ---
        System.out.println("\n[ Custom Checked Exception - InvalidStudentDataException ]");

        // Fixed test data sets
        String validName    = "Akula Srikar";
        int    validAge     = 20;
        String emptyName    = "";
        int    negativeAge  = -1;

        // Valid student
        try {
            validateStudentData(validName, validAge);
        } catch (InvalidStudentDataException isde) {
            System.out.println("  [CAUGHT] Code " + isde.getErrorCode() + ": " + isde.getMessage());
        }

        // Empty name
        try {
            validateStudentData(emptyName, validAge);
        } catch (InvalidStudentDataException isde) {
            System.out.println("  [CAUGHT] Code " + isde.getErrorCode() + ": " + isde.getMessage());
        }

        // Invalid age
        try {
            validateStudentData(validName, negativeAge);
        } catch (InvalidStudentDataException isde) {
            System.out.println("  [CAUGHT] Code " + isde.getErrorCode() + ": " + isde.getMessage());
        }

        // --- Multi-catch block ---
        System.out.println("\n[ Multi-Catch Block ]");
        try {
            String[] data  = {"42", "hello", null};
            int      index = 5;                       // triggers ArrayIndexOutOfBoundsException
            int      num   = Integer.parseInt(data[index]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException multiEx) {
            System.out.println("  [MULTI-CATCH] " + multiEx.getClass().getSimpleName()
                    + ": " + multiEx.getMessage());
        }

        // --- try-with-resources (auto-closes Closeable) ---
        System.out.println("\n[ try-with-resources ]");
        String tempFilePath = "sample_resource.txt";
        try (BufferedReader autoReader = new BufferedReader(new FileReader(tempFilePath))) {
            String line = autoReader.readLine();
            System.out.println("  Read: " + line);
        } catch (IOException ioEx) {
            System.out.println("  [CAUGHT] IOException in try-with-resources: " + ioEx.getMessage());
            System.out.println("  Resource was automatically closed by JVM.");
        }

        System.out.println();
    }

    // ----------------------------------------------------------------------
    // MAIN METHOD
    // ----------------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" EXCEPTION PRACTICE - STEP SEM 3 WEEK 1 ");
        System.out.println("==========================================");
        System.out.println();

        // Concept 9 - Basic exception handling
        demonstrateBasicException();

        // Concept 10 - Exception hierarchy
        demonstrateExceptionHierarchy();

        // Concept 11 - Exception types
        demonstrateExceptionTypes();

        // Concept 12 - Unchecked (Runtime) exceptions
        Scanner inputScanner = new Scanner(System.in);
        demonstrateUncheckedExceptions(inputScanner);

        // Concept 13 - Checked exceptions
        demonstrateCheckedExceptions();

        inputScanner.close();

        System.out.println("==========================================");
        System.out.println("            Program Complete              ");
        System.out.println("==========================================");
    }
}
