public class CountInBand {
    public static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    private static int firstAtLeast(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (scores[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    private static int firstGreaterThan(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (scores[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(countInBand(
            new int[] {35, 42, 42, 50, 58, 58, 58, 63, 71, 88},
            42,
            58
        ));
    }
}
