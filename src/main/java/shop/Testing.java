package shop;

public class Testing {

    public static void main(String[] args) {

        DiscountThreeForTwo discountThreeForTwo = new DiscountThreeForTwo();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Milk"), 9.99, 2));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Bread"), 3.0, 3));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Butter"), 44.95, 1));
        shoppingCart.addCartItem(new ShoppingCartItem(new Product("Marmalade"), 2.95, 3));

        System.out.println(discountThreeForTwo.calculateDiscount(shoppingCart));
    }

}
