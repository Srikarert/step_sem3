/**
 * Program Name  : MergeTwoSortedArrays
 * Class Name    : MergeTwoSortedArrays
 * Description   : Category C - L4: Merge Two Sorted Arrays.
 *                 Two-pointer sorted merge without re-sorting.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] safeArr1 = (arr1 != null) ? arr1 : new int[0];
        int[] safeArr2 = (arr2 != null) ? arr2 : new int[0];

        int len1 = safeArr1.length;
        int len2 = safeArr2.length;
        int[] mergedArray = new int[len1 + len2];

        int pointer1 = 0;
        int pointer2 = 0;
        int mergedIndex = 0;

        while (pointer1 < len1 && pointer2 < len2) {
            if (safeArr1[pointer1] <= safeArr2[pointer2]) {
                mergedArray[mergedIndex++] = safeArr1[pointer1++];
            } else {
                mergedArray[mergedIndex++] = safeArr2[pointer2++];
            }
        }

        while (pointer1 < len1) {
            mergedArray[mergedIndex++] = safeArr1[pointer1++];
        }

        while (pointer2 < len2) {
            mergedArray[mergedIndex++] = safeArr2[pointer2++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("       CATEGORY C - L4: MERGE TWO SORTED ARRAYS  ");
        System.out.println("==================================================\n");

        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] result1 = mergeSortedArrays(arr1, arr2);
        System.out.println("Input: arr1 = " + Arrays.toString(arr1) + ", arr2 = " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(result1) + " (expected [1, 2, 3, 4, 5, 6])");
        System.out.println("------------------------------------------------");

        int[] arr3 = {};
        int[] arr4 = {1, 2, 3};
        int[] result2 = mergeSortedArrays(arr3, arr4);
        System.out.println("Input: arr1 = " + Arrays.toString(arr3) + ", arr2 = " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(result2) + " (expected [1, 2, 3])");
    }
}