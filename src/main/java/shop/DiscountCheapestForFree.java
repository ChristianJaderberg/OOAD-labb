package shop;

import java.math.BigDecimal;

public class DiscountCheapestForFree implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {

        BigDecimal discountAmount = BigDecimal.ZERO;
        int qualifyingAmount = 6;
        ShoppingCartItem[] items = shoppingCart.stream().toArray(ShoppingCartItem[]::new);

        if (items.length >= qualifyingAmount) {
            BigDecimal min = items[0].itemCost();
            for (ShoppingCartItem item:items) {
                if (item.itemCost().doubleValue() < min.doubleValue()) {
                    min = item.itemCost();
                }
            }
            discountAmount = min;
        }

        return discountAmount;
    }
}
