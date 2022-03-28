import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double movieBudget = Double.parseDouble(scanner.nextLine());
        int walkOnNumber = Integer.parseInt(scanner.nextLine());
        double outfitPrice = Double.parseDouble(scanner.nextLine());
        double movieDecor = movieBudget * 0.1;

        if (walkOnNumber > 150) {
            outfitPrice = outfitPrice * 0.9;
        }
        double totalCosts = movieDecor + outfitPrice * walkOnNumber;
        double moneyLeft = movieBudget - totalCosts;
        double moneyNeeded = totalCosts - movieBudget;
        if (totalCosts > movieBudget) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", moneyNeeded);
        } else if (totalCosts <= movieBudget) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", moneyLeft);
        }

    }
}
