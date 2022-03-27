package objectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P06VehicleCatalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Vehicle> vehicleList = new ArrayList<>();


        while (!input.equals("End")) {
            String[] commands = input.split(" ");

            Vehicle vehicle = new Vehicle(commands[0], commands[1], commands[2], Integer.parseInt(commands[3]));
            vehicleList.add(vehicle);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("Close the Catalogue")) {
            String model = input;

            vehicleList.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            input = scanner.nextLine();
        }
        List<Vehicle> cars = vehicleList.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        List<Vehicle> trucks = vehicleList.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        double carsAvgHp = avgHp(cars);
        double trucksAvgHp = avgHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.%n" +
                "Trucks have average horsepower of: %.2f.%n", carsAvgHp, trucksAvgHp);
    }

    static double avgHp(List<Vehicle> vehicles) {
        if (vehicles.size() == 0) {
            return 0;
        } else {
           return vehicles.stream().mapToDouble(Vehicle::getHorsepower).sum() / vehicles.size();
        }
    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsepower;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(int horsepower) {
            this.horsepower = horsepower;
        }

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d", getType().toUpperCase().charAt(0) + getType().substring(1), getModel(), getColor(), getHorsepower());
        }
    }
}