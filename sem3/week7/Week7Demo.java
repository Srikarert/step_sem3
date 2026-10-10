import java.util.Arrays;

/**
 * Master demonstration driver for STEP SEM-3 Week 7:
 * Encapsulation & Access Control (Category C Assignment Problems).
 * 
 * Demonstrates:
 * 1. The Health Bar (Character) — Data Hiding & Clamped Boundary Control
 * 2. The Playlist (Playlist) — Defensive Copying & Immutability of Returned Data
 * 3. The Password Checker (PasswordChecker) — Write-Only / Secret Encapsulation
 * 4. The Traffic Light (TrafficLight) — State Transition Enforcement via Controlled Methods
 * 5. The Shopping Cart (Cart) — On-Demand Computation & Hidden Price Array
 */
public class Week7Demo {
    public static void main(String[] args) {
        printHeader("STEP SEM-3 · Week 7 · Encapsulation & Access Control Demo");

        // -------------------------------------------------------------
        // PROBLEM 1: The Health Bar
        // -------------------------------------------------------------
        printSection(1, "The Health Bar — Boundary Validation & Data Hiding");
        Character character = new Character(100);
        System.out.println("Character created with maxHealth = 100.");
        System.out.println("Initial health: " + character.getHealth());

        character.takeDamage(30);
        System.out.println("c.takeDamage(30)  -> current health: " + character.getHealth() + " (Expected: 70)");

        character.heal(50);
        System.out.println("c.heal(50)        -> current health: " + character.getHealth() + " (Expected: 100 capped)");

        character.takeDamage(150);
        System.out.println("c.takeDamage(150) -> current health: " + character.getHealth() + " (Expected: 0 floored)");

        // -------------------------------------------------------------
        // PROBLEM 2: The Playlist
        // -------------------------------------------------------------
        printSection(2, "The Playlist — Defensive Copying of Array Data");
        Playlist playlist = new Playlist(10);
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        System.out.println("Added 'Song A' and 'Song B'. Song count: " + playlist.getSongCount());

        String[] songsCopy = playlist.getSongs();
        System.out.println("Retrieved safe copy: " + Arrays.toString(songsCopy));

        System.out.println("Simulating external mutation attack: songsCopy[0] = 'Hacked'...");
        songsCopy[0] = "Hacked";
        System.out.println("External array modified: " + Arrays.toString(songsCopy));
        System.out.println("Internal playlist via getSongs(): " + Arrays.toString(playlist.getSongs()));
        System.out.println("Defensive copy verified: " + ("Song A".equals(playlist.getSongs()[0]) ? "PASSED" : "FAILED"));

        // -------------------------------------------------------------
        // PROBLEM 3: The Password Checker
        // -------------------------------------------------------------
        printSection(3, "The Password Checker — Write-Only / Secret Encapsulation");
        PasswordChecker pcWeak = new PasswordChecker("abcd");
        System.out.println("Password 'abcd' (len 4)            -> Strength: " + pcWeak.getStrength() + " (Expected: Weak)");

        PasswordChecker pcMedium = new PasswordChecker("abcdefgh");
        System.out.println("Password 'abcdefgh' (len 8)        -> Strength: " + pcMedium.getStrength() + " (Expected: Medium)");

        PasswordChecker pcStrong = new PasswordChecker("abcdefghij");
        System.out.println("Password 'abcdefghij' (len 10)     -> Strength: " + pcStrong.getStrength() + " (Expected: Strong)");
        System.out.println("Password confidentiality: No getter exposes the password field!");

        // -------------------------------------------------------------
        // PROBLEM 4: The Traffic Light
        // -------------------------------------------------------------
        printSection(4, "The Traffic Light — Controlled State Transition");
        TrafficLight trafficLight = new TrafficLight("TL-9");
        System.out.println("TrafficLight initialized with ID: " + trafficLight.getId());
        System.out.println("Initial color: " + trafficLight.getColor() + " (Expected: RED)");

        System.out.println("trafficLight.next() -> " + trafficLight.next() + " (Expected: GREEN)");
        System.out.println("trafficLight.next() -> " + trafficLight.next() + " (Expected: YELLOW)");
        System.out.println("trafficLight.next() -> " + trafficLight.next() + " (Expected: RED)");
        System.out.println("trafficLight.next() -> " + trafficLight.next() + " (Expected: GREEN)");
        System.out.println("Direct color change prevented: Only next() advances state!");

        // -------------------------------------------------------------
        // PROBLEM 5: The Shopping Cart
        // -------------------------------------------------------------
        printSection(5, "The Shopping Cart — On-Demand Computation & Information Hiding");
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("cart.getTotal()     -> " + (long) cart.getTotal() + " (Expected: 500)");
        System.out.println("cart.getItemCount() -> " + cart.getItemCount() + " (Expected: 3)");
        System.out.println("No prices array getter exists: Individual price list cannot be altered or read directly.");

        printHeader("All Week 7 Assignment Problems Executed Successfully!");
    }

    private static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(75));
        System.out.println("  " + title);
        System.out.println("=".repeat(75));
    }

    private static void printSection(int number, String title) {
        System.out.println("\n" + "-".repeat(75));
        System.out.println(" [PROBLEM " + number + "] " + title);
        System.out.println("-".repeat(75));
    }
}
