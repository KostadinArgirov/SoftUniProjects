package advanced.examPreparation.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }

    public void add(Car car) {
        if (this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return data.removeIf((c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model)));
    }

    public Car getLatestCar() {
        return this.data.stream()
                .sorted(Comparator.comparingInt(Car::getYear).reversed())
                .findFirst().orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        return "The cars are parked in " + this.type + ":" + System.lineSeparator() +
                this.data.stream().map(Car::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}