public class TrafficLight {
    private static final String RED = "RED";
    private static final String GREEN = "GREEN";
    private static final String YELLOW = "YELLOW";

    private String currentColor;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = RED;
    }

    public void next() {
        if (currentColor.equals(RED)) {
            currentColor = GREEN;
        } else if (currentColor.equals(GREEN)) {
            currentColor = YELLOW;
        } else {
            currentColor = RED;
        }
    }

    public String getColor() {
        return currentColor;
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Start: " + t.getColor());
        t.next();
        System.out.println("After next 1: " + t.getColor());
        t.next();
        System.out.println("After next 2: " + t.getColor());
        t.next();
        System.out.println("After next 3: " + t.getColor());
        t.next();
        System.out.println("After next 4: " + t.getColor());
    }
}
