/**
 * Category C - Problem M4: Library ID Card Management
 * 
 * Scenario:
 * Two "different" variables in a script both claim to represent Ravi's library card,
 * but only one of them is actually real. Prove reference equality and aliasing with code.
 */
class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class LibraryIdCardManagement {
    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // points to the same object reference
        duplicate.booksIssued = 3;

        IdCard separate = new IdCard("Ravi", 3); // separate object in heap

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
