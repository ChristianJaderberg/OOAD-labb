package shop;

import java.math.BigDecimal;

public class DiscountThreeForTwo implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {

        BigDecimal discountAmount = BigDecimal.ZERO;
        ShoppingCartItem[] items = shoppingCart.stream().toArray(ShoppingCartItem[]::new);

        for (ShoppingCartItem item:items) {
            if (item.quantity() == 3) {
                discountAmount = discountAmount.add(item.itemCost());
            }
        }

        return discountAmount;
    }
}
