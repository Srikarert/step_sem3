/**
 * Category C — Assignment Problems
 * Problem 5: The Shopping Cart
 * 
 * Scenario:
 * An online store's cart holds the prices of items you're about to buy.
 * 
 * Problem Statement:
 * Design a Cart class that stores item prices internally but only exposes the total and item count
 * — never direct access to the prices themselves.
 * 
 * Key Requirements:
 * - Store item prices in a private array (fixed maximum number of items).
 * - Provide a method to add an item's price to the cart (addItem).
 * - Provide a read-only total (sum of all prices) and a read-only item count:
 *     - Computed on request, not stored separately.
 * - Give the cart a final cart ID, fixed when it's created.
 * - There is no method that returns the array of individual prices.
 */
public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    /**
     * Constructs a Cart with an immutable identifier and max item capacity.
     *
     * @param cartId unique identifier for this shopping cart
     * @param maxItems maximum number of items this cart can hold
     */
    public Cart(String cartId, int maxItems) {
        this.cartId = (cartId == null || cartId.trim().isEmpty()) ? "CART-DEFAULT" : cartId;
        if (maxItems <= 0) {
            maxItems = 10; // default fallback capacity
        }
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    /**
     * Adds an item's price to the cart.
     * Only valid non-negative prices are accepted, as long as capacity allows.
     *
     * @param price price of the item
     * @return true if added, false if the cart is full or price is negative
     */
    public boolean addItem(double price) {
        if (price < 0) {
            return false; // Reject negative prices
        }
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
            return true;
        }
        return false; // Cart capacity reached
    }

    /**
     * Computes and returns the total sum of all item prices currently in the cart.
     * The total is calculated fresh on request rather than stored separately.
     *
     * @return sum of all item prices
     */
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    /**
     * Returns the number of items currently in the cart.
     *
     * @return item count
     */
    public int getItemCount() {
        return this.itemCount;
    }

    /**
     * Returns the cart's immutable identifier.
     *
     * @return cartId
     */
    public String getCartId() {
        return this.cartId;
    }

    /**
     * Returns the maximum capacity of items this cart can hold.
     *
     * @return maxItems capacity
     */
    public int getCapacity() {
        return this.prices.length;
    }

    @Override
    public String toString() {
        return "Cart [ID: " + cartId + ", Items: " + itemCount + "/" + prices.length + ", Total: " + getTotal() + "]";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Shopping Cart ===");

        // Sample Input/Output from Assignment
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("cart.getTotal()     -> " + formatPrice(cart.getTotal())); // Expected: 500
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());          // Expected: 3

        // Adding another item
        cart.addItem(75.50);
        System.out.println("\nAfter adding 75.50:");
        System.out.println("cart.getTotal()     -> " + formatPrice(cart.getTotal())); // Expected: 575.5
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());          // Expected: 4

        System.out.println("\nNotice: There is no getPrices() method. Internal prices cannot be leaked or edited!");
    }

    private static String formatPrice(double price) {
        if (price == (long) price) {
            return String.valueOf((long) price);
        }
        return String.valueOf(price);
    }
}
