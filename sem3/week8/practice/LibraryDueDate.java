import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    String getTitle() { return title; }

    abstract int borrowDays();

    LocalDate dueDate(LocalDate today) {
        return today.plusDays(borrowDays());
    }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }

    int borrowDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String title) { super(title); }

    int borrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }

    int borrowDays() { return 3; }
}

public class LibraryDueDate {
    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK": return new Book(title);
            case "DVD": return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    // Splits a line into tokens, keeping "quoted strings" together (quotes removed).
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (Character.isWhitespace(c) && !inQuotes) {
                if (cur.length() > 0) {
                    tokens.add(cur.toString());
                    cur.setLength(0);
                }
            } else {
                cur.append(c);
            }
        }
        if (cur.length() > 0) tokens.add(cur.toString());
        return tokens;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        while (items.size() < n && sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            List<String> t = tokenize(line);
            items.add(create(t.get(0), t.get(1)));
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(TODAY));
        }
    }
}
