package Discount;

class SeasonalDiscount implements DiscountStrategy {
    public double calculate(double price) {
        return price * 0.8; // 20% discount
    }
}
