import java.util.Scanner;

public class P03FilmPremiere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String add = scanner.nextLine();
        int ticketsNumber = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (movie) {
            case "John Wick":
                if (add.equals("Drink")) {
                    price = 12 * ticketsNumber;
                } else if (add.equals("Popcorn")) {
                    price = 15 * ticketsNumber;
                } else if (add.equals("Menu")) {
                    price = 19 * ticketsNumber;
                }
                break;
            case "Star Wars":
                if (add.equals("Drink")) {
                    price = 18 * ticketsNumber;
                } else if (add.equals("Popcorn")) {
                    price = 25 * ticketsNumber;
                } else if (add.equals("Menu")) {
                    price = 30 * ticketsNumber;
                }
                break;
            case "Jumanji":
                if (add.equals("Drink")) {
                    price = 9 * ticketsNumber;
                } else if (add.equals("Popcorn")) {
                    price = 11 * ticketsNumber;
                } else if (add.equals("Menu")) {
                    price = 14 * ticketsNumber;
                }
                break;
        }
        if (movie.equals("Star Wars") && ticketsNumber >= 4) {
            price *= 0.7;
        }
        if (movie.equals("Jumanji") && ticketsNumber == 2) {
            price *= 0.85;
        }
        System.out.printf("Your bill is %.2f leva.", price);
    }
}