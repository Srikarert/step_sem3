/**
 * Category C — Assignment Problems
 * Problem 4: The Traffic Light
 * 
 * Scenario:
 * A traffic light cycles through red, green, and yellow, in order.
 * 
 * Problem Statement:
 * Design a TrafficLight class where the color can only move forward through its cycle,
 * never be set to an arbitrary color directly.
 * 
 * Key Requirements:
 * - The current color must be private, changed only by a next() method that moves
 *   RED -> GREEN -> YELLOW -> RED, in that order.
 * - There must be no method that sets the color directly to any value.
 * - Provide a read-only way to check the current color (getColor()).
 * - Give the light a final ID, fixed when it's created (getId()).
 * - A new light starts on RED.
 */
public class TrafficLight {
    private final String id;
    private String color;

    /**
     * Constructs a TrafficLight with an immutable identifier.
     * The initial state always begins on "RED".
     *
     * @param id the unique light identifier (e.g. "TL-9")
     */
    public TrafficLight(String id) {
        this.id = (id == null || id.trim().isEmpty()) ? "TL-UNKNOWN" : id;
        this.color = "RED"; // always starts on RED
    }

    /**
     * Advances the traffic light to the next legal state in the cycle:
     * RED -> GREEN -> YELLOW -> RED
     *
     * @return the newly active color after the transition
     */
    public String next() {
        switch (this.color) {
            case "RED":
                this.color = "GREEN";
                break;
            case "GREEN":
                this.color = "YELLOW";
                break;
            case "YELLOW":
            default:
                this.color = "RED";
                break;
        }
        return this.color;
    }

    /**
     * Returns the current light color.
     * Read-only access — no arbitrary setter exists.
     *
     * @return active color ("RED", "GREEN", or "YELLOW")
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Returns the light's final ID.
     *
     * @return light ID
     */
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TrafficLight [ID: " + id + ", Color: " + color + "]";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Traffic Light ===");

        // Sample Input/Output from Assignment
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light ID: " + t.getId());
        System.out.println("Initial state: t.getColor() -> " + t.getColor()); // RED

        System.out.println("t.next() -> " + t.next()); // GREEN
        System.out.println("t.next() -> " + t.next()); // YELLOW
        System.out.println("t.next() -> " + t.next()); // RED
        System.out.println("t.next() -> " + t.next()); // GREEN

        // Confirm state via getter matches next()
        System.out.println("Current color via t.getColor(): " + t.getColor()); // GREEN

        System.out.println("\nNotice: There is no setColor() method. The only way to change state is via next().");
    }
}
