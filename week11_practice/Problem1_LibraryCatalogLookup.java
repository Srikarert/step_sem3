package week11_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1_LibraryCatalogLookup {

    public record BookRecord(String isbn, String title) {
    }

    /**
     * Searches for a book by its ISBN using binary search.
     * 
     * @param catalog    List of BookRecord sorted in ascending order by ISBN.
     * @param targetIsbn The ISBN string to search for.
     * @return The title of the book if found; otherwise "Not Found".
     */
    public static String findBook(List<BookRecord> catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null || catalog.isEmpty()) {
            return "Not Found";
        }

        int low = 0;
        int high = catalog.size() - 1;

        while (low <= high) {
            // Avoid potential integer overflow
            int mid = low + (high - low) / 2;
            BookRecord midRecord = catalog.get(mid);
            int comparison = midRecord.isbn().compareTo(targetIsbn);

            if (comparison == 0) {
                return midRecord.title(); // Found
            } else if (comparison < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }

        return "Not Found"; // Target ISBN does not exist in the catalog
    }

    /**
     * Overloaded method to support array inputs.
     */
    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        if (catalog == null)
            return "Not Found";
        return findBook(Arrays.asList(catalog), targetIsbn);
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: Library Catalog Lookup ---");

        List<BookRecord> catalog = new ArrayList<>(List.of(
                new BookRecord("0001112223", "Introduction to Algebra"),
                new BookRecord("0002223334", "Beginning Python"),
                new BookRecord("0003334445", "Classic Mythology"),
                new BookRecord("0004445556", "Data and Society"),
                new BookRecord("0005556667", "European History")));

        // Test Case 1: Existing ISBN
        String target1 = "0003334445";
        String result1 = findBook(catalog, target1);
        System.out.println("Query: " + target1 + " -> Output: \"" + result1 + "\" (Expected: \"Classic Mythology\")");

        // Test Case 2: Non-existing ISBN
        String target2 = "0009998887";
        String result2 = findBook(catalog, target2);
        System.out.println("Query: " + target2 + " -> Output: \"" + result2 + "\" (Expected: \"Not Found\")");

        // Edge Case 3: Search first element
        String target3 = "0001112223";
        System.out.println("Query: " + target3 + " -> Output: \"" + findBook(catalog, target3)
                + "\" (Expected: \"Introduction to Algebra\")");

        // Edge Case 4: Search last element
        String target4 = "0005556667";
        System.out.println("Query: " + target4 + " -> Output: \"" + findBook(catalog, target4)
                + "\" (Expected: \"European History\")");

        // Edge Case 5: Empty catalog
        System.out.println("Empty Catalog Query -> Output: \"" + findBook(new ArrayList<>(), "0001112223")
                + "\" (Expected: \"Not Found\")");
    }
}
