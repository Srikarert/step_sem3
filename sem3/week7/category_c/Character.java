/**
 * Category C — Assignment Problems
 * Problem 1: The Health Bar
 * 
 * Scenario:
 * A game character has health that changes during battle.
 * 
 * Problem Statement:
 * Design a Character class where health can never drop below 0 or rise above its maximum,
 * and can't be set directly from outside.
 * 
 * Key Requirements:
 * - Health must be private, changed only through takeDamage(int amount) and heal(int amount).
 * - Health must never go below 0 (extra damage is wasted) or above maximum (extra healing is wasted).
 * - The maximum health must be final, fixed when the character is created.
 * - Provide a read-only way to check current health (getHealth()) — no setter for it.
 */
public class Character {
    private final int maxHealth;
    private int health;

    /**
     * Constructs a Character with a fixed maximum health.
     * The character starts with full health (health == maxHealth).
     *
     * @param maxHealth the maximum health capacity (must be positive)
     */
    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            this.maxHealth = 100; // safe fallback default
        } else {
            this.maxHealth = maxHealth;
        }
        this.health = this.maxHealth;
    }

    /**
     * Inflicts damage on the character.
     * Health drops by the amount, clamped at a minimum of 0.
     * Negative damage values are ignored to prevent accidental healing.
     *
     * @param amount the damage to inflict
     */
    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    /**
     * Heals the character.
     * Health rises by the amount, clamped at the maximum health.
     * Negative healing values are ignored to prevent accidental damage.
     *
     * @param amount the health amount to restore
     */
    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    /**
     * Returns the character's current health.
     * Read-only access — no public setter exists.
     *
     * @return current health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns the character's maximum health.
     *
     * @return maximum health
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public String toString() {
        return "Character [Health: " + health + "/" + maxHealth + "]";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Health Bar ===");

        // Sample Input/Output from Assignment
        Character c = new Character(100);
        System.out.println("Initial health: " + c.getHealth() + " (Max: " + c.getMaxHealth() + ")");

        c.takeDamage(30);
        System.out.println("c.takeDamage(30)  -> health = " + c.getHealth()); // Expected: 70

        c.heal(50);
        System.out.println("c.heal(50)        -> health = " + c.getHealth() + " (capped)"); // Expected: 100

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getHealth() + " (floored)"); // Expected: 0

        // Additional edge case validations
        System.out.println("\nTesting Boundary & Negative Guards:");
        c.heal(20);
        System.out.println("c.heal(20)        -> health = " + c.getHealth()); // Expected: 20
        c.takeDamage(-10); // Negative damage ignored
        System.out.println("c.takeDamage(-10) -> health = " + c.getHealth() + " (no negative damage cheat)");
        c.heal(-10); // Negative heal ignored
        System.out.println("c.heal(-10)       -> health = " + c.getHealth() + " (no negative heal cheat)");
    }
}
