import java.util.Scanner;

public class P09FuelTankPartTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelType = scanner.nextLine();
        double fuelAmount = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();

        double fuelPrice = 0;

        switch (fuelType) {
            case "Gas":
                if (discountCard.equals("Yes")) {
                    fuelPrice = fuelAmount * 0.85;
                } else {
                    fuelPrice = fuelAmount * 0.93;
                }
                break;
            case "Gasoline":
                if (discountCard.equals("Yes")) {
                    fuelPrice = fuelAmount * 2.04;
                } else {
                    fuelPrice = fuelAmount * 2.22;
                }
                break;
            case "Diesel":
                if (discountCard.equals("Yes")) {
                    fuelPrice = fuelAmount * 2.21;
                } else {
                    fuelPrice = fuelAmount * 2.33;
                }
                break;
        }
        if (fuelAmount >= 20 && fuelAmount <= 25) {
            fuelPrice *= 0.92;
        } else if (fuelAmount > 25) {
            fuelPrice *= 0.9;
        }
        System.out.printf("%.2f lv.", fuelPrice);
    }
}
