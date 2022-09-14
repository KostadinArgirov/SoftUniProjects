package advanced.exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlates = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> cars = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(cars::push);

        int totalRegisteredCars = 0;
        int daysCount = 0;

        while (!(licensePlates.isEmpty() || cars.isEmpty())) {

            daysCount++;
            int currentLicensePlates = licensePlates.poll();
            int currentCars = cars.pop();

            int licensePlatesForASingleCar = currentLicensePlates / 2;

            if (licensePlatesForASingleCar > currentCars) {
                totalRegisteredCars += currentCars;
                int licensePlatesLeft = (licensePlatesForASingleCar - currentCars) * 2;
                licensePlates.offer(licensePlatesLeft);
            } else if (licensePlatesForASingleCar == currentCars) {
                totalRegisteredCars += currentCars;
            } else {
                totalRegisteredCars += licensePlatesForASingleCar;
                int carsLeft = currentCars - licensePlatesForASingleCar;
                cars.offer(carsLeft);
            }
        }

        System.out.printf("%d cars were registered for %d days!\n", totalRegisteredCars, daysCount);

        if (!licensePlates.isEmpty() && cars.isEmpty()) {
            int remainLicensePlates = 0;
            for (Integer licensePlate : licensePlates) {
                remainLicensePlates += licensePlate;
            }

            System.out.printf("%d license plates remain!", remainLicensePlates);
        } else if (!cars.isEmpty() && licensePlates.isEmpty()) {
            int carsWithoutRegistration = 0;

            for (Integer car : cars) {
                carsWithoutRegistration += car;
            }

            System.out.printf("%d cars remain without license plates!", carsWithoutRegistration);
        } else if (licensePlates.isEmpty() && cars.isEmpty())  {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}