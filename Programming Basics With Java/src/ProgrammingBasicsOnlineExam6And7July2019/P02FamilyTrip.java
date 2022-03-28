import java.util.Scanner;

public class P02FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int percentSpending = Integer.parseInt(scanner.nextLine());

        double nightsPrice = nights * pricePerNight;
        if (nights > 7) {
            nightsPrice *= 0.95;
        }
        double otherSpending = budget * (percentSpending * 1.0 / 100);
        double totalSpentMoney = nightsPrice + otherSpending;

        if (totalSpentMoney <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalSpentMoney);
        } else {
            System.out.printf("%.2f leva needed.", totalSpentMoney - budget);
        }
    }
}