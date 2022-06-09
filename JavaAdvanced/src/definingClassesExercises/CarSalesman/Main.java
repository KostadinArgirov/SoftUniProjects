package definingClassesExercises.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

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
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            Engine engine = engines.get(carInfo[1]);
            String weight = "n/a";
            String color = "n/a";
            if (carInfo.length > 2) {
                try {
                    int temp = Integer.parseInt(carInfo[2]);
                    weight = carInfo[2];
                    if (carInfo.length > 3) {
                        color = carInfo[3];
                    }
                } catch (Exception e) {
                    color = carInfo[2];
                }
            }
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        cars.forEach(System.out::print);
    }
}