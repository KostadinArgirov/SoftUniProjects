import java.util.Scanner;

public class P04FoodForPets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysNumber = Integer.parseInt(scanner.nextLine());
        double totalFoodAmount = Double.parseDouble(scanner.nextLine());
        double sumBiscuits = 0.0;
        double sumFoodEatenByDog = 0.0;
        double sumFoodEatenByCat = 0.0;
        double totalFoodEaten = 0.0;
        double percentOfEatenFood = 0.0;
        double percentFoodEatenByDog = 0.0;
        double percentFoodEatenByCat = 0.0;
        String percent = "%";

        for ( int i = 1; i <= daysNumber; i++) {
            int dogFoodEatenPerDay = Integer.parseInt(scanner.nextLine());
            int catFoodEatenPerDay = Integer.parseInt(scanner.nextLine());

            totalFoodEaten = totalFoodEaten + dogFoodEatenPerDay + catFoodEatenPerDay;
            sumFoodEatenByDog = sumFoodEatenByDog + dogFoodEatenPerDay;
            sumFoodEatenByCat = sumFoodEatenByCat + catFoodEatenPerDay;

            if (i % 3 == 0) {
                sumBiscuits = sumBiscuits + Math.round((dogFoodEatenPerDay + catFoodEatenPerDay)) * 0.1;
            }
        }
        percentOfEatenFood = (totalFoodEaten / totalFoodAmount) * 100;
        percentFoodEatenByDog = (sumFoodEatenByDog / totalFoodEaten) * 100;
        percentFoodEatenByCat = (sumFoodEatenByCat / totalFoodEaten) * 100;

        System.out.printf("Total eaten biscuits: %.0fgr.\n", sumBiscuits);
        System.out.printf("%.2f%s of the food has been eaten.\n", percentOfEatenFood, percent);
        System.out.printf("%.2f%s eaten from the dog.\n", percentFoodEatenByDog, percent);
        System.out.printf("%.2f%s eaten from the cat.\n", percentFoodEatenByCat, percent);
    }
}
