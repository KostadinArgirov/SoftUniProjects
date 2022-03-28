import java.util.Scanner;

public class P07FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnoliaNumber = Integer.parseInt(scanner.nextLine());
        int hyacinthNumber = Integer.parseInt(scanner.nextLine());
        int roseNumber = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double presentPrice = Double.parseDouble(scanner.nextLine());

        double sum = magnoliaNumber * 3.25 + hyacinthNumber * 4 + roseNumber * 3.5 + cactus * 8;
        double tax = sum * 0.05;
        double profit = sum - tax;
        double moneyNeeded = Math.ceil(presentPrice - profit);

        if (presentPrice <= profit) {
            double moneyLeft = Math.floor(profit - presentPrice);
            System.out.printf("She is left with %.0f leva.", moneyLeft);
        } else {
            System.out.printf("She will have to borrow %.0f leva.", moneyNeeded);
        }

    }
}
