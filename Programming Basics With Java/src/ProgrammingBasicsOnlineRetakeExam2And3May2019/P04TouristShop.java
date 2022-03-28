import java.util.Scanner;

public class P04TouristShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        String productName = "";

        double totalSum = 0.0;
        int counter = 0;

        while (!"Stop".equals(productName = scanner.nextLine())) {
            double productPrice = Double.parseDouble(scanner.nextLine());

            counter++;

            if (counter % 3 == 0) {
                totalSum += productPrice / 2;
            } else {
                totalSum += productPrice;
            }
            if (totalSum > budget) {
                break;
            }
        }
        if (totalSum > budget) {
            System.out.printf("You don't have enough money!\nYou need %.2f leva!", totalSum - budget);
        } else {
            System.out.printf("You bought %d products for %.2f leva.", counter, totalSum);
        }
    }
}