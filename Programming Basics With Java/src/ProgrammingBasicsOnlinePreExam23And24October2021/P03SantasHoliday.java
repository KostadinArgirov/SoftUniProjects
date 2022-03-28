import java.util.Scanner;

public class P03SantasHoliday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int nights = days - 1;
        String type = scanner.nextLine();
        String score = scanner.nextLine();

        double totalPrice = 0.0;

        switch (type) {
            case "room for one person":
                    totalPrice = nights * 18;
                break;
            case "apartment":
                if (nights < 10) {
                    totalPrice = nights * 25 * 0.7;
                } else if (nights <= 15) {
                    totalPrice = nights * 25 * 0.65;
                } else {
                    totalPrice = nights * 25 * 0.5;
                }
                break;
            case "president apartment":
                if (nights < 10) {
                    totalPrice = nights * 35 * 0.9;
                } else if (nights <= 15) {
                    totalPrice = nights * 35 * 0.85;
                } else {
                    totalPrice = nights * 35 * 0.8;
                }
                break;
        }
        if (score.equals("positive")) {
            totalPrice *= 1.25;
        } else if (score.equals("negative")) {
            totalPrice *= 0.9;
        }
        System.out.printf("%.2f", totalPrice);
    }
}