package finalExamRetake;

import java.util.*;

public class P03NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int numberCars = Integer.parseInt(scanner.nextLine());
//
//        Map<String, List<Integer>> carList = new TreeMap<>();
//
//        for (int i = 0; i < numberCars; i++) {
//            String[] currentCarData = scanner.nextLine().split("\\|");
//            String car = currentCarData[0];
//            int mileage = Integer.parseInt(currentCarData[1]);
//            int fuel = Integer.parseInt(currentCarData[2]);
//
//            List<Integer> current = new LinkedList<>();
//            current.add(mileage);
//            current.add(fuel);
//            carList.put(car, current);
//        }
//
//        String line = scanner.nextLine();
//
//        while (!line.equals("Stop")) {
//            String[] data = line.split(" : ");
//            String command = data[0];
//            String car = data[1];
//            switch (command) {
//                case "Drive":
//                    int distance = Integer.parseInt(data[2]);
//                    int fuel = Integer.parseInt(data[3]);
//                    List<Integer> carData = carList.get(car);
//                    int distanceReal = carData.get(0);
//                    int fuelReal = carData.get(1);
//
//                    if (fuelReal < fuel) {
//                        System.out.println("Not enough fuel to make that ride");
//                    } else {
//                        distanceReal += distance;
//                        fuelReal -= fuel;
//                        carList.get(car).set(0, distanceReal);
//                        carList.get(car).set(1, fuelReal);
//                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
//                        if (distanceReal > 100000) {
//                            System.out.println(String.format("Time to sell the %s!", car));
//                            carList.remove(car);
//                            break;
//                        }
//                    }
//                    break;
//                case "Refuel":
//                    int fuelRefuel = Integer.parseInt(data[2]);
//                    int fuelRealTheMoment = carList.get(car).get(1);
//                    fuelRealTheMoment += fuelRefuel;
//                    if (fuelRealTheMoment >= 75) {
//                        fuelRefuel = (fuelRealTheMoment - 75) - fuelRefuel;
//                        fuelRealTheMoment = 75;
//                    }
//                    carList.get(car).set(1, fuelRealTheMoment);
//                    System.out.println(String.format("%s refueled with %d liters", car, Math.abs(fuelRefuel)));
//                    break;
//                case "Revert":
//                    int kilometers = Integer.parseInt(data[2]);
//                    int realDistance = carList.get(car).get(0);
//
//                    int revertDistance = realDistance - kilometers;
//                    if (revertDistance < 10000) {
//                        revertDistance = 10000;
//                    } else {
//                        System.out.println(String.format("%s mileage decreased by %d kilometers", car, kilometers));
//                    }
//                    carList.get(car).set(0, revertDistance);
//
//                    break;
//            }
//
//            line = scanner.nextLine();
//        }
//        carList
//                .entrySet()
//                .stream()
//                .sorted((a,b) -> b.getValue().get(1). compareTo(a.getValue().get(1)))
//                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue().get(0), e.getValue().get(1)));
//    }
//}


        int number = Integer.parseInt(scanner.nextLine());
        HashMap<String, Car> carList = new LinkedHashMap<>();
        for (int i = 0; i < number; i++) {
            String[] carAttribute = scanner.nextLine().split("\\|");
            String carName = carAttribute[0];
            int mileage = Integer.parseInt(carAttribute[1]);
            int fuel = Integer.parseInt(carAttribute[2]);
            Car singleCar = new Car(carName, mileage, fuel);
            carList.put(carName, singleCar);
        }
        String command;
        while (!"Stop".equals(command = scanner.nextLine())) {
            String[] commandAttribute = command.split(" : ");
            String event = commandAttribute[0];
            String carName = commandAttribute[1];
            switch (event) {
                case "Drive":
                    int distance = Integer.parseInt(commandAttribute[2]);
                    int fuel = Integer.parseInt(commandAttribute[3]);
                    if (carList.get(carName).getFuel() < fuel) System.out.println("Not enough fuel to make that ride");
                    else {
                        carList.get(carName).setMileage(carList.get(carName).getMileage() + distance);
                        carList.get(carName).setFuel(carList.get(carName).getFuel() - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);
                        if (carList.get(carName).getMileage() >= 100000) {
                            carList.remove(carName);
                            System.out.println("Time to sell the " + carName + "!");
                        }
                    }
                    break;
                case "Refuel":
                    fuel = Integer.parseInt(commandAttribute[2]);
                    if (carList.get(carName).getFuel() + fuel > 75) {
                        fuel = 75 - carList.get(carName).getFuel();
                        carList.get(carName).setFuel(75);
                    } else carList.get(carName).setFuel(carList.get(carName).getFuel() + fuel);
                    System.out.printf("%s refueled with %d liters%n", carName, fuel);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandAttribute[2]);
                    carList.get(carName).setMileage(carList.get(carName).getMileage() - kilometers);
                    if (carList.get(carName).getMileage() < 10000) carList.get(carName).setMileage(10000);
                    else System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    break;
            }
        }
        carList.forEach((key, value) -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                value.getCarName(), value.getMileage(), value.getFuel()));
    }

    static class Car {
        String carName;
        int mileage;
        int fuel;

        public String getCarName() {
            return carName;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public Car(String carName, int mileage, int fuel) {
            this.carName = carName;
            this.mileage = mileage;
            this.fuel = fuel;
        }
    }
}