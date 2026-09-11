/**
 * Program Name  : ArrayFundamentalsPractice
 * Class Name    : ArrayFundamentalsPractice
 * Description   : Week 4 Array Fundamentals - 6 Core Topics:
 *                 1. Creating an Array
 *                 2. Initializing an Array
 *                 3. Accessing an Array
 *                 4. Accessing Using a for Loop
 *                 5. Modifying an Array (passing to methods)
 *                 6. The length Property
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class ArrayFundamentalsPractice {

    // TOPIC 1: Creating an Array
    public static void demonstrateCreatingArray() {
        System.out.println("=======================================");
        System.out.println("  TOPIC 1: CREATING AN ARRAY");
        System.out.println("========================================");
        int[] numbers = new int[5];
        String[] names = new String[3];

        System.out.println("Default values in new int[5]    : " + Arrays.toString(numbers));
        System.out.println("Default values in new String[3] : " + Arrays.toString(names));
        System.out.println();
    }

    // TOPIC 2: Initializing an Array
    public static void demonstrateInitializingArray() {
        System.out.println("=======================================");
        System.out.println("  TOPIC 2: INITIALIZING AN ARRAY");
        System.out.println("=======================================");
        int[] declaredLiteral = {10, 20, 30, 40, 50};
        int[] populatedIndex = new int[3];
        populatedIndex[0] = 100;
        populatedIndex[1] = 200;
        populatedIndex[2] = 300;

        System.out.println("Initialized via literal {}       : " + Arrays.toString(declaredLiteral));
        System.out.println("Initialized via index assignment: " + Arrays.toString(populatedIndex));
        System.out.println();
    }

    // TOPIC 3: Accessing an Array
    public static void demonstrateAccessingArray() {
        System.out.println("=======================================");
        System.out.println("  TOPIC 3: ACCESSING AN ARRAY");
        System.out.println("=======================================");
        String[] courses = {"Java", "Python", "Data Structures", "Algorithms" };

        System.out.println("First element (courses[0])  : " + courses[0]);
        System.out.println("Second element (courses[1]) : " + courses[1]);
        System.out.println("Last element (courses[3])   : " + courses[3]);
        System.out.println();
    }

    // TOPIC 4: Accessing Using a for Loop
    public static void demonstrateForLoopAccess() {
        System.out.println("=======================================");
        System.out.println("  TOPIC 4: ACCESSING VIA FOR LOOP");
        System.out.println("========================================");
        int[] scores = {85, 90, 78, 92, 88};

        System.out.println("Standard for loop:");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Score [%d] = %d | ", i, scores[i]);
        }
        System.out.println("\n\nEnhanced for-each loop:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\n");
    }

    // TOPIC 5: Modifying an Array (Passing to a Method)
    public static void modifyArray(int[] arrayToDouble) {
        for (int i = 0; i < arrayToDouble.length; i++) {
            arrayToDouble[i] *= 2;
        }
    }

    public static void demonstrateModifyingArray() {
        System.out.println("=======================================");
        System.out.println("  TOPIC 5: MODIFYING AN ARRAY");
        System.out.println("=======================================");
        int[] original = {1, 2, 3, 4};
        System.out.println("Before modifyArray() : " + Arrays.toString(original));
        modifyArray(original);
        System.out.println("After modifyArray()   : " + Arrays.toString(original) + " (Arrays are passed by reference!)");
        System.out.println();
    }

    // TOPIC 6: The length Property
    public static void demonstrateLengthProperty() {
        System.out.println("========================================");
        System.out.println("  TOPIC 6: THE length PROPERTY");
        System.out.println("=======================================");
        double[] temperatures = {36.6, 37.0, 36.8, 38.1, 36.5, 37.5};
        System.out.println("Temperatures array : " + Arrays.toString(temperatures));
        System.out.println("Length property is  : " + temperatures.length);
        System.out.println("Valid index range   : 0 to " + (temperatures.length - 1));
        System.out.println();
    }

    public static void main(String[] args) {
        demonstrateCreatingArray();
        demonstrateInitializingArray();
        demonstrateAccessingArray();
        demonstrateForLoopAccess();
        demonstrateModifyingArray();
        demonstrateLengthProperty();
    }
}