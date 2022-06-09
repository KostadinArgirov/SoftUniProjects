package definingClassesExercises.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        while (numberOfEngines-- > 0) {

            String[] engineData = scanner.nextLine().split("\\s+");
            String engineModel = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            String displacement = "n/a";
            String efficiency = "n/a";
            if (engineData.length > 2) {
                try {
                    int temp = Integer.parseInt(engineData[2]);
                    displacement = engineData[2];
                    if (engineData.length > 3) {
                        efficiency = engineData[3];
                    } else {
                        efficiency = "n/a";
                    }
                } catch (Exception e) {
                    efficiency = engineData[2];
                    displacement = "n/a";
                }
            }
            Engine engine = new Engine(engineModel, power, displacement, efficiency);
            engines.put(engineModel, engine);
        }
        List<Car> cars = new ArrayList<>();
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = engines.get(input[1]);
            String weight = "n/a";
            String color = "n/a";
            if (input.length > 2) {
                try {
                    int temp = Integer.parseInt(input[2]);
                    weight = input[2];
                    if (input.length > 3) {
                        color = input[3];
                    }
                } catch (Exception e) {
                    color = input[2];
                }
            }
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        cars.forEach(System.out::print);
    }
}