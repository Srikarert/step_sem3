/**
 * Program Name  : ContainsDuplicate
 * Class Name    : ContainsDuplicate
 * Description   : Category C - L3: Contains Duplicate.
 *                 Checks for duplicates using nested loops with early exit.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("           CATEGORY C - L3: CONTAINS DUPLICATE      ");
        System.out.println("==================================================\n");

        int[] nums1 = {1, 2, 3, 1};
        boolean hasDuplicate1 = containsDuplicate(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + hasDuplicate1 + " (expected true)");
        System.out.println("------------------------------------------------");

        int[] nums2 = {1, 2, 3, 4};
        boolean hasDuplicate2 = containsDuplicate(nums2);
        System.out.println("Input: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + hasDuplicate2 + " (expected false)");
    }
}