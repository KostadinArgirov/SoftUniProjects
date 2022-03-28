import java.util.Scanner;

public class P02DeerOfSanta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int foodLeft = Integer.parseInt(scanner.nextLine());
        double foodPerDayDeer1 = Double.parseDouble(scanner.nextLine());
        double foodPerDayDeer2 = Double.parseDouble(scanner.nextLine());
        double foodPerDayDeer3 = Double.parseDouble(scanner.nextLine());

        double deer1FoodNeeded = days * foodPerDayDeer1;
        double deer2FoodNeeded = days * foodPerDayDeer2;
        double deer3FoodNeeded = days * foodPerDayDeer3;
        double totalFoodNeeded = deer1FoodNeeded + deer2FoodNeeded + deer3FoodNeeded;

        if (foodLeft >= totalFoodNeeded) {
            System.out.printf("%.0f kilos of food left.", Math.floor(foodLeft - totalFoodNeeded));
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(totalFoodNeeded - foodLeft));
        }
    }
}