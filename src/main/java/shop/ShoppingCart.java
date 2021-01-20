package shop;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart {

    private Set<ShoppingCartItem> items = new HashSet<>();
    private DiscountHandler discountHandler = new DiscountHandler();
    private CareTaker careTaker = new CareTaker();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
        Set<ShoppingCartItem> items = new HashSet<>(this.items);
        careTaker.addMemento(new Memento(items));
        // System.out.println("MEMENTO: " + careTaker.getMemento(0).getState());
        // System.out.println("THIS: " + this.items);
    }

    public Stream<ShoppingCartItem> stream(){
        return items.stream();
    }

    public BigDecimal calculatePrice(){
        var sum = BigDecimal.ZERO;

        for (var item: items) {
            sum = item.itemCost().multiply(BigDecimal.valueOf(item.quantity())).add(sum);
        }
        return sum;
    }

    public BigDecimal calculateDiscount() {
        return discountHandler.calculateDiscount(this);
    }

    public BigDecimal calculatePriceWithDiscount() {
        return this.calculatePrice().subtract(calculateDiscount());
    }

    public void undo(){
        this.items = careTaker.undo().getState();
    }

    public void redo(){
        this.items = careTaker.redo().getState();
    }

    public String receipt() {
        String line = "--------------------------------\n";
        StringBuilder sb = new StringBuilder();
        sb.append(line);
        var list = items.stream()
                .sorted(Comparator.comparing(item -> item.product().name()))
                .collect(Collectors.toList());
        for (var each : list) {
            sb.append(String.format("%-24s % 7.2f\n", each.product().name(), each.itemCost()));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice()));
        return sb.toString();
    }
}
