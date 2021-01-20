package shop;

import java.util.Set;

public class Memento {

    private Set<ShoppingCartItem> state;

    public Memento(Set<ShoppingCartItem> state) {
        this.state = state;
    }

    public Set<ShoppingCartItem> getState() {
        return this.state;
    }

    public void setState(Set<ShoppingCartItem> state) {
        this.state = state;
    }

}
