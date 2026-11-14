package week11_practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3_TransactionDuplicateCheck {

    public static boolean hasDuplicate(List<String> transactionIds) {
        if (transactionIds == null || transactionIds.size() <= 1) {
            return false;
        }

        Set<String> seen = new HashSet<>((int) (transactionIds.size() / 0.75f) + 1);

        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasDuplicate(String[] transactionIds) {
        if (transactionIds == null || transactionIds.length <= 1) {
            return false;
        }
        return hasDuplicate(Arrays.asList(transactionIds));
    }

    public static void main(String[] args) {
        List<String> batch1 = List.of("TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004");
        System.out.println(hasDuplicate(batch1));

        List<String> batch2 = List.of("TXN2001", "TXN2002", "TXN2003");
        System.out.println(hasDuplicate(batch2));
    }
}
