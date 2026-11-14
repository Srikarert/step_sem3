package week11_practice;

import java.util.HashSet;
import java.util.Set;

public class Problem5_PairWithTargetSumUnsorted {

    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSum(nums1, 9));

        int[] nums2 = {3, 4, 6};
        System.out.println(hasPairWithSum(nums2, 20));
    }
}
