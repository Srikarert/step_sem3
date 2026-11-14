import java.util.Arrays;

public class RotateRoster {
    public static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        int shift = k % n;
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            rotateRoster(new String[] {"A", "B", "C", "D", "E"}, 2)
        ));
    }
}
