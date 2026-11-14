package week11_assignment;

public class Problem4_IsTheQueueInOrder {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(tokens1));

        int[] tokens2 = {1, 2, 2, 7};
        System.out.println(firstBreak(tokens2));
    }
}

