package shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DiscountTenPercent implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {

        BigDecimal discountAmount = BigDecimal.ZERO;
        double qualifyingAmount = 500.0;
        BigDecimal discountRate = new BigDecimal("0.1");

        if (shoppingCart.calculatePrice().doubleValue() > qualifyingAmount) {
            discountAmount = shoppingCart.calculatePrice().multiply(discountRate);
        }

        return discountAmount.setScale(2, RoundingMode.FLOOR);
    }
}
