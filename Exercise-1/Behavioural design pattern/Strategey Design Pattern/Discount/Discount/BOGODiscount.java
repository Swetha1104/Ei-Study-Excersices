package Discount;

class BOGODiscount implements DiscountStrategy {
    public double calculate(double price) {
        // Assume 2 items for simplicity
        return price / 2; // Buy 1 Get 1 free
    }
}
