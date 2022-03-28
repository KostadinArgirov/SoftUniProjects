import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String accommodation = scanner.nextLine();
        String feedback = scanner.nextLine();
        double pricePerNight = 0;
        int nights = days - 1;
        double discount = 0;

        switch (accommodation) {
            case "room for one person":
                pricePerNight = 18;
                break;
            case "apartment":
                pricePerNight = 25;
                if (nights < 10) {
                    discount = 0.3;
                } else if (nights <= 15) {
                    discount = 0.35;
                } else if (nights > 15) {
                    discount = 0.5;
                }
                break;
            case "president apartment":
                pricePerNight = 35;
                if (nights < 10) {
                    discount = 0.1;
                } else if (nights <= 15) {
                    discount = 0.15;
                } else if (nights > 15) {
                    discount = 0.2;
                }

                break;
        }
        double totalPrice = pricePerNight * nights;
        totalPrice = totalPrice - totalPrice * discount;

        if (feedback.equals("positive")) {
            totalPrice *= 1.25;
        } else if (feedback.equals("negative")) {
            totalPrice *= 0.90;
        }
        System.out.printf("%.2f", totalPrice);
    }
}
