package shop;

import java.math.BigDecimal;

public interface DiscountStrategy {
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart);
}
