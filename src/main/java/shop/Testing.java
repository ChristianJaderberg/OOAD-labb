package shop;

public class Testing {

    public static void main(String[] args) {

        System.out.println("3 for 2 Discount (only once per product):");

        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.addCartItem(new ShoppingCartItem(new Product("Milk"), 9.99, 2));
        shoppingCart1.addCartItem(new ShoppingCartItem(new Product("Bread"), 3.0, 3));
        shoppingCart1.addCartItem(new ShoppingCartItem(new Product("Butter"), 44.95, 1));
        shoppingCart1.addCartItem(new ShoppingCartItem(new Product("Marmalade"), 2.95, 3));

        System.out.println("TOTAL: " + shoppingCart1.calculatePrice());
        System.out.println("DISCOUNT: " + shoppingCart1.calculateDiscount());
        System.out.println("TOTAL WITH DISCOUNT: " + shoppingCart1.calculatePriceWithDiscount());

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println();


        System.out.println("Ten Percent Discount:");

        ShoppingCart shoppingCart2 = new ShoppingCart();
        shoppingCart2.addCartItem(new ShoppingCartItem(new Product("Microwave Oven"), 99.99, 2));
        shoppingCart2.addCartItem(new ShoppingCartItem(new Product("Sniper Rifle"), 252.0, 2));

        System.out.println("TOTAL: " + shoppingCart2.calculatePrice());
        System.out.println("DISCOUNT: " + shoppingCart2.calculateDiscount());
        System.out.println("TOTAL WITH DISCOUNT: " + shoppingCart2.calculatePriceWithDiscount());

        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println();


        System.out.println("Cheapest for free Discount:");

        ShoppingCart shoppingCart3 = new ShoppingCart();
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Milk"), 5.99, 2));
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Bread"), 7.99, 1));
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Soda"), 9.5, 1));
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Blanket"), 22.0, 1));
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Sodastreamer"), 99.99, 1));
        shoppingCart3.addCartItem(new ShoppingCartItem(new Product("Bicycle"), 223.0, 1));

        System.out.println("TOTAL: " + shoppingCart3.calculatePrice());
        System.out.println("DISCOUNT: " + shoppingCart3.calculateDiscount());
        System.out.println("TOTAL WITH DISCOUNT: " + shoppingCart3.calculatePriceWithDiscount());


        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println();


        System.out.println("REDO/UNDO-TESTING:");

        ShoppingCart shoppingCart4 = new ShoppingCart();
        shoppingCart4.addCartItem(new ShoppingCartItem(new Product("Milk"), 5.99, 2));
        shoppingCart4.addCartItem(new ShoppingCartItem(new Product("Bread"), 7.99, 1));
        shoppingCart4.addCartItem(new ShoppingCartItem(new Product("Soda"), 9.5, 1));
        printCartState(shoppingCart4);
        shoppingCart4.undo();
        printCartState(shoppingCart4);
        shoppingCart4.redo();
        printCartState(shoppingCart4);
        shoppingCart4.undo();
        shoppingCart4.undo();
        shoppingCart4.undo();
        shoppingCart4.redo();
        shoppingCart4.redo();
        shoppingCart4.redo();


        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        System.out.println();


        System.out.println("REMOVE/CHANGE-TESTING:");

        ShoppingCart shoppingCart5 = new ShoppingCart();
        shoppingCart5.addCartItem(new ShoppingCartItem(new Product("Milk"), 9.99, 2));
        shoppingCart5.addCartItem(new ShoppingCartItem(new Product("Bread"), 3.0, 3));
        shoppingCart5.addCartItem(new ShoppingCartItem(new Product("Butter"), 44.95, 1));
        shoppingCart5.addCartItem(new ShoppingCartItem(new Product("Marmalade"), 2.95, 3));

        System.out.println(shoppingCart5.receipt());
        shoppingCart5.removeCartItem("Bread");
        System.out.println(shoppingCart5.receipt());
        shoppingCart5.changeItemQuantity("Marmalade", 1);
        System.out.println(shoppingCart5.receipt());
        shoppingCart5.undo();
        System.out.println(shoppingCart5.receipt());

    }

    public static void printCartState(ShoppingCart shoppingCart) {
        System.out.println("CURRENT CART STATE:");
        System.out.println(shoppingCart.receipt());
    }

}
