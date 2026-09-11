/**
 * Program Name  : TwoSum
 * Class Name    : TwoSum
 * Description   : Category C - L1: Two Sum.
 *                 Finds indices of two numbers that add up to a target using nested loops.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("             CATEGORY C - L1: TWO SUM               ");
        System.out.println("==================================================\n");

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(result1) + " (expected [0, 1])");
        System.out.println("-------------------------------------------------");

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(result2) + " (expected [1, 2])");
    }
}