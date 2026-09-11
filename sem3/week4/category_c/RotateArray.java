/**
 * Program Name  : RotateArray
 * Class Name    : RotateArray
 * Description   : Category C - L5: Rotate Array.
 *                 Rotates array to the right by k positions using modulo arithmetic.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }

        int[] rotatedArray = new int[n];

        for (int i = 0; i < n; i++) {
            rotatedArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = rotatedArray[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("            CATEGORY C - L5: ROTATE ARRAY        ");
        System.out.println("==================================================\n");

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        int[] result1 = rotateArray(nums1, k1);
        System.out.println("Output: " + Arrays.toString(result1) + " (expected [5, 6, 7, 1, 2, 3, 4])");
        System.out.println("------------------------------------------------");

        int[] nums2 = {1, 2};
        int k2 = 3;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        int[] result2 = rotateArray(nums2, k2);
        System.out.println("Output: " + Arrays.toString(result2) + " (expected [2, 1])");
    }
}