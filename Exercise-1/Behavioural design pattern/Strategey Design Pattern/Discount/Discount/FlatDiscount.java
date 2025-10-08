package Discount;

class FlatDiscount implements DiscountStrategy {
    public double calculate(double price) {
        return price * 0.9; // 10% discount
    }
}
