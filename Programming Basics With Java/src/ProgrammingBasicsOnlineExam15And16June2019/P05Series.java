import java.util.Scanner;

public class P05Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int seriesNumber = Integer.parseInt(scanner.nextLine());

        double totalSum = 0.0;

        for (int i = 0; i < seriesNumber; i++) {
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());

            switch (name) {
                case "Thrones":
                    totalSum = totalSum + price * 0.5;
                    break;
                case "Lucifer":
                    totalSum = totalSum + price * 0.6;
                    break;
                case "Protector":
                    totalSum = totalSum + price * 0.7;
                    break;
                case "TotalDrama":
                    totalSum = totalSum + price * 0.8;
                    break;
                case "Area":
                    totalSum = totalSum + price * 0.9;
                    break;
                default:
                    totalSum = totalSum + price;
                    break;
            }
        }
        if (budget >= totalSum) {
            System.out.printf("You bought all the series and left with %.2f lv.", budget - totalSum);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", totalSum - budget);
        }
    }
}