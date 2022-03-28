import java.util.Scanner;

public class P02Safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuelNeeded = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();

        double totalPrice = fuelNeeded * 2.1 + 100;

        if (day.equals("Saturday")) {
            totalPrice *= 0.9;
        } else if (day.equals("Sunday")) {
            totalPrice *= 0.8;
        }
        if (totalPrice <= budget) {
            System.out.printf("Safari time! Money left: %.2f lv.", budget - totalPrice);
        } else {
            System.out.printf("Not enough money! Money needed: %.2f lv.", totalPrice - budget);
        }
    }
}