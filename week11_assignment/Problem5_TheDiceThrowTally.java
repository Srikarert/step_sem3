package week11_assignment;

import java.util.Arrays;

public class Problem5_TheDiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        int[] counts = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                counts[roll]++;
            }
        }

        StringBuilder sb = new StringBuilder("Counts:");
        for (int i = 1; i <= 6; i++) {
            sb.append(" ").append(i).append(":").append(counts[i]);
        }
        System.out.println(sb);

        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int i = 1; i <= 6; i++) {
            while (counts[i] > 0) {
                sorted[index++] = i;
                counts[i]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}

