package definingClassesExercises.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");

            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double fuelCostFor1Km = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1Km);
            map.put(model, car);
        }

        String line;

        while (!"End".equals(line = scanner.nextLine())) {

            String[] input = line.split("\\s+");
            String carName = input[1];
            Double km = Double.parseDouble(input[2]);
            if (!map.get(carName).drive(km)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        map.values().forEach(System.out::println);
    }
}