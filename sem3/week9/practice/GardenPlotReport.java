import java.util.*;

abstract class Plot {
    protected final String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    String getOwner() { return owner; }

    abstract String getShape();

    abstract double area();
}

class CirclePlot extends Plot {
    private final double radius;

    CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    String getShape() { return "CIRCLE"; }

    double area() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private final double length;
    private final double width;

    RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    String getShape() { return "RECTANGLE"; }

    double area() { return length * width; }
}

class TrianglePlot extends Plot {
    private final double base;
    private final double height;

    TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    String getShape() { return "TRIANGLE"; }

    double area() { return 0.5 * base * height; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();
            switch (shape) {
                case "CIRCLE":
                    plots.add(new CirclePlot(owner, sc.nextDouble()));
                    break;
                case "RECTANGLE": {
                    double l = sc.nextDouble();
                    double w = sc.nextDouble();
                    plots.add(new RectanglePlot(owner, l, w));
                    break;
                }
                case "TRIANGLE": {
                    double b = sc.nextDouble();
                    double h = sc.nextDouble();
                    plots.add(new TrianglePlot(owner, b, h));
                    break;
                }
                default: throw new IllegalArgumentException("Unknown shape: " + shape);
            }
        }

        // Reporting code only knows about Plot, so new shapes need no changes here.
        double total = 0;
        for (Plot p : plots) {
            double a = p.area();
            System.out.printf("%s (%s): %.2f%n", p.getOwner(), p.getShape(), a);
            total += a;
        }
        System.out.printf("Total Area: %.2f%n", total);
    }
}
