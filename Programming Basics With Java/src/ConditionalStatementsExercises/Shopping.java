import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            double budget = Double.parseDouble(scanner.nextLine());
            int videoCards = Integer.parseInt(scanner.nextLine());
            int processors = Integer.parseInt(scanner.nextLine());
            int ram = Integer.parseInt(scanner.nextLine());
            int videoCardPrice = 250;
            double processorPrice = (videoCards * videoCardPrice) * 0.35;
            double ramPrice = (videoCards * videoCardPrice) * 0.10;
            double totalPrice = videoCards * videoCardPrice + processors * processorPrice + ram * ramPrice;

            if (videoCards > processors) {
                totalPrice = totalPrice * 0.85;
            }

            double moneyLeft = budget - totalPrice;
            double moneyNeeded = totalPrice - budget;

            if (budget >= totalPrice) {
                System.out.printf("You have %.2f leva left!", moneyLeft);
            } else {
                System.out.printf("Not enough money! You need %.2f leva more!", moneyNeeded);
            }

    }
}
