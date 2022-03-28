import java.util.Scanner;

public class P06Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysNumber = Integer.parseInt(scanner.nextLine());
        int foodKg = Integer.parseInt(scanner.nextLine());
        double dogFoodDayKg = Double.parseDouble(scanner.nextLine());
        double catFoodDayKg = Double.parseDouble(scanner.nextLine());
        double turtleFoodDayGr = Double.parseDouble(scanner.nextLine());

        double turtleFoodDayKg = turtleFoodDayGr / 1000;
        double dogFoodNeeded = daysNumber * dogFoodDayKg;
        double catFoodNeeded = daysNumber * catFoodDayKg;
        double turtleFoodNeeded = daysNumber * turtleFoodDayKg;
        double totalFoodNeededKg = dogFoodNeeded + catFoodNeeded + turtleFoodNeeded;
        double totalFoodLeft = Math.floor(foodKg - totalFoodNeededKg);

        if (foodKg >= totalFoodNeededKg) {
            System.out.printf("%.0f kilos of food left.", totalFoodLeft);
        } else {
            double foodMissingKg = Math.ceil(totalFoodNeededKg - foodKg);
            System.out.printf("%.0f more kilos of food are needed.", foodMissingKg);
        }

    }
}
