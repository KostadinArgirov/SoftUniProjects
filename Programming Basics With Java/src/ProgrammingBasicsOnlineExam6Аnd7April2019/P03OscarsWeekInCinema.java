import java.util.Scanner;

public class P03OscarsWeekInCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String hall = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        switch (name) {
            case "A Star Is Born":
                if (hall.equals("normal")) {
                    price = 7.5;
                } else if (hall.equals("luxury")) {
                    price = 10.5;
                } else if (hall.equals("ultra luxury")) {
                    price = 13.5;
                }
                break;
            case "Bohemian Rhapsody":
                if (hall.equals("normal")) {
                    price = 7.35;
                } else if (hall.equals("luxury")) {
                    price = 9.45;
                } else if (hall.equals("ultra luxury")) {
                    price = 12.75;
                }
                break;
            case "Green Book":
                if (hall.equals("normal")) {
                    price = 8.15;
                } else if (hall.equals("luxury")) {
                    price = 10.25;
                } else if (hall.equals("ultra luxury")) {
                    price = 13.25;
                }
                break;
            case "The Favourite":
                if (hall.equals("normal")) {
                    price = 8.75;
                } else if (hall.equals("luxury")) {
                    price = 11.55;
                } else if (hall.equals("ultra luxury")) {
                    price = 13.95;
                }
                break;
        }
        System.out.printf("%s -> %.2f lv.", name, price * tickets);
    }
}