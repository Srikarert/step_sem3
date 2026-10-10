import java.util.*;

abstract class BorrowedItem {
    protected final String title;
    protected final int daysLate;

    BorrowedItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    String getTitle() { return title; }

    abstract double fine();
}

class BookItem extends BorrowedItem {
    BookItem(String title, int daysLate) { super(title, daysLate); }

    double fine() { return 2.0 * daysLate; }
}

class DvdItem extends BorrowedItem {
    private static final double MAX_FINE = 50;

    DvdItem(String title, int daysLate) { super(title, daysLate); }

    double fine() { return Math.min(MAX_FINE, 5.0 * daysLate); }
}

class MagazineItem extends BorrowedItem {
    MagazineItem(String title, int daysLate) { super(title, daysLate); }

    double fine() { return 1.0 * daysLate; }
}

public class LibraryLateFine {
    static BorrowedItem create(String type, String title, int daysLate) {
        switch (type.toUpperCase()) {
            case "BOOK": return new BookItem(title, daysLate);
            case "DVD": return new DvdItem(title, daysLate);
            case "MAGAZINE": return new MagazineItem(title, daysLate);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<BorrowedItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();
            items.add(create(type, title, daysLate));
        }

        double total = 0;
        for (BorrowedItem item : items) {
            double f = item.fine();
            System.out.printf("%s: %.2f%n", item.getTitle(), f);
            total += f;
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
