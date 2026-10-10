public class Cart {
    private final double[] itemPrices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.itemPrices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < itemPrices.length && price > 0) {
            itemPrices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());

        Cart cart2 = new Cart("CART-6", 10);
        cart2.addItem(10.5);
        cart2.addItem(20.5);
        cart2.addItem(30.0);
        System.out.println("Cart2 total: " + cart2.getTotal() + ", items: " + cart2.getItemCount());
    }
}
