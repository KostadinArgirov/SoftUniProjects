package advanced.definingClassesLab.carConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        while (carsCount-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");

            String brand = data[0];

            Car car;
            if (data.length == 1) {
                car = new Car(brand);
            } else {
                String model = data[1];
                int horsePower = Integer.parseInt(data[2]);
                car = new Car(brand, model, horsePower);
            }

            System.out.println(car.carInfo());
        }
    }
}