package midExamRetake;

import java.util.Scanner;

public class P01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double priceWithoutTaxes = 0;

        while (true) {
            if (input.equals("special") || input.equals("regular")) {
                break;
            }
            double currentPrice = Double.parseDouble(input);

            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            priceWithoutTaxes += currentPrice;


            input = scanner.nextLine();
        }
        if (priceWithoutTaxes == 0) {
            System.out.println("Invalid order!");
            return;
        }
        double taxes = priceWithoutTaxes * 0.2;
        double finalPrice = priceWithoutTaxes + taxes;

        if (input.equals("special")) {
            finalPrice *= 0.9;
        }
        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$\n", priceWithoutTaxes);
        System.out.printf("Taxes: %.2f$\n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$", finalPrice);
    }
}