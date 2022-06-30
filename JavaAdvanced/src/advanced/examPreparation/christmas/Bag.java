package advanced.examPreparation.christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private List<Present> data;
    private String color;
    private int capacity;

    public Bag(String color, int capacity) {
        this.data = new ArrayList<>();
        this.color = color;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.capacity) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .max(Comparator.comparing(Present::getWeight))
                .orElse(null);
    }

    public Present getPresent(String name) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public String report() {
        return this.color + " bag contains:" + System.lineSeparator() +
        this.data.stream()
                .map(Present::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}