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
        System.out.println("Undoing...");
        if (currentState <= 0) {
            currentState = 0;
            System.out.println("Could not undo, no more states to rewind to");
            return getMemento(0);
        }

        currentState--;
        return getMemento(currentState);
    }

    public Memento redo() {
        System.out.println("Redoing...");
        if (currentState >= history.size() -1) {
            currentState = history.size() - 1;
            System.out.println("Could not redo, this is the latest state");
            return getMemento(currentState);
        }

        currentState++;
        return getMemento(currentState);
    }

}
