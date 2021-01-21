package shop;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShoppingCart {

    private Set<ShoppingCartItem> items = new HashSet<>();
    private DiscountHandler discountHandler = new DiscountHandler();
    private UndoRedoCareTaker careTaker = new UndoRedoCareTaker();

    public void addCartItem(ShoppingCartItem item){
        items.add(item);
        this.saveState();
    }

    public void removeCartItem(String itemName) {
        ShoppingCartItem itemToRemove = null;

        for (ShoppingCartItem item:items) {
            if(item.product().name().equals(itemName)) {
                itemToRemove = item;
            }
        }

        if (itemToRemove != null) {
            items.remove(itemToRemove);
            this.saveState();
            System.out.println(itemToRemove.product().name() + " was removed from the Shopping Cart");
        } else {
            System.out.println("Found no item to remove");
        }
    }

    public void changeItemQuantity(String itemName, int newQuantity) {
        ShoppingCartItem oldItem = null;
        ShoppingCartItem newItem = null;

        for (ShoppingCartItem item:items) {
            if(item.product().name().equals(itemName)) {
                newItem = new ShoppingCartItem(item.product(), item.itemCost().doubleValue(), newQuantity);
                oldItem = item;
            }
        }

        if (oldItem != null) {
            items.remove(oldItem);
            items.add(newItem);
            this.saveState();
            System.out.println("Quantity for " + newItem.product().name() + " was changed to: " + newItem.quantity());
        } else {
            System.out.println("Found no item to change");
        }
    }

    private void saveState() {
        Set<ShoppingCartItem> itemsToSave = new HashSet<>(this.items);
        careTaker.addMemento(new UndoRedoMemento(itemsToSave));
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
            sb.append(String.format("%-24s % 7.2f\n", "(" + each.quantity() + ") " + each.product().name(), each.itemCost()));
        }
        sb.append(line);
        sb.append(String.format("%24s% 8.2f", "TOTAL:", calculatePrice()));
        return sb.toString();
    }
}
