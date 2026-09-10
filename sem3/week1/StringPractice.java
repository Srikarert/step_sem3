/**
 * Program Name  : StringPractice
 * Class Name    : StringPractice
 * Description   : Demonstrates Java String concepts:
 *                 1.  Java Strings
 *                 2.  Create Strings (literal vs new keyword)
 *                 3.  Use of "\" Escape Sequences
 *                 4.  Take String Input (Scanner)
 *                 5.  String Arrays
 *                 6.  String as Method Parameters
 *                 7.  String Class Built-In Methods
 *                 8.  ASCII Character Codes
 * Best Practices: Variables for fixed/input/result values, methods instead
 *                 of inline code, proper naming conventions, and exception
 *                 handling wherever applicable.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Scanner;

public class StringPractice {

    // -----------------------------------------------------------------
    // CONCEPT 1 & 2 - Java Strings / Creating Strings
    // -----------------------------------------------------------------

    /**
     * Demonstrates two ways to create Strings:
     *  a) String literal  - stored in the String Pool
     *  b) new keyword     - always creates a new object on the heap
     */
    static void demonstrateStringCreation() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 1 & 2 - Creating Strings");
        System.out.println("========================================");

        // Fixed / constant strings
        String literalGreeting    = "Hello, STEP!";            // String literal
        String newKeywordMessage  = new String("Hello, STEP!"); // heap object

        // Result variables
        boolean areSameReference = (literalGreeting == newKeywordMessage);
        boolean areSameContent   = literalGreeting.equals(newKeywordMessage);

        System.out.println("Literal  string       : " + literalGreeting);
        System.out.println("New-keyword string    : " + newKeywordMessage);
        System.out.println("Same reference (==)   : " + areSameReference);
        System.out.println("Same content (.equals): " + areSameContent);
        System.out.println();
    }

    // -----------------------------------------------------------------
    // CONCEPT 3 - Use of "\" Escape Sequences
    // -----------------------------------------------------------------

    /**
     * Prints various escape-sequence demonstrations.
     * Escape sequences covered: \n  \t  \\  \"  \'
     */
    static void demonstrateEscapeSequences() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 3 - Escape Sequences");
        System.out.println("========================================");

        // Fixed demonstration strings
        String newlineExample     = "Line 1\nLine 2\nLine 3";
        String tabExample         = "Col1\tCol2\tCol3";
        String backslashExample   = "Path: C:\\Users\\srika\\Documents";
        String doubleQuoteExample = "She said \"Java is awesome!\"";
        String singleQuoteExample = "It\'s a beautiful day.";

        System.out.println("\\n  (newline)       :\n" + newlineExample);
        System.out.println("\\t  (tab)           : " + tabExample);
        System.out.println("\\\\  (backslash)    : " + backslashExample);
        System.out.println("\\\"  (double-quote) : " + doubleQuoteExample);
        System.out.println("\\\'  (single-quote) : " + singleQuoteExample);
        System.out.println();
    }

    // -----------------------------------------------------------------
    // CONCEPT 4 - Take String Input
    // -----------------------------------------------------------------

    /**
     * Reads a full name and a single word from the user using Scanner.
     *
     * @param scanner  shared Scanner tied to System.in
     * @return         the full name entered by the user (result variable)
     */
    static String readFullNameFromUser(Scanner scanner) {
        System.out.println("========================================");
        System.out.println("  CONCEPT 4 - String Input (Scanner)");
        System.out.println("========================================");

        System.out.print("Enter your full name : ");
        String userFullName   = scanner.nextLine();  // reads entire line

        System.out.print("Enter a single word  : ");
        String userSingleWord = scanner.next();      // reads one token
        scanner.nextLine();                          // consume leftover newline

        System.out.println("Full name captured   : " + userFullName);
        System.out.println("Single word captured : " + userSingleWord);
        System.out.println();

        return userFullName; // result
    }

    // -----------------------------------------------------------------
    // CONCEPT 5 - String Arrays
    // -----------------------------------------------------------------

    /**
     * Builds and displays a String array of programming languages.
     *
     * @return String[] the populated language array (result)
     */
    static String[] buildLanguageArray() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 5 - String Arrays");
        System.out.println("========================================");

        // Fixed array of languages
        String[] programmingLanguages = {"Java", "Python", "C", "C++", "JavaScript"};

        System.out.println("Programming languages in the array:");
        for (int index = 0; index < programmingLanguages.length; index++) {
            System.out.println("  [" + index + "] " + programmingLanguages[index]);
        }
        System.out.println("Total languages : " + programmingLanguages.length);
        System.out.println();

        return programmingLanguages; // result
    }

    // -----------------------------------------------------------------
    // CONCEPT 6 - String as Method Parameters
    // -----------------------------------------------------------------

    /**
     * Checks whether a given name exists inside the languages array.
     *
     * @param languageArray  the array to search (String[] as parameter)
     * @param targetLanguage the language name to look for (String as parameter)
     * @return boolean       true if found, false otherwise (result)
     */
    static boolean searchLanguageInArray(String[] languageArray, String targetLanguage) {
        for (String language : languageArray) {
            if (language.equalsIgnoreCase(targetLanguage)) {
                return true; // result
            }
        }
        return false; // result
    }

    /**
     * Formats a student name and roll number into a greeting message.
     *
     * @param studentName   input String parameter
     * @param studentRollNo input String parameter
     * @return String       formatted greeting (result)
     */
    static String buildStudentGreeting(String studentName, String studentRollNo) {
        // Result variable
        String greeting = "Welcome, " + studentName + "! Your roll number is " + studentRollNo + ".";
        return greeting;
    }

    /**
     * Drives CONCEPT 6 demonstrations.
     *
     * @param languageArray the array built in concept 5
     * @param userName      the name captured in concept 4
     */
    static void demonstrateStringAsParameter(String[] languageArray, String userName) {
        System.out.println("========================================");
        System.out.println("  CONCEPT 6 - String as Method Parameters");
        System.out.println("========================================");

        // Fixed values used as parameters
        String searchTarget  = "Java";
        String studentRollNo = "RA2411028010001";

        boolean isFound     = searchLanguageInArray(languageArray, searchTarget);
        String  greetingMsg = buildStudentGreeting(userName, studentRollNo);

        System.out.println("Search \"" + searchTarget + "\" in array : " + (isFound ? "Found" : "Not Found"));
        System.out.println(greetingMsg);
        System.out.println();
    }

    // -----------------------------------------------------------------
    // CONCEPT 7 - String Class Built-In Methods
    // -----------------------------------------------------------------

    /**
     * Demonstrates the most commonly used String built-in methods.
     *
     * @param inputText the String on which methods are applied (parameter)
     */
    static void demonstrateBuiltInMethods(String inputText) {
        System.out.println("========================================");
        System.out.println("  CONCEPT 7 - String Built-In Methods");
        System.out.println("========================================");

        // Fixed test string for trim demo
        String sampleSentence = "  Hello, Java World!  ";

        // Result variables - one per method demonstrated
        int     lengthResult        = inputText.length();
        char    charAtResult        = inputText.charAt(0);
        String  upperCaseResult     = inputText.toUpperCase();
        String  lowerCaseResult     = inputText.toLowerCase();
        String  trimResult          = sampleSentence.trim();
        String  replaceResult       = inputText.replace("Java", "STEP");
        boolean containsResult      = inputText.contains("Java");
        boolean startsWithResult    = inputText.startsWith("Hello");
        boolean endsWithResult      = inputText.endsWith("!");
        int     indexOfResult       = inputText.indexOf("Java");
        String  substringResult     = inputText.substring(7, 11);
        String  concatResult        = inputText.concat(" - Keep coding!");
        String[] splitResult        = inputText.split(", ");
        String  joinResult          = String.join(" | ", "Java", "Python", "C");
        boolean isEmptyResult       = "".isEmpty();
        String  valueOfResult       = String.valueOf(2026);
        boolean equalsIgnoreCase    = "java".equalsIgnoreCase("JAVA");

        System.out.printf("%-32s : %s%n",  "Original input",          inputText);
        System.out.printf("%-32s : %d%n",  ".length()",               lengthResult);
        System.out.printf("%-32s : %c%n",  ".charAt(0)",              charAtResult);
        System.out.printf("%-32s : %s%n",  ".toUpperCase()",          upperCaseResult);
        System.out.printf("%-32s : %s%n",  ".toLowerCase()",          lowerCaseResult);
        System.out.printf("%-32s : \"%s\"%n", ".trim()",              trimResult);
        System.out.printf("%-32s : %s%n",  ".replace(Java,STEP)",     replaceResult);
        System.out.printf("%-32s : %b%n",  ".contains(Java)",         containsResult);
        System.out.printf("%-32s : %b%n",  ".startsWith(Hello)",      startsWithResult);
        System.out.printf("%-32s : %b%n",  ".endsWith(!)",            endsWithResult);
        System.out.printf("%-32s : %d%n",  ".indexOf(Java)",          indexOfResult);
        System.out.printf("%-32s : %s%n",  ".substring(7,11)",        substringResult);
        System.out.printf("%-32s : %s%n",  ".concat()",               concatResult);
        System.out.printf("%-32s : %s | %s%n", ".split(', ')",        splitResult[0], splitResult[1]);
        System.out.printf("%-32s : %s%n",  "String.join(|,...)",      joinResult);
        System.out.printf("%-32s : %b%n",  "\"\".isEmpty()",          isEmptyResult);
        System.out.printf("%-32s : %s%n",  "String.valueOf(2026)",    valueOfResult);
        System.out.printf("%-32s : %b%n",  "equalsIgnoreCase()",      equalsIgnoreCase);
        System.out.println();
    }

    // -----------------------------------------------------------------
    // CONCEPT 8 - ASCII Character Codes
    // -----------------------------------------------------------------

    /**
     * Returns the ASCII (Unicode) integer value of a given character.
     *
     * @param inputChar the character whose code is needed (parameter)
     * @return int      the ASCII code (result)
     */
    static int getAsciiCode(char inputChar) {
        int asciiCode = (int) inputChar; // result
        return asciiCode;
    }

    /**
     * Returns the character that corresponds to a given ASCII code.
     *
     * @param asciiCode the integer code (parameter)
     * @return char     the mapped character (result)
     */
    static char getCharacterFromAscii(int asciiCode) {
        char resultChar = (char) asciiCode; // result
        return resultChar;
    }

    /**
     * Prints an ASCII code table for letters A-Z, a-z, and digits 0-9.
     */
    static void demonstrateAsciiCodes() {
        System.out.println("========================================");
        System.out.println("  CONCEPT 8 - ASCII Character Codes");
        System.out.println("========================================");

        // Fixed ranges for demonstration
        String uppercaseRange = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseRange = "abcdefghijklmnopqrstuvwxyz";
        String digitRange     = "0123456789";

        System.out.println("Uppercase letters (A-Z):");
        printAsciiTableForString(uppercaseRange);

        System.out.println("Lowercase letters (a-z):");
        printAsciiTableForString(lowercaseRange);

        System.out.println("Digit characters  (0-9):");
        printAsciiTableForString(digitRange);

        // Reverse lookup demo
        int  targetCode = 74;
        char mappedChar = getCharacterFromAscii(targetCode);
        System.out.println("\nASCII " + targetCode + " maps to character : '" + mappedChar + "'");

        // Specific char demo
        char sampleChar = 'J';
        int  sampleCode = getAsciiCode(sampleChar);
        System.out.println("Character 'J' has ASCII code     : " + sampleCode);
        System.out.println();
    }

    /**
     * Helper - prints Char : Code pairs for every character in the string.
     *
     * @param characters the string of characters to tabulate (parameter)
     */
    static void printAsciiTableForString(String characters) {
        for (int i = 0; i < characters.length(); i++) {
            char currentChar = characters.charAt(i);
            int  asciiValue  = getAsciiCode(currentChar);
            System.out.printf("  '%c'=%-4d", currentChar, asciiValue);
            if ((i + 1) % 9 == 0) System.out.println();
        }
        System.out.println();
    }

    // -----------------------------------------------------------------
    // MAIN METHOD
    // -----------------------------------------------------------------

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   STRING PRACTICE - STEP SEM 3 WEEK 1  ");
        System.out.println("==========================================");
        System.out.println();

        // Concepts 1 & 2
        demonstrateStringCreation();

        // Concept 3
        demonstrateEscapeSequences();

        // Concept 4 - Scanner input
        Scanner inputScanner = new Scanner(System.in);
        String  capturedName = readFullNameFromUser(inputScanner);

        // Concept 5
        String[] languageArray = buildLanguageArray();

        // Concept 6
        demonstrateStringAsParameter(languageArray, capturedName);

        // Concept 7
        String methodDemoString = "Hello, Java World!";
        demonstrateBuiltInMethods(methodDemoString);

        // Concept 8
        demonstrateAsciiCodes();

        inputScanner.close();

        System.out.println("==========================================");
        System.out.println("            Program Complete              ");
        System.out.println("==========================================");
    }
}
