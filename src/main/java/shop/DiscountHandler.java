package shop;

import java.math.BigDecimal;

public class DiscountHandler {

    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {

        BigDecimal discountAmount = BigDecimal.ZERO;

        DiscountThreeForTwo discountThreeForTwo = new DiscountThreeForTwo();
        DiscountTenPercent discountTenPercent = new DiscountTenPercent();
        DiscountCheapestForFree discountCheapestForFree = new DiscountCheapestForFree();

        discountAmount = discountAmount.add(discountThreeForTwo.calculateDiscount(shoppingCart));
        discountAmount = discountAmount.add(discountTenPercent.calculateDiscount(shoppingCart));
        discountAmount = discountAmount.add(discountCheapestForFree.calculateDiscount(shoppingCart));

        return discountAmount;
    }

}
