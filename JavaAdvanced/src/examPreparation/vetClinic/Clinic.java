package examPreparation.vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data
                .stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }


    public Pet getOldestPet() {
        return this.data
                .stream()
                .max(Comparator.comparingInt(Pet::getAge))
                .orElse(null);
//        работи по същия начин:
//        return this.data
//                .stream()
//                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
//                .findFirst()
//                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
//        това не сработи (92/100):
//        return "The clinic has the following patients:" + System.lineSeparator() +
//                this.data.stream().map(Pet::toString).collect(Collectors.joining(System.lineSeparator()));

        return "The clinic has the following patients:" +
                (this.data.isEmpty() ? "" : System.lineSeparator() +
                        this.data.stream()
                                .map(p -> String.format("%s %s", p.getName(), p.getOwner()))
                                .collect(Collectors.joining(System.lineSeparator())));
    }
}