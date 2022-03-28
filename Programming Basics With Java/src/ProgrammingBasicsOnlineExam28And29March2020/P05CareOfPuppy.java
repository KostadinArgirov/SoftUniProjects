import java.util.Scanner;

public class P05CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int boughtFood = Integer.parseInt(scanner.nextLine());
        int availableFood = boughtFood * 1000;
        int eatenFoodSum = 0;

        String input = scanner.nextLine();

        while (!input.equals("Adopted")) {
            int currentFood = Integer.parseInt(input);
            eatenFoodSum += currentFood;

            input = scanner.nextLine();
        }
        if (availableFood >= eatenFoodSum) {
            System.out.printf("Food is enough! Leftovers: %d grams.", availableFood - eatenFoodSum);
        } else {
            System.out.printf("Food is not enough. You need %d grams more.", eatenFoodSum - availableFood);
        }
    }
}