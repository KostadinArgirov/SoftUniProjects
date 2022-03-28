import java.util.Scanner;

public class P03CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drinkType = scanner.nextLine();
        String sugar = scanner.nextLine();
        int drinksNumber = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0.0;

        switch (drinkType) {
            case "Espresso":
                if (sugar.equals("Without")) {
                    totalPrice = drinksNumber * 0.9;
                } else if (sugar.equals("Normal")) {
                    totalPrice = drinksNumber;
                } else if (sugar.equals("Extra")) {
                    totalPrice = drinksNumber * 1.2;
                }
                break;
            case "Cappuccino":
                if (sugar.equals("Without")) {
                    totalPrice = drinksNumber;
                } else if (sugar.equals("Normal")) {
                    totalPrice = drinksNumber * 1.2;
                } else if (sugar.equals("Extra")) {
                    totalPrice = drinksNumber * 1.6;
                }
                break;
            case "Tea":
                if (sugar.equals("Without")) {
                    totalPrice = drinksNumber * 0.5;
                } else if (sugar.equals("Normal")) {
                    totalPrice = drinksNumber * 0.6;
                } else if (sugar.equals("Extra")) {
                    totalPrice = drinksNumber * 0.7;
                }
                break;
        }
        if (sugar.equals("Without")) {
            totalPrice *= 0.65;
        }
        if (drinksNumber >= 5 && drinkType.equals("Espresso")) {
            totalPrice *= 0.75;
        }
        if (totalPrice > 15) {
            totalPrice *= 0.80;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", drinksNumber, drinkType, totalPrice);
    }
}