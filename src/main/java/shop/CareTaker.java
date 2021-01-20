package shop;

import java.util.ArrayList;

public class CareTaker {

    private ArrayList<Memento> history;
    private int currentState = -1;

    public CareTaker() {
        this.history = new ArrayList<>();
    }

    public void addMemento(Memento memento) {
        this.history.add(memento);
        this.currentState = this.history.size() - 1;
    }

    public Memento getMemento(int index) {
        return history.get(index);
    }

    public Memento undo() {
        System.out.println("Undoing state...");
        if (currentState <= 0) {
            currentState = 0;
            System.out.println("No undone");
            return getMemento(0);
        }

        currentState--;
        System.out.println("Is undone" + currentState);
        return getMemento(currentState);
    }

    public Memento redo() {
        System.out.println("Redoing state...");
        if (currentState >= history.size() -1) {
            currentState = history.size() - 1;
            return getMemento(currentState);
        }

        currentState++;
        return getMemento(currentState);
    }

}
