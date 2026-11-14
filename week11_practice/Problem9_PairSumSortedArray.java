package week11_practice;

public class Problem9_PairSumSortedArray {

    public record Pair(int first, int second) {
        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static String pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return "Not Found";
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            long currentSum = (long) nums[left] + nums[right];

            if (currentSum == target) {
                return new Pair(nums[left], nums[right]).toString();
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        int[] nums1 = {-4, -1, 0, 3, 5, 9};
        System.out.println(pairSumSorted(nums1, 4));

        int[] nums2 = {1, 2, 3};
        System.out.println(pairSumSorted(nums2, 100));
    }
}
