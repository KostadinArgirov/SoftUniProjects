import java.util.Scanner;

public class P02EasterParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        double pricePerPerson = Double.parseDouble(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());

        if (guests >= 10 && guests <= 15) {
            pricePerPerson *= 0.85;
        } else if (guests > 15 && guests <= 20) {
            pricePerPerson *= 0.8;
        } else if (guests > 20) {
            pricePerPerson *= 0.75;
        }
        double cakePrice = budget * 0.1;

        double totalPrice = guests * pricePerPerson + cakePrice;

        if (budget >= totalPrice) {
            System.out.printf("It is party time! %.2f leva left.", budget - totalPrice);
        } else {
            System.out.printf("No party! %.2f leva needed.", totalPrice - budget);
        }
    }
}