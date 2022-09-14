package advanced.exam.sanctuary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Habitat {
    private Collection<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.data.size() < this.capacity) {
            this.data.add(elephant);
        }
    }


    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));
    }


    public Elephant getElephant(String retiredFrom) {
        return data.stream()
                .filter(e -> e.getRetiredFrom().equals(retiredFrom))
                .findFirst()
                .orElse(null);
    }


    public Elephant getOldestElephant() {
        return data.stream()
                .sorted(Comparator.comparingInt(Elephant::getAge).reversed())
                .findFirst()
                .orElse(null);
    }

    public int getAllElephants() {
        return this.data.size();
    }

    public String getReport() {
        return "Saved elephants in the park:" + (this.data.isEmpty() ? "" :
                System.lineSeparator() +
                        this.data.stream().map(e -> e.getName() + " came from: " + e.getRetiredFrom())
                                .collect(Collectors.joining(System.lineSeparator())));
    }
}
