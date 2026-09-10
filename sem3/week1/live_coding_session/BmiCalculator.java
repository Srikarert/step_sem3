/**
 * Program Name  : BmiCalculator
 * Class Name    : BmiCalculator
 * Description   : Day 1 Live-Coding Session - Problem 3: BMI Calculator for a Team.
 *                 Calculates BMI, classifies wellness status, and outputs a formatted table.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

public class BmiCalculator {

    public static double computeBmi(double heightMeters, double weightKg) {
        if (heightMeters <= 0 || weightKg <= 0) {
            throw new IllegalArgumentException("Height and weight must be positive numbers");
        }
        return weightKg / (heightMeters * heightMeters);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null || heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must be non-null and equal length");
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-10s | %-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double currentHeight = heights[i];
            double currentWeight = weights[i];
            double currentBmi = computeBmi(currentHeight, currentWeight);
            String status = getBmiStatus(currentBmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-10.2f | %-15s%n",
                    (i + 1), currentHeight, currentWeight, currentBmi, status);
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     CORPORATE WELLNESS PROGRAM - BMI REPORT      ");
        System.out.println("==================================================");

        double[] teamHeights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.62};
        double[] teamWeights = {70.0, 90.0, 75.0, 48.0, 82.0, 65.0, 95.0, 60.0, 58.0, 78.0};

        printWellnessReport(teamHeights, teamWeights);
    }
}