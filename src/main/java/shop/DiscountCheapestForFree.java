package shop;

import java.math.BigDecimal;

public class DiscountCheapestForFree implements DiscountStrategy {
    @Override
    public BigDecimal calculateDiscount(ShoppingCart shoppingCart) {

        BigDecimal discountAmount = BigDecimal.ZERO;
        int qualifyingAmount = 6;
        ShoppingCartItem[] items = shoppingCart.stream().toArray(ShoppingCartItem[]::new);

        if (items.length >= qualifyingAmount) {
            ShoppingCartItem temp;
            for(int i=0; i < items.length; i++){
                for(int j=1; j < (items.length-i); j++){
                    if(items[j-1].itemCost().doubleValue() > items[j].itemCost().doubleValue()){
                        temp = items[j-1];
                        items[j-1] = items[j];
                        items[j] = temp;
                    }
                }
            }
            discountAmount = items[0].itemCost();
        }

        return discountAmount;
    }
}
