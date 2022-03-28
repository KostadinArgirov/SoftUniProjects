import java.util.Scanner;

public class P02AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bigSuitcasePrice = Double.parseDouble(scanner.nextLine());
        double luggageKilograms = Double.parseDouble(scanner.nextLine());
        int daysLeft = Integer.parseInt(scanner.nextLine());
        int luggageNumber = Integer.parseInt(scanner.nextLine());

        double luggagePrice = 0;


        if (luggageKilograms < 10) {
            luggagePrice = bigSuitcasePrice * 0.2;
        } else if (luggageKilograms >= 10 && luggageKilograms <= 20) {
            luggagePrice = bigSuitcasePrice * 0.5;
        } else {
            luggagePrice = bigSuitcasePrice;
        }
        if (daysLeft > 30) {
            luggagePrice *= 1.1;
        } else if (daysLeft >= 7) {
            luggagePrice *= 1.15;
        } else {
            luggagePrice *= 1.4;
        }
        System.out.printf("The total price of bags is: %.2f lv.", luggagePrice * luggageNumber);
    }
}