interface DiscountStrategy {
    double applyDiscount(double price, int quantity);
}

class FlatDiscount implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        return price * quantity * 0.9; // 10% off
    }
}

class BuyOneGetOne implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        int freeItems = quantity / 2; // for every 2 items, 1 is free
        return price * (quantity - freeItems);
    }
}

class SeasonalDiscount implements DiscountStrategy {
    public double applyDiscount(double price, int quantity) {
        return price * quantity * 0.8; // 20% off
    }
}

class ShoppingCart {
    private DiscountStrategy discountStrategy;

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculatePrice(double price, int quantity) {
        if (discountStrategy == null) {
            return price * quantity; // No discount
        }
        return discountStrategy.applyDiscount(price, quantity);
    }
}

// Main Class 
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setDiscountStrategy(new FlatDiscount());
        System.out.println("Flat 10% Discount: " + cart.calculatePrice(100, 3));

        cart.setDiscountStrategy(new BuyOneGetOne());
        System.out.println("Buy 1 Get 1: " + cart.calculatePrice(100, 3));

        cart.setDiscountStrategy(new SeasonalDiscount());
        System.out.println("Seasonal 20% Discount: " + cart.calculatePrice(100, 3));
    }
}
