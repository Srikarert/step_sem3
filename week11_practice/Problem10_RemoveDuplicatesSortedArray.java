package week11_practice;

public class Problem10_RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIndex = 1;

        for (int readIndex = 1; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 1]) {
                nums[writeIndex] = nums[readIndex];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 5};

        int length = removeDuplicates(nums);
        System.out.println("length = " + length);

        System.out.print("nums[0.." + (length - 1) + "] = [");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + (i < length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
