package Discount;

class ShoppingCart {
    private DiscountStrategy strategy;

    // Set the strategy at runtime
    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.calculate(price);
    }
}

