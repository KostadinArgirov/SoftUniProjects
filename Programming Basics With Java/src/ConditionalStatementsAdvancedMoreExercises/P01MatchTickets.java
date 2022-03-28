import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String ticketType = scanner.nextLine();
        int peopleNumber = Integer.parseInt(scanner.nextLine());
        double transport = 0.0;
        double moneyLeft = 0.0;
        double moneyNeeded = 0.0;
        double ticketsPrice = 0.0;

        if (peopleNumber >= 1 && peopleNumber <= 4) {
            transport = budget * 0.75;
        } else if (peopleNumber >= 5 && peopleNumber <= 9) {
            transport = budget * 0.6;
        } else if (peopleNumber >= 10 && peopleNumber <= 24) {
            transport = budget * 0.5;
        } else if (peopleNumber >= 25 && peopleNumber <= 49) {
            transport = budget * 0.4;
        } else if (peopleNumber >= 50) {
            transport = budget * 0.25;
        }
        switch (ticketType) {
            case "VIP":
                ticketsPrice = peopleNumber * 499.99;
                if (ticketsPrice <= (budget - transport)) {
                    moneyLeft = (budget - transport) - ticketsPrice;
                    System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
                } else {
                    moneyNeeded = ticketsPrice - (budget - transport);
                    System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
                }
                break;
            case "Normal":
                ticketsPrice = peopleNumber * 249.99;
                if (ticketsPrice <= (budget - transport)) {
                    moneyLeft = (budget - transport) - ticketsPrice;
                    System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
                } else {
                    moneyNeeded = ticketsPrice - (budget - transport);
                    System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
                }
                break;
        }
    }
}
