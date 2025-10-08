package Discount;

public class ECommerce {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        double price = 1000;

        // Flat Discount
        cart.setStrategy(new FlatDiscount());
        System.out.println("Flat Discount Price: " + cart.calculatePrice(price));

        // BOGO Discount
        cart.setStrategy(new BOGODiscount());
        System.out.println("BOGO Discount Price: " + cart.calculatePrice(price));

        // Seasonal Discount
        cart.setStrategy(new SeasonalDiscount());
        System.out.println("Seasonal Discount Price: " + cart.calculatePrice(price));
    }
}
