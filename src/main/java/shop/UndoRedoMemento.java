package shop;

import java.util.Set;

public class UndoRedoMemento {

    private Set<ShoppingCartItem> state;

    public UndoRedoMemento(Set<ShoppingCartItem> state) {
        this.state = state;
    }

    public Set<ShoppingCartItem> getState() {
        return this.state;
    }

}
