package week11_assignment;

import java.util.Arrays;

public class Problem1_TheHeightLineUp {

    public static void lineUp(int[] heights) {
        if (heights == null || heights.length <= 1) {
            if (heights != null) {
                System.out.println("Pass 1: " + Arrays.toString(heights));
            }
            return;
        }

        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + Arrays.toString(heights));
            pass++;

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);
        System.out.println();

        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);
        System.out.println();

        int[] heights3 = {64, 34, 25, 12, 22, 11, 90};
        lineUp(heights3);
    }
}

