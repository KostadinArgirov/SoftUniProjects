import java.util.Scanner;

public class P03MovieDestination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (destination) {
            case "Dubai":
                if (season.equals("Summer")) {
                    price = 40000 * days;
                } else if (season.equals("Winter")) {
                    price = 45000 * days;
                }
                break;
            case "Sofia":
                if (season.equals("Summer")) {
                    price = 12500 * days;
                } else if (season.equals("Winter")) {
                    price = 17000 * days;
                }
                break;
            case "London":
                if (season.equals("Summer")) {
                    price = 20250 * days;
                } else if (season.equals("Winter")) {
                    price = 24000 * days;
                }
                break;
        }
        if (destination.equals("Dubai")) {
            price *= 0.7;
        }
        if (destination.equals("Sofia")) {
            price *= 1.25;
        }
        if (budget >= price) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - price);
        } else {
            System.out.printf("The director needs %.2f leva more!", price - budget);
        }
    }
}