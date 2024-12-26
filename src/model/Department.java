package model;

public abstract class Department {
    private String name;
    private Human head;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    @Override
    public String toString() {
        return String.format("%s (Head: %s)", name, head);
    }
}
